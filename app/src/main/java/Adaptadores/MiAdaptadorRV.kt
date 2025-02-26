package Adaptadores

import Modelo.Usuario.Usuario
import Parametros.Parametros
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diosesgriegosapp.Dioses.DIosesHumanos.FragmentoDiosesHumanosViewModel
import com.example.diosesgriegosapp.R


class MiAdaptadorRV(
    private var context: Context,
    private var datos: ArrayList<Usuario>
) : RecyclerView.Adapter<MiAdaptadorRV.MyViewHolder>() {

    private val selectedItems = mutableListOf<Usuario>()
    private val viewModel = ViewModelProvider(context as AppCompatActivity).get(
        FragmentoDiosesHumanosViewModel::class.java)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val usuario = datos[position]
        holder.nombre.text = usuario.nombre

        Glide.with(context).load(usuario.fotoPerfil)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.griego)
            .into(holder.foto)

        holder.itemView.setBackgroundColor(
            if (selectedItems.contains(usuario))
                ContextCompat.getColor(context, R.color.selected_item)
            else
                ContextCompat.getColor(context, R.color.default_item)
        )

        holder.itemView.setOnClickListener {
            if (selectedItems.contains(usuario)) {
                selectedItems.remove(usuario)
            } else {
                selectedItems.add(usuario)
            }
            notifyItemChanged(position)
        }

        holder.itemView.setOnLongClickListener {
            if (Parametros.usuarioLogeado == "Hades") {

                val observer = object : Observer<Boolean> {
                    override fun onChanged(success: Boolean) {
                        if (success) {
                            datos.removeAt(position)
                            notifyItemRemoved(position)
                        } else {
                            Toast.makeText(context, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                        }
                        viewModel.resOperacion.removeObserver(this)
                    }
                }
                usuario.idUsuario?.let { userId ->
                    viewModel.resOperacion.observe(context as AppCompatActivity, observer)
                    viewModel.borrarUsuarioVM(userId)
                }
            } else {
                Toast.makeText(context, "No tienes permisos para eliminar", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView = itemView.findViewById<View>(R.id.txtNombreNuevo) as TextView
        var foto: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView
    }
}