package me.wopian.module.hatayama.flagScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.continents_list_item.view.*
import me.wopian.module.hatayama.R

class ContinentsAdapter(private val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ContinentsAdapter.ViewHolder>() {
    /*
    override fun getItemCount(): Int {
        return items.size
    }
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.continents_list_item, parent, false)
        val result = ViewHolder(view)

        view.findViewById<CardView>(R.id.continentCard).setOnClickListener {
            val bundle = bundleOf("TO_CONTINENT" to result.itemContinentName.text.toString())
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_continents_to_countries, bundle)
        }
        return result
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val continentName = items[position]
        holder.itemContinentName.text = continentName
        val flagCount = if (continentName == "Asia") 47 else 10 // TODO: Pre-filled most flags for Asia only
        holder.itemFlagCount.text = "$flagCount flags"
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal t
        val itemContinentName: TextView = view.item_continent_name
        val itemFlagCount: TextView = view.item_flag_count
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

/*
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal t
    val itemContinentName = view.item_continent_name
    val itemFlagCount = view.item_flag_count
    /*
    val itemContinentName = view.findViewById<View>(R.id.item_continent_name)
    val itemFlagCount = view.findViewById<View>(R.id.item_flag_count)
     */
}

 */