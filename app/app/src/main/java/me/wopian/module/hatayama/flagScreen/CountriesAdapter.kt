package me.wopian.module.hatayama.flagScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.neovisionaries.i18n.CountryCode
import kotlinx.android.synthetic.main.countries_list_item.view.*
import me.wopian.module.hatayama.R
import me.wopian.module.hatayama.getFlagResource
import java.util.*

class CountriesAdapter(private val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.countries_list_item, parent, false)
        val result = ViewHolder(view)

        view.findViewById<CardView>(R.id.countryCard).setOnClickListener {
            val nameToCode = CountryCode.findByName(result.itemCountryName.text.toString())[0].toString()
            // TODO: AF data is hardcoded until database is populated
            if (nameToCode.isNotEmpty()) {
                val bundle = bundleOf("TO_COUNTRY" to nameToCode)
                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_countries_to_country, bundle)
            } else {
                // No data available
                val bundle = bundleOf("TO_COUNTRY" to nameToCode)
                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_countries_to_no_country, bundle)
            }
        }
        return result
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val code = items[position]
        val countryName = CountryCode.getByCode(code.toUpperCase(Locale.ROOT)).getName()

        holder.itemCountryName.text = countryName
        // holder.itemCountryFlag.setImageResource(getFlagResource(code))
        holder.itemCountryFlag.setImageResource(getFlagResource(context, code))
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val itemCountryName: TextView = view.item_country_name
        val itemCountryFlag: ImageView = view.item_country_flag

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
