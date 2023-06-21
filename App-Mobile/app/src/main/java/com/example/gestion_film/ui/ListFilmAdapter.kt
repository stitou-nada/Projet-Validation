package com.example.gestion_film.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_film.Model.Film
import com.example.gestion_film.R
import com.squareup.picasso.Picasso

class ListFilmAdapter (private val films: ArrayList<Film>, navController: NavController)
        : RecyclerView.Adapter<ListFilmAdapter.DataViewHolder>() {

        private val navController = navController

        class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
             val TitleFilm: TextView = view.findViewById<Button>(R.id.titleFilm)
            val imageFilm : ImageView = view.findViewById(R.id.imageFilm)
            val cardView: CardView = view.findViewById(R.id.cardView)
            fun bind(film: Film) {
                TitleFilm.text = film.title
                Picasso.get().load("https://image.tmdb.org/t/p/w500/"+film.backdrop_path).into(imageFilm)
            }
        }

        // for convert league_items xml to view
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
            val layout = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_film_item, parent, false)
            return DataViewHolder(layout)
        }

        //for determine number of items shuld be displayed
        override fun getItemCount(): Int  = films.size



        override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            val film = films[position]
            holder.bind(film)
            holder.cardView.setOnClickListener {
                Log.d("lllllll", film.title)
                val action = ListFilmFragmentDirections.actionListFilmFragmentToDetailFilmFragment(film.film_id)
                navController.navigate(action)
            }
        }

        // cette méthode utilisée pour effacer les données dans la liste et ajouter de nouvelles données à afficher
        fun addFilm(film:List<Film>) {
            this.films.apply {
                clear()
                addAll(film)
            }
        }





}