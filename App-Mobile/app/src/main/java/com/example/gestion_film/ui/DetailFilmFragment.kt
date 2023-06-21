package com.example.gestion_film.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.gestion_film.Model.Film
import com.example.gestion_film.R
import com.example.gestion_film.databinding.FragmentDetailFilmBinding
import com.example.gestion_film.databinding.FragmentFilmListBinding
import com.example.gestion_film.utils.status
import com.squareup.picasso.Picasso


class DetailFilmFragment : BaseFragment<FragmentDetailFilmBinding>(FragmentDetailFilmBinding::inflate) {
    private var filmID: Int = 0
    private var filmDetail :Film?= null

    private val viewModel: FilmViewModel by viewModels()
    override fun init(view: View) {
        binding.apply {
            arguments.let {
                if (it != null) {
                    filmID = it.getInt("idFilm",0)
                }
            }

        }
        viewModel.getDetailFilm(filmID).observe(viewLifecycleOwner, Observer {
            when (it.status){
                status.ERROR-> this.showResponseError(it.message.toString())
                status.SUCCESS->{
                        binding.apply {
                            filmDetail= it.data
                                titleFilm.text = it.data?.title
                                releaseDate.text = it.data?.release_date
                                voteAverage.text = it.data?.vote_average.toString()
                                overview.text = it.data?.overview
                                popularity.text = it.data?.popularity.toString()
                                Picasso.get().load("https://image.tmdb.org/t/p/w500/"+it.data?.backdrop_path).into(imageFilm)
                        }
                    }

                else -> { print("dddddddddddd")
                }
            }


            })

    }

    override fun listeners(view: View) {
        binding.apply {
            ButtonSave.setOnClickListener{

                val film = Film(
                    filmID,
                    filmDetail?.title!!,
                    filmDetail?.release_date!!,
                    filmDetail?.vote_average!!,
                    filmDetail?.overview!!,
                    filmDetail?.popularity!!,
                    filmDetail?.backdrop_path!!,
                )
                viewModel.store(film).observe(viewLifecycleOwner, Observer {
                Log.d("eeeee", film.toString())
                    when (it.status){

                        status.ERROR->showResponseError(it.message.toString())
                        status.SUCCESS->{
                            binding.apply {
                                Toast.makeText(context, "film a ete add", Toast.LENGTH_SHORT).show()
                                val action = DetailFilmFragmentDirections.actionDetailFilmFragmentToListFilmFragment()
                                findNavController().navigate(action)
                            }
                        }

                        else -> { print("dddddddddddd")
                        }
                    }


                })

            }
        }

    }

}


