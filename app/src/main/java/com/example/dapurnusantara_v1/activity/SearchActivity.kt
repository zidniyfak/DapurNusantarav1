package com.example.dapurnusantara_v1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.fragment.SearchListFragment
import com.example.dapurnusantara_v1.databinding.ActivitySearchBinding
import com.example.dapurnusantara_v1.model.Food
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private var list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        txtSearch.requestFocus()
//        showResult()
        showFragment()
        binding.txtSearch.setOnKeyListener(View.OnKeyListener{v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                showFragment()
                return@OnKeyListener true
            }
            false
        })

    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = SearchListFragment()

        val textSearch =  binding.txtSearch.text
        val mBundle = Bundle()
        mBundle.putString("cari",textSearch.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.flDataSearch,mFragment).commit()

    }

    private fun filterList(query:String?){

    }

//    private fun showResult() {
//
//        rvSearch.setHasFixedSize(true)
//        rvSearch.layoutManager = LinearLayoutManager(this)
//        RClient.instance.getMakanan().enqueue(object : Callback<FoodResponse> {
//            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
//                // Karena dalamnya ada json object ditambahin .data
//                val listResponse = response.body()?.data
//
//                listResponse?.let { list.addAll(it) }
//                val adapter = SearchAdapter(list)
//                rvSearch.adapter = adapter
//            }
//
//            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
//                Log.d("APIERROR", t.message.toString())
//            }
//        })
//    }

    override fun onBackPressed() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

        super.onBackPressed()
    }
}