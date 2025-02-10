package Adaptadores


import Modelo.Prueba.Prueba
import Modelo.Usuario.Usuario
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diosesgriegosapp.R

class AdaptadorPrueba(
    private var context: Context,
    private var datos: ArrayList<Prueba>
) : RecyclerView.Adapter<AdaptadorPrueba.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card_prueba, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val prueba = datos[position]
        holder.descr.text = prueba.descripcion
        holder.tipo.text = prueba.tipoPrueba
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var descr: TextView = itemView.findViewById<View>(R.id.txtNombreNuevo) as TextView
        var tipo : TextView = itemView.findViewById<View>(R.id.txtTipo) as TextView
    }

}