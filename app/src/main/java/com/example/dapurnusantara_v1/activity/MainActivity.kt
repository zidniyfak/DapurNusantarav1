package com.example.dapurnusantara_v1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bottom Navigation
        setFragment(HomeFragment.newInstance())
        navigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
        navigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_keranjang))
        navigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_riwayat))
        navigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_profile))

        navigation.setOnClickMenuListener {
            when(it.id){
                1 -> setFragment(HomeFragment.newInstance())
                2 -> setFragment(CartFragment.newInstance())
                3 -> setFragment(HistoryFragment.newInstance())
                4 -> setFragment(ProfileFragment.newInstance())

                else -> ""
            }
        }
        navigation.show(1)


    }


    fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout,fragment)
            .commit()
    }

}