package com.example.dapurnusantara_v1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.activity.LoginActivity
import com.example.dapurnusantara_v1.activity.MainActivity
import com.example.dapurnusantara_v1.databinding.FragmentHistoryBinding
import com.example.dapurnusantara_v1.shared_preferences.PrefManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val view = binding.root
        Picasso.get().load("https://images.tokopedia.net/img/KRMmCm/2022/8/9/51584c5e-2713-4895-88d5-30b677255ffd.jpg").fit().centerCrop().into(binding.ivRiwayat1)
        Picasso.get().load("https://static.uc.ac.id/fikom/2022/12/Pic-1.jpg").fit().centerCrop().into(binding.ivRiwayat3)
        Picasso.get().load("https://cdn0-production-images-kly.akamaized.net/aDZbOOV2WeJCgCiBFgFQwoXJN64=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2029093/original/066661300_1521949447-Bakso.jpg").fit().centerCrop().into(binding.ivRiwayat2)
        return view

    }

    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }
}