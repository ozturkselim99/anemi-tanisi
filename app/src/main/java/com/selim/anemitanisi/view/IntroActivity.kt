package com.selim.anemitanisi.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.selim.anemitanisi.R
import com.selim.anemitanisi.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private var binding: ActivityIntroBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        binding!!.loginText.setOnClickListener {
            login()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun login() {
        val sharedPref = getSharedPreferences("intro", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", binding!!.name.text.toString())
        editor.putBoolean("isNameEntered", true)
        editor.apply()
    }
}