package com.gcu.dongdong2.userInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.gcu.dongdong2.MainActivity;
import com.gcu.dongdong2.R;
import com.gcu.dongdong2.databinding.FragmentUserSettingBinding;

public class ChangePasswordFragment extends Fragment {

    private FragmentUserSettingBinding binding;
    private FragmentUserSettingBinding getBinding() {
        return binding;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserSettingBinding.inflate(getLayoutInflater());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_change, container, false);
    }

}
