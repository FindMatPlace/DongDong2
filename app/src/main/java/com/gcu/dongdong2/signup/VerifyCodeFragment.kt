package com.gcu.dongdong2.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.gcu.dongdong2.databinding.FragmentVerifySchoolBinding

/**
 * 학생 인증 화면
 */
class VerifyCodeFragment : Fragment() {

    private lateinit var savedStateHandle: SavedStateHandle
    private var _binding: FragmentVerifySchoolBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifySchoolBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
//        savedStateHandle[AUTH] = false

        if (!savedStateHandle.contains(AUTH)) {
            savedStateHandle[AUTH] = false
        }

        binding.btnVerify.setOnClickListener {

            if (savedStateHandle.getLiveData<Boolean>(AUTH).value == true) {
                onVerificationSucceed()
                Toast.makeText(requireContext(), "인증 되었습니다", Toast.LENGTH_SHORT).show()
//                binding.textStudentStatus.isVisible = true
            } else {
                Snackbar.make(binding.btnVerify, "인증이 되지 않았습니다", Snackbar.LENGTH_SHORT).show()
                // binding.textPhotoHint.isGone
            }
        }

        binding.btnTest.setOnClickListener {
            savedStateHandle[AUTH] = true
//            onVerificationSucceed()
        }
    }

    // 인증성공, PhoneFragment로 돌아간다.
    private fun onVerificationSucceed() {
//        savedStateHandle[AUTH] = true
//        viewModel.addVerifiedPhoneNumber(phone)
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TEST_CODE = "1234" // 테스트용 인증번호
        const val AUTH = "VERIFIED"
    }
}