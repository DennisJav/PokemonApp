package com.ec.pokemonapp

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container,false)

        val recycler = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
        recycler.layoutManager=LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            Toast.makeText(requireActivity(),it.name, Toast.LENGTH_LONG).show()
        }
        //AQUI IRIA EL API
        val pokemonList : MutableList<Pokemon> = mutableListOf(

            Pokemon(1,"Bulbasur", 45,49,49,45, Pokemon.PokemonType.GRASS),
            Pokemon(1,"Ivysur", 60,49,49,45, Pokemon.PokemonType.ELECTRIC),
            Pokemon(1,"Bulbasur", 25,49,49,45, Pokemon.PokemonType.FIRE),
            Pokemon(1,"Bulbasur", 15,69,39,25, Pokemon.PokemonType.WATER),
            Pokemon(1,"Bulbasur", 25,29,59,15, Pokemon.PokemonType.ELECTRIC),
            Pokemon(1,"Bulbasur", 35,59,49,25, Pokemon.PokemonType.FIGHTER),
            Pokemon(1,"Bulbasur", 45,89,9,45, Pokemon.PokemonType.GRASS),
            Pokemon(1,"Bulbasur", 15,69,29,45, Pokemon.PokemonType.FIRE),
            Pokemon(1,"Bulbasur", 25,39,29,45, Pokemon.PokemonType.WATER),

        )

        adapter.submitList(pokemonList)


        return view
    }


}