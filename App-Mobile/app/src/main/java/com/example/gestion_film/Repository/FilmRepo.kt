package com.example.gestion_film.Repository

import com.example.gestion_film.DAO.filmDAO
import com.example.gestion_film.Model.Film
import com.example.gestion_film.Model.User

class FilmRepo (){
    private val filmDao = filmDAO()
    suspend fun getListFilmRepo() =filmDao.getListFilmDAO()
    suspend fun getDetailFilm(film_id:Int) = filmDao.getDetailFilm(film_id)
    suspend fun store(film: Film)=filmDao.store(film)
    suspend fun ListAvoir()=filmDao.ListAvoir()
    suspend fun delete(Id:Int)= filmDao.delete(Id)
    suspend fun login(user: User)=filmDao.login(user)
} 