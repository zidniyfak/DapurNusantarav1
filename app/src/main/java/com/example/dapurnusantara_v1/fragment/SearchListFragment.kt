package com.example.dapurnusantara_v1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dapurnusantara_v1.adapter.SearchAdapter
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.databinding.FragmentSearchListBinding
import com.example.dapurnusantara_v1.model.Food
import com.example.dapurnusantara_v1.model.FoodResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchListFragment : Fragment() {
    private var _binding : FragmentSearchListBinding? =null
    private val binding get() = _binding!!

    private val listSearch = ArrayList<Food>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

        getSearch()
    }

    override fun onStart() {
        super.onStart()
        getSearch()
    }

    fun getSearch(){
        binding.rvSearchList.setHasFixedSize(true)
        binding.rvSearchList.layoutManager = LinearLayoutManager(context)

        val bundle = arguments
        val cari = bundle?.getString("cari")

        binding.progressBar.visibility
        RClient.instance.getDataSearch(cari).enqueue(object : Callback<FoodResponse>{
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                if(response.isSuccessful){
                    listSearch.clear()
                    response.body()?.data?.let { listSearch.addAll(it) }

                    val adapter = SearchAdapter(listSearch)
                    binding.rvSearchList.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}