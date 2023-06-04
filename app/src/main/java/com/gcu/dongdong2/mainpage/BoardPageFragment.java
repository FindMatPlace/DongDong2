package com.gcu.dongdong2.mainpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gcu.dongdong2.HomeFragment;
import com.gcu.dongdong2.R;

public class BoardPageFragment extends Fragment {
    private int profileImage;
    private int contentImage;
    private String name;
    private String content;

    public BoardPageFragment() {
        // Required empty public constructor
    }

    public static BoardPageFragment newInstance(int profileImage, int contentImage, String name, String content) {
        BoardPageFragment fragment = new BoardPageFragment();
        Bundle args = new Bundle();
        args.putInt("profile_image_url", profileImage);
        args.putInt("content_image_url", contentImage);
        args.putString("name", name);
        args.putString("content", content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileImage = getArguments().getInt("profile_image_url");
            contentImage = getArguments().getInt("content_image_url");
            name = getArguments().getString("name");
            content = getArguments().getString("content");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 뒤로 가기 버튼 클릭 시 동작
                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageView ivProfile = view.findViewById(R.id.iv_profile);
        ImageView ivContent = view.findViewById(R.id.iv_content);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvContent = view.findViewById(R.id.tv_content);

        ivProfile.setImageResource(profileImage);
        ivContent.setImageResource(contentImage);
        tvName.setText(name);
        tvContent.setText(content);

        return view;
    }
}
