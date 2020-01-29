package me.wopian.module.hatayama.flagScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_continents.*
import me.wopian.module.hatayama.R

/**
 * Shows the main title screen with a button that navigates to [Countries].
 */
class Continents : Fragment() {
    private val continents: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_continents, container, false)

        addContinents()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_continents_list.layoutManager = GridLayoutManager(requireContext(), 2)
        rv_continents_list.adapter = ContinentsAdapter(continents, requireContext())
    }

    private fun addContinents() {
        if (continents.size == 0) {
            continents.add("Asia")
            continents.add("Africa")
            continents.add("North America")
            continents.add("South America")
            continents.add("Europe")
            continents.add("Oceania")
        }
    }
}
