package com.example.roomdatabase.repositori

import com.example.roomdatabase.Room.Siswa
import com.example.roomdatabase.Room.SiswaDao
import kotlinx.coroutines.flow.Flow


interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>

    fun getsiswaStream(id: Int): Flow<Siswa>

    suspend fun  deleteSiswa(siswa: Siswa)

    suspend fun insertSiswa(siswa: Siswa)

}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa{
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
    //edit 2
    override  fun getSiswastream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)

}