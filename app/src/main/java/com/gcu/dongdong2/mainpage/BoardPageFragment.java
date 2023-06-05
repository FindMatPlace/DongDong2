package com.gcu.dongdong2.mainpage;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
    private BoardItem boardItem;

    public BoardPageFragment() {
        // Required empty public constructor
    }

    public static BoardPageFragment newInstance(BoardItem boardItem) {
        BoardPageFragment fragment = new BoardPageFragment();
        Bundle args = new Bundle();
        args.putParcelable("boardItem", (Parcelable) boardItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            boardItem = getArguments().getParcelable("boardItem");
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

        if (boardItem != null) {
            ivProfile.setImageResource(boardItem.getProfileImage());
            ivContent.setImageURI(boardItem.getContentImageUri());
            tvName.setText(boardItem.getName());
            tvContent.setText(boardItem.getContent());
        }

        return view;
    }
}
