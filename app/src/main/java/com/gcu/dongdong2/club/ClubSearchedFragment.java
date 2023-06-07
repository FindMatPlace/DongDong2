package com.gcu.dongdong2.club;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubSearchedFragment extends Fragment {

    private ClubExploreAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_searched, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.clubSearchedRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Club> clubList = new ArrayList<>(); /////!!!!! 동아리 정보에 대한 데이터 ( 동아리 이름, 카테고리, 로고 순 )
        clubList.add(new Club("Matatia","가천대 유일 가톨릭 동아리", "기타", R.drawable.club_drawing1)); //Test dataset
        clubList.add(new Club("Leaders", "보드게임 동아리","Category 1", R.drawable.club_drawing1));
        clubList.add(new Club("Snapshot","사진 출사", "기타", R.drawable.club_drawing1));
        clubList.add(new Club("FAKIE","레저스포츠 동아리", "IT", R.drawable.club_drawing1));


        adapter = new ClubExploreAdapter(clubList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        EditText searchEditText = rootView.findViewById(R.id.clubSearchInput);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 이 메서드는 사용하지 않습니다.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString();
                adapter.filter(query);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 이 메서드는 사용하지 않습니다.
            }
        });

        return rootView;
    }
}
