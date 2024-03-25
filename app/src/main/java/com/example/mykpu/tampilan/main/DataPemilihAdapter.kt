package com.example.mykpu.tampilan.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mykpu.database.DataPemilih
import com.example.mykpu.databinding.DataItemBinding
import com.example.mykpu.helper.DataPemilihDiffCallback
import com.example.mykpu.tampilan.input.FormEntry
import java.util.*

class DataPemilihAdapter : RecyclerView.Adapter<DataPemilihAdapter.DataPemilihViewHolder>() {
    private val listDataPemilih = ArrayList<DataPemilih>()

    fun setListDataPemilih(listDataPemilih: List<DataPemilih>) {
        val diffCallback = DataPemilihDiffCallback(this.listDataPemilih, listDataPemilih)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listDataPemilih.clear()
        this.listDataPemilih.addAll(listDataPemilih)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataPemilihViewHolder {
        val binding = DataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataPemilihViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataPemilihViewHolder, position: Int) {
        holder.bind(listDataPemilih[position])
    }

    override fun getItemCount(): Int {
        return listDataPemilih.size
    }

    inner class DataPemilihViewHolder(private val binding: DataItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(datapemilih: DataPemilih) {
            with(binding) {
                tvItemNik.text = datapemilih.nik?.toString() ?: ""
                tvItemDate.text = datapemilih.date
                tvItemNama.text = datapemilih.nama

                cvItemDatapemilih.setOnClickListener {
                    val intent = Intent(it.context, FormEntry::class.java)
                    intent.putExtra(FormEntry.EXTRA_NOTE, datapemilih)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}
