package com.example.canciones.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.canciones.R
import com.example.canciones.models.Cancion

class CancionAdapter(
    private var lista: MutableList<Cancion>,
    private val onDelete: (Int) -> Unit,
    private val onEdit: (Int) -> Unit,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<CancionAdapter.CancionVH>() {

    inner class CancionVH(v: View) : RecyclerView.ViewHolder(v) {
        val img: ImageView = v.findViewById(R.id.imgAlbum)
        val titulo: TextView = v.findViewById(R.id.txtTitulo)
        val autor: TextView = v.findViewById(R.id.txtArtista)
        val album: TextView = v.findViewById(R.id.txtAlbum)
        val duracion: TextView = v.findViewById(R.id.txtDuracion)
        val btnDelete: Button = v.findViewById(R.id.btnDelete)
        val btnEdit: Button = v.findViewById(R.id.btnEdit)

        fun render(c: Cancion) {
            Glide.with(itemView.context).load(c.imagen).into(img)
            titulo.text = c.titulo
            autor.text = c.autor
            album.text = c.album
            duracion.text = c.duracion

            btnDelete.setOnClickListener { onDelete(adapterPosition) }
            btnEdit.setOnClickListener { onEdit(adapterPosition) }
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cancion_2, parent, false)
        return CancionVH(v)
    }

    override fun onBindViewHolder(holder: CancionVH, position: Int) {
        holder.render(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    fun updateList(newList: MutableList<Cancion>) {
        lista = newList
        notifyDataSetChanged()
    }
}