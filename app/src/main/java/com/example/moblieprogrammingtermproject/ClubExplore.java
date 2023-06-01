package com.example.moblieprogrammingtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClubExplore extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_explore);

        RecyclerView recyclerView = findViewById(R.id.clubExploreRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Club> clubList = new ArrayList<>();
        clubList.add(new Club("Club A", "Category 1", R.drawable.club_drawing1));
        clubList.add(new Club("Club B", "Category 2", R.drawable.club_drawing1));
        clubList.add(new Club("Club C", "Category 3", R.drawable.club_drawing1));

        ClubExploreAdapter adapter = new ClubExploreAdapter(clubList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        Button Back_btn = (Button) findViewById(R.id.btnBack);
        Back_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ClubSearching.class);
                startActivity(intent);
            }
        });

        Button Notification_btn = (Button) findViewById(R.id.btnNotification);
        Notification_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), XXXXX.class);
//                startActivity(intent);
            }
        });
    }
}
