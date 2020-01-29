view.findViewById<CardView>(R.id.continentCard).setOnClickListener {
  val bundle = bundleOf(
    "TO_CONTINENT" to result.itemContinentName.text.toString()
  )
  val navController = Navigation.findNavController(view)
  navController.navigate(R.id.action_continents_to_countries, bundle)
}
