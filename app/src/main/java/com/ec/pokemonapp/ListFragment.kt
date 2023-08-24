package com.ec.pokemonapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {

    interface PokemonSelectListener{
        fun onPokemonSelected(pokemon:Pokemon)

    }

    private lateinit var pokemonSelectListener: PokemonSelectListener

    override fun onAttach(context: Context) {

        super.onAttach(context)

        pokemonSelectListener = try {
            context as PokemonSelectListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context debe implementar PokemonSelectListener")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter



        adapter.onItemClickListener = {
            //Toast.makeText(requireActivity(), it.name, Toast.LENGTH_LONG).show()
            pokemonSelectListener.onPokemonSelected(it) //ahi se ejecuta el metodo del main, es una forma de pasar un mejor para lllamar desde un fragment
      //      (activity as MainActivity).onListenerPokemon(it) //forma sencilla de pasar pero no sabe de donde osea no reconoce al fragment
        }
        //AQUI IRIA EL API
        val pokemonList: MutableList<Pokemon> = mutableListOf(

            Pokemon(1, "Bulbasur", 45, 49, 49, 45, Pokemon.PokemonType.GRASS,"https://images.wikidexcdn.net/mwuploads/wikidex/7/74/latest/20230210210358/EP1230_Bulbasaur_de_Ash.png",R.raw.bulbasur),
            Pokemon(2, "Ivysur", 60, 49, 49, 45, Pokemon.PokemonType.GRASS,"https://static.wikia.nocookie.net/pokemon/images/b/b7/Shauna_Ivysaur.png",R.raw.ivysour),
            Pokemon(3, "Venuasaur", 25, 49, 49, 45, Pokemon.PokemonType.GRASS,"https://www.mundodeportivo.com/alfabeta/hero/2023/04/imagen_general-copia.1682768034.7113.jpg",R.raw.venusaur),
            Pokemon(4, "Charmander", 15, 69, 39, 25, Pokemon.PokemonType.FIRE,"https://easycdn.es/1/imagenes/pokemaster_338177_pn3.jpg",R.raw.charmander),
            Pokemon(5, "Charmaleon", 25, 29, 59, 15, Pokemon.PokemonType.FIRE,"https://i.pinimg.com/originals/80/42/50/8042507726c9558b011c25c0ca4ecac8.png",R.raw.charmaleon),
            Pokemon(6, "Charizzard", 35, 59, 49, 25, Pokemon.PokemonType.FIRE,"https://archives.bulbagarden.net/media/upload/thumb/7/7a/Ash_Charizard.png/1200px-Ash_Charizard.png",R.raw.charizard),
            Pokemon(7, "Squirtle", 45, 89, 9, 45, Pokemon.PokemonType.WATER,"https://images.wikidexcdn.net/mwuploads/wikidex/c/ca/latest/20230810154313/EP1230_Squirtle_de_Ash.png",R.raw.squirtle),
            Pokemon(8, "Wartortle", 15, 69, 29, 45, Pokemon.PokemonType.WATER,"https://facts.net/wp-content/uploads/2023/07/14-facts-about-wartortle-1689270595.jpg",R.raw.warturtlt),
            Pokemon(9, "Blastoise", 25, 39, 29, 45, Pokemon.PokemonType.WATER,"https://assetsio.reedpopcdn.com/pokemon_go_mega_blastoise_thumbnail.jpg",R.raw.blastoise),
            Pokemon(10, "Pikachu", 25, 39, 29, 45, Pokemon.PokemonType.ELECTRIC,"https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2022/11/pikachu-pokemon-escarlata-purpura-2888180.jpg",R.raw.pikachu),
            Pokemon(11, "Raichu", 25, 39, 29, 45, Pokemon.PokemonType.ELECTRIC,"https://i.pinimg.com/originals/1d/b3/2c/1db32c609b22235101e52e7efb26d695.jpg",R.raw.raichu),
            )

        adapter.submitList(pokemonList)


        return view
    }


}