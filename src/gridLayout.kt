rv_continents_list.layoutManager = GridLayoutManager(
  requireContext(), 2
)
rv_continents_list.adapter = ContinentsAdapter(
  continents, requireContext()
)
