package com.example.dapurnusantara_v1.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.dapurnusantara_v1.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeFragment : Fragment() {

    lateinit var topAppBAr:MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = view.findViewById<ViewPager>(R.id.view_pager)

        val fragmentAdapter = com.example.dapurnusantara_v1.adapter.FragmentPagerAdapter(childFragmentManager)
        fragmentAdapter.addFragment(MenuMakananFragment(), "Makanan")
        fragmentAdapter.addFragment(MenuMinumanFragment(), "Minuman")
        viewPager.adapter = fragmentAdapter
        tabLayout.setTabTextColors(Color.parseColor("#D4D4D4"), Color.parseColor("#EDBA32"))
        tabLayout.setupWithViewPager(viewPager)


        return view
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}