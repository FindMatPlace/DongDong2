package com.gcu.dongdong2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gcu.dongdong2.databinding.ActivtiyLoginBinding;
import com.gcu.dongdong2.signup.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    private ActivtiyLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivtiyLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final String inputId = binding.userId.getText().toString();
        final String inputPassword = binding.userPassword.getText().toString();

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
    }
}