package com.gcu.dongdong2.club;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;
import com.gcu.dongdong2.club.Club;
import com.gcu.dongdong2.club.ClubExploreAdapter;

import java.util.ArrayList;
import java.util.List;

public class ClubExploreFragment extends Fragment {

    public ClubExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_explore, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.clubExploreRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<Club> clubList = new ArrayList<>();
        clubList.add(new Club("마타티아","가천대 유일 가톨릭 동아리", "기타", R.drawable.club_drawing1));
        clubList.add(new Club("EPU","댄스 동아리", "기타", R.drawable.club_drawing1));
        clubList.add(new Club("리더스","보드게임 동아리", "컴퓨터", R.drawable.club_drawing1));
        clubList.add(new Club("페이키","레저스포츠 동아리", "IT", R.drawable.club_drawing1));

        ClubExploreAdapter adapter = new ClubExploreAdapter(clubList);
        recyclerView.setAdapter(adapter);

        Button btnSearchingTemp = rootView.findViewById(R.id.searchclub);
        btnSearchingTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClubSearchingFragment clubPostSearchingFragment = new ClubSearchingFragment();

                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Fragment 트랜잭션에 ClubApplyFragment 추가
                fragmentTransaction.replace(R.id.frameLayout, clubPostSearchingFragment);

                // Fragment 트랜잭션 커밋
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

}