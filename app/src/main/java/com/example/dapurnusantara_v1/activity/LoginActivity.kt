package com.example.dapurnusantara_v1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.databinding.ActivityLoginBinding
import com.example.dapurnusantara_v1.model.LoginResponse
import com.example.dapurnusantara_v1.shared_preferences.PrefManager
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        binding.btnLogin.setOnClickListener{
            doLogin()
        }
        binding.btnMoveRegister.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }

    fun doLogin(){
        val username = binding.txtUsername.text.toString()
        val userpassword = binding.txtPassword.text.toString()

        if (username.isEmpty() || username ==""){
            binding.txtUsername.setError("Wajib diisi")
            binding.txtUsername.requestFocus()
        } else if (userpassword.isEmpty() || userpassword ==""){
            binding.txtPassword.setError("Wajib diisi")
            binding.txtUsername.requestFocus()
        }else{
            RClient.instance.checkUserLogin(username,userpassword)
                .enqueue(object : Callback<LoginResponse>{
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (response.isSuccessful){
//                            prefManager.setToken(response.body().token)
                            response.body()?.let { prefManager.setToken(it.token) }
                            response.body()?.let { prefManager.setUsername(it.username) }
                            response.body()?.let { prefManager.setEmail(it.email) }

                            Toast.makeText(this@LoginActivity,"${response.body()?.msg}",Toast.LENGTH_LONG).show()
                            val intent = Intent(applicationContext,MainActivity::class.java)
                            startActivity(intent)

                        }else{
                            val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                            val messageError = JSONObject(jsonObj.getString("messages"))

                            if (messageError.getString("error")!=""){
                                binding.txtUsername.setError(messageError.getString("error"))
                                binding.txtPassword.setText("")
                                binding.txtUsername.requestFocus()
                            }
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    }

                })
        }
    }
}