package com.gcu.dongdong2.signup

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gcu.dongdong2.R
import com.gcu.dongdong2.databinding.FragmentIdpasswordBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore

/**
 * 아이디, 비밀번호 입력 화면
 */

class IdPasswordFragment : Fragment() {

    private var _binding: FragmentIdpasswordBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentIdpasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.userId.requestFocus()
        binding.btnIdCheck.setOnClickListener {
            val email = binding.userId.text.toString()

            // 중복 아이디 확인
            checkDuplicateId(email) { isDuplicate ->
                if (isDuplicate) {
                    // 중복된 아이디인 경우
                    Toast.makeText(requireContext(), "중복된 아이디입니다.", Toast.LENGTH_SHORT).show()
                } else {
                    // 중복되지 않은 아이디인 경우
                    Toast.makeText(requireContext(), "사용할 수 있는 아이디입니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnNext.setOnClickListener {
            val userId = binding.userId.text.toString()
            if (userId.isEmpty()) {
                Snackbar.make(binding.btnNext, "아이디를 입력해주세요", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userPassword = binding.userPassword.text.toString()
            if (userPassword.isEmpty()) {
                Snackbar.make(binding.btnNext, "비밀번호를 입력해주세요", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userPasswordAgain = binding.userPasswordAgain.text.toString()
            if (userPasswordAgain.isEmpty()) {
                Snackbar.make(binding.btnNext, "비밀번호를 한번 더 입력해주세요", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userPassword != userPasswordAgain) {
                Snackbar.make(binding.btnNext, "입력한 비밀번호가 서로 다릅니다", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isValidEmail(userId)) {
                Snackbar.make(binding.btnNext, "ID는 이메일 형식이어야 합니다", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userPassword.length < 6) {
                Snackbar.make(binding.btnNext, "비밀번호는 6자리 이상이어야 합니다", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bundle = Bundle()
            bundle.putString("id", userId)
            bundle.putString("password", userPassword)

            findNavController().navigate(
                R.id.action_idFragment_to_nameFragment,
                bundle
            )
        }
    }

    private fun checkDuplicateId(email: String, callback: (Boolean) -> Unit) {
        val usersCollection = FirebaseFirestore.getInstance().collection("users")

        usersCollection.whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { querySnapshot ->
                val isDuplicate = !querySnapshot.isEmpty
                callback(isDuplicate)
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Error checking duplicate ID: $exception")
                callback(false)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}