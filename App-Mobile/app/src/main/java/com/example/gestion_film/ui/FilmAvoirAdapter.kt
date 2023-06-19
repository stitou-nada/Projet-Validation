package com.example.gestion_film.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_film.Model.Film
import com.example.gestion_film.R
import com.example.gestion_film.Repository.FilmRepo
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmAvoirAdapter (private val films: ArrayList<Film>, navController: NavController)
: RecyclerView.Adapter<FilmAvoirAdapter.DataViewHolder>(){

    private val navController = navController
    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val TitleFilm: TextView = view.findViewById<Button>(R.id.titleFilm)
        val imageFilm : ImageView = view.findViewById(R.id.imageFilm)
        val cardView: CardView = view.findViewById(R.id.cardView)
        val btnDelete : ImageView = view.findViewById(R.id.btnDelete)
        fun bind(film: Film) {
            TitleFilm.text = film.title
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+film.backdrop_path).into(imageFilm)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAvoirAdapter.DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_film_detaill_item, parent, false)
        return FilmAvoirAdapter.DataViewHolder(layout)
    }
    override fun getItemCount(): Int  = films.size

    override fun onBindViewHolder(holder: FilmAvoirAdapter.DataViewHolder, position: Int) {
        val film = films[position]
        holder.bind(film)
        holder.cardView.setOnClickListener {
            Log.d("lllllll", film.title)
            val action = FilmAvoirFragmentDirections.actionFilmAvoirFragmentToDetailFilmFragment(film.film_id)
            navController.navigate(action)
        }
        holder.btnDelete.setOnClickListener {


            CoroutineScope(Dispatchers.Main).launch {

                    FilmRepo().delete(film.film_id)
                    // Success message
                    if (position != -1) {

                        films.removeAt(position)
                        notifyItemRemoved(position)
                    }
                    Toast.makeText(holder.itemView.context, "Film deleted successfully", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun addFilm(film:List<Film>) {
        this.films.apply {
            clear()
            addAll(film)
        }
    }

}