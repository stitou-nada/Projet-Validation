package com.example.gestion_film.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.gestion_film.R
import com.example.gestion_film.databinding.FragmentFilmListBinding
import com.example.gestion_film.ui.placeholder.PlaceholderContent
import com.example.gestion_film.utils.status

class ListFilmFragment : BaseFragment<FragmentFilmListBinding>(FragmentFilmListBinding::inflate) {


    private val viewModel :FilmViewModel by viewModels()
    private lateinit var adapter: ListFilmAdapter

    override fun init(view: View) {
       adapter = ListFilmAdapter(arrayListOf(),view.findNavController())
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(context,2)
            recyclerView.adapter = adapter
        }
        viewModel.getListFilm().observe(viewLifecycleOwner, Observer {
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