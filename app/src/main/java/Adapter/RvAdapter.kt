package Adapter

import Model.Remembrance
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tasbeeh.R
import com.example.tasbeeh.Tasbeeh
import kotlinx.android.synthetic.main.item_rv.view.*

class RvAdapter(var context: Context, var list: ArrayList<Remembrance>) :
    RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(rvModel: Remembrance, position: Int) {
            itemView.txtNameArabic.text = rvModel.nameArabic
            itemView.txtNameLatin.text = rvModel.nameLatin
            itemView.animation = AnimationUtils.loadAnimation(context, R.anim.anim1)

            itemView.btn_zikraytish.setOnClickListener {
                val intent = Intent(context, Tasbeeh::class.java)
                intent.putExtra("nameArabic", list[position].nameArabic)
                intent.putExtra("nameLatin", list[position].nameLatin)
                intent.putExtra("total", list[position].total)
                intent.putExtra("position", position)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}