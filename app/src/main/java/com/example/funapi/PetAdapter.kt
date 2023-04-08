package com.example.funapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.widget.TextView


class PetAdapter (private val petList: List<String>, private val idList: List<String>) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView
        val imageIndex: TextView
        val id: TextView
        init {
            // Find our RecyclerView item's ImageView for future use
            petImage = view.findViewById(R.id.pet_image)
            //view variables
            imageIndex = view.findViewById<TextView>(R.id.indexOfImage)
            id = view.findViewById<TextView>(R.id.imageID)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)

        return ViewHolder(view)
    }


        override fun getItemCount() = petList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var photoNum = position+1
        Glide.with(holder.itemView)
            .load(petList[position])
            .centerCrop()
            .into(holder.petImage)
        //setting the texts - ok
        holder.imageIndex.text = "Shiba Photo $photoNum"
        holder.id.text = "ID: " + idList[position]
        //Glide on top of Glide
//        Glide.with(holder.itemView)
//            .load(idList[position])
//            .centerCrop()
//            .into(holder.petImage)

        // `holder` can used to reference any View within the RecyclerView item's layout file
        holder.petImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Doggo at position $position clicked", Toast.LENGTH_SHORT).show()
        }
    }
}