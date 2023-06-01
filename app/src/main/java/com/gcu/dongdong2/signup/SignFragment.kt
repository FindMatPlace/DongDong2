package com.gcu.dongdong2.signup

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gcu.dongdong2.login.LoginActivity
import com.gcu.dongdong2.R
import com.gcu.dongdong2.databinding.FragmentNameBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/**
 * 이름, 생년월일 입력 화면
 */
class SignFragment : Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding get() = _binding!!

    private var name: String = ""
    private var email: String = ""
    private var password: String = ""
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentBackStackEntry = findNavController().currentBackStackEntry

        email = SignFragmentArgs.fromBundle(requireArguments()).id
        password = SignFragmentArgs.fromBundle(requireArguments()).password

        binding.editTextName.requestFocus()
        binding.buttonVerifySchool.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("auth", false)

            findNavController().navigate(
                R.id.action_nameFragment_to_verifyFragment,
                bundle
            )
        }

        binding.btnCreate.setOnClickListener {
            name = binding.editTextName.text.toString()

            if (name.isEmpty()) {
                Snackbar.make(binding.btnCreate, "이름을 입력해주세요", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val verified =
                currentBackStackEntry!!.savedStateHandle.get<Boolean>(VerifyCodeFragment.AUTH)
            if (verified != true) {
                Toast.makeText(requireContext(), "인증을 해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                // 파이어베이스에 신규 계정 등록하기
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity()) { task ->
                        // 가입 성공시
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            val userEmail = user?.email
                            val userDto = hashMapOf(
                                "name" to "$name",
                                "email" to "$userEmail",
                                "password" to "$password",
                            )

                            db.collection("users")
                                .add(userDto)
                                .addOnSuccessListener {
                                    Log.d(TAG, "회원가입 완료")
                                }
                                .addOnFailureListener { e ->
                                    Log.d(TAG, "Error: $e")
                                }

                            // 가입이 이루어지면 가입 화면을 빠져나감
                            startActivity(
                                Intent(
                                    requireContext(),
                                    LoginActivity::class.java
                                ).apply {
                                    flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                })
//                            finish()
                            Toast.makeText(requireContext(), "회원가입이 완료되었습니다", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            println(task.exception)
                            Toast.makeText(requireContext(), "회원가입이 실패했습니다.", Toast.LENGTH_SHORT).show()
                            return@addOnCompleteListener  // 해당 메소드 진행을 멈추고 빠져나감
                        }
                    }
            }
        }
    }
}