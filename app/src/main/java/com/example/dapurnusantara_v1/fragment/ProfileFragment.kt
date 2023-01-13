package com.example.dapurnusantara_v1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.activity.LoginActivity
import com.example.dapurnusantara_v1.activity.MainActivity
import com.example.dapurnusantara_v1.activity.SettingActivity
import com.example.dapurnusantara_v1.databinding.FragmentProfileBinding
import com.example.dapurnusantara_v1.shared_preferences.PrefManager
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefManager: PrefManager
    private lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        prefManager = PrefManager(requireContext())

        if (prefManager.getToken() == null || prefManager.getToken() == "" ){
            binding.tvNama.visibility = View.GONE
            binding.tvEmail.visibility = View.GONE
            binding.tvFacebook.visibility = View.GONE
            binding.tvInstagram.visibility = View.GONE
            binding.btnLogout.text = "Login"
            binding.btnLogout.setOnClickListener{
                startActivity(Intent(requireContext(),LoginActivity::class.java))
            }
        }else{
            binding.tvNama.visibility = View.VISIBLE
            binding.tvEmail.visibility = View.VISIBLE
            binding.tvFacebook.visibility = View.VISIBLE
            binding.tvInstagram.visibility = View.VISIBLE
            binding.btnLogout.text = "Logout"
            binding.btnLogout.setOnClickListener{
                prefManager.removeData()
                startActivity(Intent(requireContext(),MainActivity::class.java))
            }
        }

        binding.btnSettings.setOnClickListener{
            startActivity(Intent(requireContext(),SettingActivity::class.java))
        }

        return (binding.root)
    }

    companion object {
       fun newInstance(): ProfileFragment {
           return ProfileFragment()
       }
    }
}