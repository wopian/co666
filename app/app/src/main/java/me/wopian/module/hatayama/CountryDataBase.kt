package me.wopian.module.hatayama

/*

import module.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(CountryData::class), version = 1)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun countryDataDao() : CountryDataDao

    companion object {
        private var INSTANCE: CountryDataBase? = null

        fun getInstance(context: Context): CountryDataBase? {
            if (INSTANCE == null) {
                synchronized(CountryDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CountryDataBase::class.java, "country.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}

 */