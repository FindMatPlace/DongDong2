package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubSearchingFragment extends Fragment {

    private ClubExploreAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_searching, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.clubRecommendRecycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Club> clubList = new ArrayList<>();
        clubList.add(new Club("Club A", "Category 1", R.drawable.club_drawing1));
        clubList.add(new Club("Club B", "Category 2", R.drawable.club_drawing1));
        clubList.add(new Club("Club C", "Category 3", R.drawable.club_drawing1));

        adapter = new ClubExploreAdapter(clubList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        Button Back_btn = rootView.findViewById(R.id.go_searched);
        Back_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(requireContext(), ClubSearchedFragment.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

