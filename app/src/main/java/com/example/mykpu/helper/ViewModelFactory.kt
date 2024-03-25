package com.example.mykpu.helper

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mykpu.tampilan.input.FormEntryViewModel
import com.example.mykpu.tampilan.main.DaftarDataPemilihViewModel


class ViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {


    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null


        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        when {
            modelClass.isAssignableFrom(DaftarDataPemilihViewModel::class.java) -> {
                return DaftarDataPemilihViewModel(mApplication) as T
            }
            modelClass.isAssignableFrom(FormEntryViewModel::class.java) -> {
                return FormEntryViewModel(mApplication) as T
            }
            else -> {

                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }
    }
}
