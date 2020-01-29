package me.wopian.module.hatayama.flagScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_countries.*
import me.wopian.module.hatayama.R

/**
 * Shows "Countries"
 */
class Countries : Fragment() {
    private val countries: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val continent = arguments?.getString("TO_CONTINENT")

        (activity as AppCompatActivity).supportActionBar?.title = continent

        addCountries(continent)

        rv_countries_list.layoutManager = LinearLayoutManager(this.context)
        rv_countries_list.adapter = CountriesAdapter(countries, requireContext())
    }

    private fun addCountries(fromContinent: String?) {
        if (countries.size == 0) {
            when (fromContinent) {
                "Asia" -> {
                    countries.add("af")
                    countries.add("am")
                    countries.add("az")
                    countries.add("bh")
                    countries.add("bd")
                    countries.add("bt")
                    countries.add("bn")
                    countries.add("kh")
                    countries.add("cn")
                    countries.add("ge")
                    countries.add("hk")
                    countries.add("in")
                    countries.add("id")
                    countries.add("ir")
                    countries.add("iq")
                    countries.add("il")
                    countries.add("jp")
                    countries.add("jo")
                    countries.add("kz")
                    countries.add("kw")
                    countries.add("kg")
                    countries.add("la")
                    countries.add("lb")
                    countries.add("mo")
                    countries.add("my")
                    countries.add("mv")
                    countries.add("mn")
                    countries.add("mm")
                    countries.add("np")
                    countries.add("kp")
                    countries.add("om")
                    countries.add("pk")
                    countries.add("ph")
                    countries.add("qa")
                    countries.add("sa")
                    countries.add("sg")
                    countries.add("kr")
                    countries.add("lk")
                    countries.add("sy")
                    countries.add("tw")
                    countries.add("tj")
                    countries.add("th")
                    countries.add("tr")
                    countries.add("tm")
                    countries.add("ae")
                    countries.add("uz")
                    countries.add("vn")
                    countries.add("ye")
                }
                "Africa" -> {
                    countries.add("dz")
                    countries.add("ao")
                    countries.add("bj")
                    countries.add("bw")
                    countries.add("bf")
                    countries.add("bi")
                    countries.add("cm")
                    countries.add("cv")
                    countries.add("cf")
                    countries.add("km")
                }
                "North America" -> {
                    countries.add("ai")
                    countries.add("ag")
                    countries.add("aw")
                    countries.add("bs")
                    countries.add("bb")
                    countries.add("bz")
                    countries.add("bm")
                    countries.add("bq")
                    countries.add("vg")
                    countries.add("ca")
                }
                "South America" -> {
                    countries.add("ar")
                    countries.add("bo")
                    countries.add("br")
                    countries.add("cl")
                    countries.add("co")
                    countries.add("ec")
                    countries.add("fk")
                    countries.add("gf")
                    countries.add("gy")
                    countries.add("py")
                }
                "Europe" -> {
                    countries.add("al")
                    countries.add("ad")
                    countries.add("at")
                    countries.add("by")
                    countries.add("be")
                    countries.add("ba")
                    countries.add("bg")
                    countries.add("hr")
                    countries.add("cy")
                    countries.add("cz")
                }
                "Oceania" -> {
                    countries.add("as")
                    countries.add("au")
                    countries.add("ck")
                    countries.add("tl")
                    countries.add("fj")
                    countries.add("pf")
                    countries.add("gu")
                    countries.add("ki")
                    countries.add("mh")
                    countries.add("fm")
                }
            }
        }
    }
}
