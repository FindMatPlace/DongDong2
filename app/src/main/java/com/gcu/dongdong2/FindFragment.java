package com.gcu.dongdong2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gcu.dongdong2.R;
import com.gcu.dongdong2.club.ClubApplyFragment;
import com.gcu.dongdong2.club.ClubExploreFragment;
import com.gcu.dongdong2.club.ClubPostFragment;
import com.gcu.dongdong2.club.ClubSearchedFragment;
import com.gcu.dongdong2.club.ClubSearchingFragment;

public class FindFragment extends Fragment {

    public FindFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View rootView = inflater.inflate(R.layout.club_explore, container, false);

                ClubExploreFragment clubExploreFragment = new ClubExploreFragment();

                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Fragment 트랜잭션에 ClubExploreFragment 추가
                fragmentTransaction.replace(R.id.frameLayout, clubExploreFragment);

                // Fragment 트랜잭션 커밋
                fragmentTransaction.commit();

//        Button btnApplyTemp = rootView.findViewById(R.id.btnApplyTemp);
//        btnApplyTemp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClubApplyFragment clubApplyFragment = new ClubApplyFragment();
//
//                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
//                FragmentManager fragmentManager = getParentFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                // Fragment 트랜잭션에 ClubApplyFragment 추가
//                fragmentTransaction.replace(R.id.frameLayout, clubApplyFragment);
//
//                // Fragment 트랜잭션 커밋
//                fragmentTransaction.commit();
//            }
//        });
//
//        Button btnExploreTemp = rootView.findViewById(R.id.btnExploreTemp);
//        btnExploreTemp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClubExploreFragment clubExploreFragment = new ClubExploreFragment();
//
//                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
//                FragmentManager fragmentManager = getParentFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                // Fragment 트랜잭션에 ClubExploreFragment 추가
//                fragmentTransaction.replace(R.id.frameLayout, clubExploreFragment);
//
//                // Fragment 트랜잭션 커밋
//                fragmentTransaction.commit();
//            }
//        });
//
//        Button btnPostTemp = rootView.findViewById(R.id.btnPostTemp);
//        btnPostTemp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClubPostFragment clubPostFragment = new ClubPostFragment();
//
//                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
//                FragmentManager fragmentManager = getParentFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                // Fragment 트랜잭션에 ClubApplyFragment 추가
//                fragmentTransaction.replace(R.id.frameLayout, clubPostFragment);
//
//                // Fragment 트랜잭션 커밋
//                fragmentTransaction.commit();
//            }
//        });
//
//
//        Button btnSearchedTemp = rootView.findViewById(R.id.btnPostSearchedTemp);
//        btnSearchedTemp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClubSearchedFragment clubPostSearchedFragment = new ClubSearchedFragment();
//
//                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
//                FragmentManager fragmentManager = getParentFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                // Fragment 트랜잭션에 ClubApplyFragment 추가
//                fragmentTransaction.replace(R.id.frameLayout, clubPostSearchedFragment);
//
//                // Fragment 트랜잭션 커밋
//                fragmentTransaction.commit();
//            }
//        });
//
//        Button btnSearchingTemp = rootView.findViewById(R.id.btnPostSearchingTemp);
//        btnSearchingTemp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ClubSearchingFragment clubPostSearchingFragment = new ClubSearchingFragment();
//
//                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
//                FragmentManager fragmentManager = getParentFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                // Fragment 트랜잭션에 ClubApplyFragment 추가
//                fragmentTransaction.replace(R.id.frameLayout, clubPostSearchingFragment);
//
//                // Fragment 트랜잭션 커밋
//                fragmentTransaction.commit();
//            }
//        });

        return rootView;
    }
}