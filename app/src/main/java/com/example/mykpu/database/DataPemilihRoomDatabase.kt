package com.example.mykpu.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DataPemilih::class], version = 1)
abstract class DataPemilihRoomDatabase : RoomDatabase() {


    abstract fun datapemilihDao(): DataPemilihDao


    companion object {

        @Volatile
        private var INSTANCE: DataPemilihRoomDatabase? = null


        @JvmStatic
        fun getDatabase(context: Context): DataPemilihRoomDatabase {

            if (INSTANCE == null) {
                synchronized(DataPemilihRoomDatabase::class.java) {

                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DataPemilihRoomDatabase::class.java, "datapemilih_database")
                        .build()
                }
            }

            return INSTANCE as DataPemilihRoomDatabase
        }
    }
}
