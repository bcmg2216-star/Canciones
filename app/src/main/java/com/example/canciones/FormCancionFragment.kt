package com.example.canciones

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.canciones.domain.model.Cancion

class FormCancionFragment : DialogFragment() {

    private lateinit var etTitulo: EditText
    private lateinit var etAutor: EditText
    private lateinit var etAlbum: EditText
    private lateinit var etDuracion: EditText
    private lateinit var tvTitulo: TextView
    private lateinit var btnSave: Button
    private lateinit var btnCancel: Button

    interface OnCancionSavedListener {
        fun onCancionSaved(cancion: Cancion, position: Int?)
    }

    private lateinit var listener: OnCancionSavedListener

    private var cancionEditar: Cancion? = null
    private var posicionEditar: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is OnCancionSavedListener) {
            listener = parentFragment as OnCancionSavedListener
        } else if (context is OnCancionSavedListener) {
            listener = context as OnCancionSavedListener
        } else {
            throw ClassCastException("$context must implement OnCancionSavedListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val view = requireActivity().layoutInflater.inflate(R.layout.fragment_cancion, null)

        initViews(view)
        checkEditMode()

        builder.setView(view)
        return builder.create()
    }

    private fun initViews(view: View) {
        etTitulo = view.findViewById(R.id.etTitulo)
        etAutor = view.findViewById(R.id.etAutor)
        etAlbum = view.findViewById(R.id.etAlbum)
        etDuracion = view.findViewById(R.id.etDuracion)
        tvTitulo = view.findViewById(R.id.tvTituloDialog)
        btnSave = view.findViewById(R.id.btnSave)
        btnCancel = view.findViewById(R.id.btnCancel)

        btnCancel.setOnClickListener { dismiss() }

        btnSave.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val autor = etAutor.text.toString()
            val album = etAlbum.text.toString()
            val duracion = etDuracion.text.toString()

            if (titulo.isNotEmpty() && autor.isNotEmpty()) {
                val imagen = cancionEditar?.imagen ?: R.drawable.la_promesa
                val idFinal = cancionEditar?.id ?: 0

                val cancionFinal = Cancion(idFinal, titulo, autor, album, duracion, imagen)

                listener.onCancionSaved(cancionFinal, posicionEditar)
                dismiss()
            } else {
                Toast.makeText(context, "Faltan datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkEditMode() {
        if (arguments != null && arguments?.containsKey("titulo") == true) {
            val id = arguments?.getInt("id") ?: 0
            val titulo = arguments?.getString("titulo")
            val autor = arguments?.getString("autor")
            val album = arguments?.getString("album")
            val duracion = arguments?.getString("duracion")
            val imagen = arguments?.getInt("imagen") ?: 0

            cancionEditar = Cancion(id, titulo!!, autor!!, album!!, duracion!!, imagen)
            posicionEditar = arguments?.getInt("posicion")

            tvTitulo.text = "Editar Canción"
            etTitulo.setText(titulo)
            etAutor.setText(autor)
            etAlbum.setText(album)
            etDuracion.setText(duracion)
        }
    }

    companion object {
        fun newInstance(cancion: Cancion?, position: Int?): FormCancionFragment {
            val fragment = FormCancionFragment()
            val args = Bundle()
            if (cancion != null && position != null) {
                args.putInt("id", cancion.id)
                args.putString("titulo", cancion.titulo)
                args.putString("autor", cancion.autor)
                args.putString("album", cancion.album)
                args.putString("duracion", cancion.duracion)
                args.putInt("imagen", cancion.imagen)
                args.putInt("posicion", position)
            }
            fragment.arguments = args
            return fragment
        }
    }
}