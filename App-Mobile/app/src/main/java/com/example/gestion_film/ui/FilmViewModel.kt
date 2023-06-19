package com.example.gestion_film.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gestion_film.Model.Film
import com.example.gestion_film.Model.User
import com.example.gestion_film.Repository.FilmRepo
import com.example.gestion_film.utils.Resource
import kotlinx.coroutines.Dispatchers

class FilmViewModel  :ViewModel(){
       private val repo = FilmRepo()
       fun getListFilm()= liveData(Dispatchers.IO){
              emit(Resource.loading(data = null))
              try {
                  emit(Resource.success(data = repo.getListFilmRepo()))
              }
              catch (exception:Exception){
                     emit(Resource.error(data = null, message = exception.message?:"Error"))
              }
       }
       fun getDetailFilm(film_id:Int)= liveData(Dispatchers.IO){
              emit(Resource.loading(data = null))
              try {
                     emit(Resource.success(data = repo.getDetailFilm(film_id)))
              }
              catch (exception:Exception){
                     emit(Resource.error(data = null, message = exception.message?:"Error"))
              }
       }
       fun store(film: Film)= liveData(Dispatchers.IO){
              emit(Resource.loading(data = null))
              try {
                     emit(Resource.success(data = repo.store(film)))
              }
              catch (exception:Exception){
                     emit(Resource.error(data = null, message = exception.message?:"Error"))
              }
       }
       fun ListAvoir()= liveData(Dispatchers.IO){
              emit(Resource.loading(data = null))
              try {
                     emit(Resource.success(data = repo.ListAvoir()))
              }
              catch (exception:Exception){
                     emit(Resource.error(data = null, message = exception.message?:"Error"))
              }
       }
       fun login(user: User)= liveData(Dispatchers.IO){
              emit(Resource.loading(data = null))
              try {
                     emit(Resource.success(data = repo.login(user)))
              }
              catch (exception:Exception){
                     emit(Resource.error(data = null, message = exception.message?:"Error"))
              }
       }

}