package com.gcu.dongdong2.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gcu.dongdong2.MainActivity
import com.gcu.dongdong2.R
import com.gcu.dongdong2.databinding.FragmentNameBinding
import com.google.android.material.snackbar.Snackbar

/**
 * 이름, 생년월일 입력 화면
 */
class SignFragment : Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding get() = _binding!!

    private var name: String = ""
    private var id: String = ""
    private var password: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentBackStackEntry = findNavController().currentBackStackEntry

        id = SignFragmentArgs.fromBundle(requireArguments()).id
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

            val verified = currentBackStackEntry!!.savedStateHandle.get<Boolean>(VerifyCodeFragment.AUTH)
            if (verified != true) {
                Toast.makeText(requireContext(), "인증을 해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                // 여기에 파이어베이스에 회원가입 쿼리 날리기

//                val bundle = Bundle()
//                bundle.putString("name", name)
//                bundle.putString("id", id)
//                bundle.putString("password", password)

                startActivity(Intent(requireContext(), MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                    putExtra("name", name)
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController()
        val currentBackStackEntry = navController.currentBackStackEntry!!

//        currentBackStackEntry.savedStateHandle
//            .getLiveData<Boolean>(VerifyCodeFragment.AUTH)
//            .observe(currentBackStackEntry) { verified ->
//                if (verified) {
//                    val bundle = Bundle()
//                    bundle.putString("name", name)
//                    bundle.putString("id", id)
//                    bundle.putString("password", password)
//                    // 여기에 firestore create 넣기
//                    bundle
//                }
//            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}