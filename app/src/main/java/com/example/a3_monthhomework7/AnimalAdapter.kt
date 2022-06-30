package com.example.a3_monthhomework7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_monthhomework7.databinding.ItemAnimalBinding

class AnimalAdapter(
    private val data: ArrayList<Animal>,
    var onLongClick: ((Int,String) -> Unit)? = null
) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

   

//    fun onLongClick : Boolean (View view) {
//        if ()
//        return false
//    }

    inner class AnimalViewHolder(private val binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.name.text = animal.name
            animal.image?.let { binding.image.setImageResource(it) }
           itemView.setOnLongClickListener {
               onLongClick?.invoke(adapterPosition, binding.name.toString())
               return@setOnLongClickListener true
           }
            }
        }
    }

