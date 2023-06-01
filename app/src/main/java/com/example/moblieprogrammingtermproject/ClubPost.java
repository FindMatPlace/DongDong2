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

public class ClubPost extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_post);

        RecyclerView recyclerView = findViewById(R.id.clubCommentRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment("Club A", "Category 1", R.drawable.club_drawing1));
        commentList.add(new Comment("Club B", "Category 2", R.drawable.club_drawing1));
        commentList.add(new Comment("Club C", "Category 3", R.drawable.club_drawing1));

        PostCommentAdapter adapter = new PostCommentAdapter(commentList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        Button Apply_btn = (Button) findViewById(R.id.btnClubApply);
        Apply_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ClubApply.class);
                startActivity(intent);
            }
        });
    }
}

