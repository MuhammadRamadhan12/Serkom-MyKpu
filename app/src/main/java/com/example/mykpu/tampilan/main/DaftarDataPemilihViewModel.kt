package com.example.mykpu.tampilan.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mykpu.database.DataPemilih
import com.example.mykpu.repository.DataPemilihRepository


class DaftarDataPemilihViewModel(application: Application) : ViewModel() {

    private val mDataPemilihRepository: DataPemilihRepository = DataPemilihRepository(application)

    fun getAllDataPemilih(): LiveData<List<DataPemilih>> = mDataPemilihRepository.getAllDataPemilih()
}
