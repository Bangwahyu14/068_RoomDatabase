package com.example.roomdatabase.repositori

import android.app.Application
import android.content.Context
import com.example.roomdatabase.Room.DatabaseSiswa

interface ContainerApp{
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp( val context: Context):
    ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            DatabaseSiswa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application(){
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerDataApp(this)
    }
}