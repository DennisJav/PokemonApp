package com.ec.pokemonapp

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class PokemonAdapter() : ListAdapter<Pokemon, PokemonAdapter.viewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>(){

        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }


    }


    lateinit var onItemClickListener: (Pokemon) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.viewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent,false)
        return viewHolder(view)

    }

    override fun onBindViewHolder(holder: PokemonAdapter.viewHolder, position: Int) {

        val pokemon = getItem(position)
        holder.bind(pokemon)

    }


    inner class viewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        private val idText = view.findViewById<TextView>(R.id.pokemon_id)
        private val nameText = view.findViewById<TextView>(R.id.pokemon_name)
        private val typeImage = view.findViewById<ImageView>(R.id.pokemon_type_image)

        fun bind(pokemon: Pokemon){
            idText.text = pokemon.id.toString()
            nameText.text = pokemon.name

            val imageId : Int = when(pokemon.type){
                Pokemon.PokemonType.GRASS -> R.drawable.grass_icon
                Pokemon.PokemonType.WATER -> R.drawable.water_icon
                Pokemon.PokemonType.FIRE -> R.drawable.fire_icon
                Pokemon.PokemonType.FIGHTER -> R.drawable.fight_icon
                Pokemon.PokemonType.ELECTRIC -> R.drawable.electric_icon
            }

            typeImage.setImageResource(imageId)

            view.setOnClickListener{
                if(::onItemClickListener.isInitialized){
                    onItemClickListener(pokemon)
                }

            }
        }


    }

}