package com.gcu.dongdong2.userInfo;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gcu.dongdong2.MainActivity;
import com.gcu.dongdong2.R;
import com.gcu.dongdong2.databinding.FragmentPasswordChangeBinding;
import com.gcu.dongdong2.databinding.FragmentUserSettingBinding;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class ChangePasswordFragment extends Fragment {

    private FragmentPasswordChangeBinding binding;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private FragmentPasswordChangeBinding getBinding() {
        return binding;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPasswordChangeBinding.inflate(getLayoutInflater());

        binding.btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = auth.getCurrentUser();
                String newPassword = binding.textChangePassword.getText().toString();
                if (user != null) {
                    user.updatePassword(newPassword)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(requireContext(), "비밀번호가 변경되었습니다", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Log.e(TAG, String.valueOf(task.getException()));
                                    }
                                }
                            });
                }
            }
        });

        return binding.getRoot();
    }

}
