package com.gcu.dongdong2.signup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.ExperimentalGetImage
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.gcu.dongdong2.databinding.FragmentVerifySchoolBinding
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.ml.vision.text.FirebaseVisionText


@ExperimentalGetImage /**
 * 학생 인증 화면
 */
class VerifyCodeFragment : Fragment() {

    public lateinit var savedStateHandle: SavedStateHandle
    private var _binding: FragmentVerifySchoolBinding? = null
    private val binding get() = _binding!!
    private val imageAnalyzer: ImageAnalyzer = ImageAnalyzer.getInstance();

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
        imageAnalyzer.setVerifyCodeFragment(this)

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
            }
        }

        binding.btnCamera.setOnClickListener {
            selectImage { uri ->
                if (uri != null) {
                    Thread(Runnable {
                        val result = imageAnalyzer.imageAnalyze(requireContext(), uri)
                        resultAnalyzeAsync(result)
                    }).start()
                } else {
                    // 이미지 선택이 취소된 경우 처리
                    println("Image selection canceled.")
                }
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

    private val IMAGE_PICK_REQUEST = 1
    private var imagePickCallback: ((Uri?) -> Unit)? = null

    // 갤러리에서 이미지 선택하기 위한 메서드 호출
    fun selectImage(callback: (Uri?) -> Unit) {
        imagePickCallback = callback

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_REQUEST)
    }

    // 이미지 선택 결과 처리
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICK_REQUEST && resultCode == Activity.RESULT_OK) {
            val selectedImageUri = data?.data
            imagePickCallback?.invoke(selectedImageUri)
        } else {
            imagePickCallback?.invoke(null)
        }

        imagePickCallback = null
    }

    private fun resultAnalyzeAsync(textTask: Task<FirebaseVisionText>) {
        textTask.addOnSuccessListener { result ->
            println(result)
        }.addOnFailureListener { exception ->
            exception.printStackTrace()
        }
    }
}