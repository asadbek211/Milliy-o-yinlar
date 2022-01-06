package com.gita.allomalar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bizmiz.milliyoyinlar.R
import com.bizmiz.milliyoyinlar.databinding.OyinlarItemBinding
import com.bizmiz.milliyoyinlar.utils.imageList

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    var onclick: (position: Int) -> Unit = {}
    fun setOnclickListener(onclick: (position: Int) -> Unit) {
        this.onclick = onclick
    }

    inner class MyViewHolder(private val binding: OyinlarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val oyinNomiList: ArrayList<String> = arrayListOf(
            binding.root.context.getString(R.string.kurash),
            binding.root.context.getString(R.string.ot_oyin),
            binding.root.context.getString(R.string.dorboz),
            binding.root.context.getString(R.string.tosh_kotarish),
            binding.root.context.getString(R.string.arqon_tortish),
            binding.root.context.getString(R.string.kuch_sinash),
            binding.root.context.getString(R.string.harakatli_oyin)
        )

        fun populateModel(position: Int) {
            binding.itemImg.setImageResource(imageList[position])
            binding.txtOyin.text = oyinNomiList[position]
            binding.itemCard.setOnClickListener {
                onclick.invoke(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            OyinlarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(position)
    }

    override fun getItemCount(): Int = imageList.size
}