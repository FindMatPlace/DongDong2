package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubSearchedActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_searched);

        RecyclerView recyclerView = findViewById(R.id.clubSearchedRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Club> clubList = new ArrayList<>(); /////!!!!! 동아리 정보에 대한 데이터 ( 동아리 이름, 카테고리, 로고 순 )
        clubList.add(new Club("ABC", "Category 1", R.drawable.club_drawing1));
        clubList.add(new Club("BCD", "Category 2", R.drawable.club_drawing1));
        clubList.add(new Club("DEF", "Category 3", R.drawable.club_drawing1)); //Test dataset

        ClubExploreAdapter adapter = new ClubExploreAdapter(clubList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정


        EditText searchEditText = findViewById(R.id.clubSearchInput);
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



    }
}