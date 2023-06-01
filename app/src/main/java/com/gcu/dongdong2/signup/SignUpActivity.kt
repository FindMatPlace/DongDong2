package com.gcu.dongdong2.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gcu.dongdong2.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}