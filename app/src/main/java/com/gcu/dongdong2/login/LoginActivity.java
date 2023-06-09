package com.gcu.dongdong2.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gcu.dongdong2.MainActivity;
import com.gcu.dongdong2.databinding.ActivtiyLoginBinding;
import com.gcu.dongdong2.signup.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private ActivtiyLoginBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivtiyLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Firebase 인증 객체 초기화
        auth = FirebaseAuth.getInstance();
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputId = binding.userId.getText().toString();
                String inputPassword = binding.userPassword.getText().toString();
                if ((inputId.equals("")) || (inputPassword.equals(""))) {
                    Toast.makeText(getBaseContext(), "로그인 오류", Toast.LENGTH_SHORT).show();
                } else {
                    // 이메일과 비밀번호로 로그인
                    auth.signInWithEmailAndPassword(inputId, inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(getBaseContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getBaseContext(), "로그인 오류", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}