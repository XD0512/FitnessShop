package com.example.fitnessshop.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessshop.adapter.NewsAdapter
import com.example.fitnessshop.adapter.SportAdapter
import com.example.fitnessshop.api.ApiServise
import com.example.fitnessshop.databinding.FragmentHomeBinding
import com.example.fitnessshop.model.BaseResponse
import com.example.fitnessshop.model.Model
import com.example.newproject.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.profileImage.setOnClickListener {
            pickImageGallery()
        }

        ApiServise.apiSports().getSportsNews().enqueue(object : Callback<BaseResponse<List<Model>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<Model>>>,
                response: Response<BaseResponse<List<Model>>>,
            ) {
                binding.rvSports.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                binding.rvSports.adapter = SportAdapter(response.body()?.articles ?: listOf())
            }

            override fun onFailure(call: Call<BaseResponse<List<Model>>>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })


        ApiServise.apiSports().getNews().enqueue(object :Callback<BaseResponse<List<Article>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<Article>>>,
                response: Response<BaseResponse<List<Article>>>,
            ) {
                binding.rvNews.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                binding.rvNews.adapter = NewsAdapter(response.body()?.articles ?: listOf())
            }

            override fun onFailure(call: Call<BaseResponse<List<Article>>>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            binding.profileImage.setImageURI(data?.data)

            val sharedPreferences =
                requireActivity().getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("image", data?.data.toString())
            }.apply()

        }
    }
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()

        val IMAGE_REQUEST_CODE = 100
    }
}