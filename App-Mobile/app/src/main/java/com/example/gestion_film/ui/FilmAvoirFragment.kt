package com.example.gestion_film.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gestion_film.R
import com.example.gestion_film.databinding.FragmentFilmAvoirBinding
import com.example.gestion_film.utils.status

class FilmAvoirFragment : BaseFragment<FragmentFilmAvoirBinding>(FragmentFilmAvoirBinding::inflate) {

    private val viewModel :FilmViewModel by viewModels()
    private lateinit var adapter: FilmAvoirAdapter

    override fun init(view: View) {
        adapter = FilmAvoirAdapter(arrayListOf(),view.findNavController())
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(context,2)
            recyclerView.adapter = adapter
        }
        viewModel.ListAvoir().observe(viewLifecycleOwner, Observer {
            when (it.status){
                status.ERROR-> this.showResponseError(it.message.toString())
                status.SUCCESS->{
                    binding.recyclerView.visibility = View.VISIBLE
                    adapter.apply {
                        addFilm(it.data!!)
                        notifyDataSetChanged()
                    }
                }
                else -> {
                    println("sssssssssss")
                }
            }
        })
    }

    override fun listeners(view: View) {

    }




}