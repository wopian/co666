package me.wopian.module.hatayama
/*
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "countryData")
data class CountryData(
        @PrimaryKey(autoGenerate = false) var isoCode: String,
        @ColumnInfo(name = "continent") var continent: String,
        @ColumnInfo(name = "name_of_flag") var nameOfFlag: String,
        @ColumnInfo(name = "proportion") var proportion: String,
        @ColumnInfo(name = "adopted") var adopted: Int,
        @ColumnInfo(name = "main_colours") var mainColours: String,
        @ColumnInfo(name = "status") var status: String,
        @ColumnInfo(name = "languages") var languages: String){
    constructor(): this("", "","", "", 0, "", "", "")
}

/*
private fun fetchWeatherDataFromDb() {

        val task = Runnable {

            val weatherData =

                    mDb?.weatherDataDao()?.getAll()

            mUiHandler.post({

                if (weatherData == null || weatherData?.size == 0) {

                    showToast("No data in cache..!!", Toast.LENGTH_SHORT)

                } else {

                    bindDataWithUi(weatherData = weatherData?.get(0))

                }

            })

        }

        mDbWorkerThread.postTask(task)

    }
 */