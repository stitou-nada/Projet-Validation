package com.example.gestion_film.DAO

import com.example.gestion_film.DAO.API.FilmApiInterface
import com.example.gestion_film.Model.Film
import com.example.gestion_film.Model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class filmDAO {
    //copanion object cree les variable statique
    companion object{
        private var url ="http://192.168.2.46:8000/api/"
         // 
        private fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiService: FilmApiInterface = getRetrofit().create(FilmApiInterface::class.java)

    }

    suspend fun getListFilmDAO()= apiService.getListFilms()
    suspend fun getDetailFilm(film_id:Int)= apiService.getDetailFilm(film_id)
    suspend fun store( film: Film)= apiService.store(film)
    suspend fun ListAvoir()= apiService.ListAvoir()
    suspend fun delete(Id: Int)= apiService.delete(Id)
    suspend fun login(user: User)= apiService.login(user)
}