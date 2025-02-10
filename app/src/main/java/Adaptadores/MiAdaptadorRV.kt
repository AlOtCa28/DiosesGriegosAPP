package Adaptadores

import Modelo.Usuario.Usuario
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diosesgriegosapp.R

class MiAdaptadorRV(
    private var context: Context,
    private var datos: ArrayList<Usuario>
) : RecyclerView.Adapter<MiAdaptadorRV.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val usuario = datos[position]
        holder.nombre.text = usuario.nombre

        Log.d("foto", usuario.fotoPerfil.toString())

        Glide.with(context)
            .load(usuario.fotoPerfil)
            .centerCrop()
            .into(holder.foto)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView = itemView.findViewById<View>(R.id.txtNombreNuevo) as TextView
        var foto: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView
    }
}