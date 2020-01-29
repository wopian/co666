package me.wopian.module.hatayama.flagScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.neovisionaries.i18n.CountryCode
import kotlinx.android.synthetic.main.fragment_country.*
import me.wopian.module.hatayama.R
import me.wopian.module.hatayama.getFlagResource
import java.util.*

/**
 * Shows "Countries"
 */
class Country : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countryCode = arguments?.getString("TO_COUNTRY")
        val countryName = if(!countryCode.isNullOrEmpty()) CountryCode.getByCode(countryCode.toUpperCase(Locale.ROOT)).getName() else ""

        (activity as AppCompatActivity).supportActionBar?.title = countryName

        country_flag.setImageResource(getFlagResource(resources, countryCode?.toLowerCase(Locale.ENGLISH)))
        // country_flag.setImageResource(R.drawable.flag_af)
        // val countryCodeFlag = "flag_${countryCode?.toLowerCase(Locale.ENGLISH)}"
        // country_flag.setImageResource(resources.getIdentifier(countryCodeFlag, "drawable", "me.wopian.module.hatayama"))

        if (populateData(countryCode)) {
        }
    }

    private fun populateData(forCountry: String?): Boolean {
        return forCountry == "AF"
    }
}

/*
module:id="@+id/country_name_of_flag_label"
module:id="@+id/country_name_of_flag_answer"
module:id="@+id/country_proportion_label"
module:id="@+id/country_proportion_answer"
module:id="@+id/country_adopted_label"
module:id="@+id/country_adopted_answer"
module:id="@+id/country_main_colours_label"
module:id="@+id/country_main_colours_answer"
module:id="@+id/country_iso_3166-1_alpha_2_label"
module:id="@+id/country_iso_3166-1_alpha_2_answer"
module:id="@+id/country_status_label"
module:id="@+id/country_status_answer"
module:id="@+id/country_languages_label"
module:id="@+id/country_languages_answer"


 */