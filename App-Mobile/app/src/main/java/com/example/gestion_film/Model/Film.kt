package com.example.gestion_film.Model

data class Film(
                  var film_id : Int,
                  var title :String,
                  var release_date :String,
                  var vote_average :Double,
                  var overview :String,
                  var popularity :Double,
                  var backdrop_path:String
)
