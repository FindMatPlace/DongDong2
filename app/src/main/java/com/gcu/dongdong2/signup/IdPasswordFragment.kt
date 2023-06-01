package com.gcu.dongdong2.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gcu.dongdong2.R
import com.gcu.dongdong2.databinding.FragmentIdpasswordBinding
import com.google.android.material.snackbar.Snackbar

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

            val bundle = Bundle()
            bundle.putString("id", userId)
            bundle.putString("password", userPassword)

            findNavController().navigate(
                R.id.action_idFragment_to_nameFragment,
                bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}