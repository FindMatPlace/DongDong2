package com.gcu.dongdong2.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gcu.dongdong2.databinding.ActivtiyLoginBinding
import com.gcu.dongdong2.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivtiyLoginBinding
//    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance() //파이어베이스 인증

//    private val mDatabaseRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("") // 실시간 데이터베이스

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivtiyLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputId = binding.userId.text.toString()
        val inputPassword = binding.userPassword.text.toString()
//        mFirebaseAuth.signInWithEmailAndPassword(inputId, inputPassword).addOnCompleteListener(
//            this@LoginActivity
//        ) { task ->
//            if (task.isSuccessful) {
//                //로그인 성공
////                val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                startActivity(intent)
//                finish() //현재 액티비티 파괴
//            } else {
//                Toast.makeText(this@LoginActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
//                Log.w("error", task.exception)
//            }
//        }

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}