package com.example.gestion_film.DAO.API

import com.example.gestion_film.Model.Film
import com.example.gestion_film.Model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FilmApiInterface {
    @GET("getAPI")
    suspend fun getListFilms():List<Film>

    @GET("filmDetail/{film_id}")
    suspend fun getDetailFilm(@Path("film_id") film_id:Int): Film

    @POST("store")
    suspend fun store(@Body film:Film ):Int

    @GET("ListAvoir")
    suspend fun ListAvoir():List<Film>

    @DELETE("delete/{id}")
    suspend fun delete(@Path("id") id: Int):Int

    @POST("login")
    suspend fun login(@Body user:User):User


}