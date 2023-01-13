package com.example.dapurnusantara_v1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dapurnusantara_v1.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnMoveLogin.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
        btnMovelogin2.setOnClickListener{
            Toast.makeText(this,"Register berhasil",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}