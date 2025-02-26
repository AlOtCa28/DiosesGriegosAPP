package Adaptadores

import Modelo.Prueba.Prueba
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diosesgriegosapp.Dioses.DiosesPruebas.PruebaDetalleActivity
import com.example.diosesgriegosapp.R

class AdaptadorPruebaHumano (
    private var context: Context,
    private var datos: ArrayList<Prueba>
) : RecyclerView.Adapter<AdaptadorPruebaHumano.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_card_prueba_humanos, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val prueba = datos[position]
        holder.descr.text = prueba.descripcion
    }
    override fun getItemCount(): Int {
        return datos.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var descr: TextView = itemView.findViewById<View>(R.id.txtNombreNuevo) as TextView
    }

}