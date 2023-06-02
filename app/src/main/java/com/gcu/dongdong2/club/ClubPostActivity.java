package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubPostActivity extends AppCompatActivity {

    private int ClubCode = (Integer)getIntent().getSerializableExtra("ClubCode"); //!!!!!ClubExploreAdapter에서 받은 clubcode

    TextView clubName;
    TextView postContent;
    ImageView clubLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_post);

        clubName= (TextView)findViewById(R.id.clubName);
        postContent= (TextView)findViewById(R.id.clubPostContent);
        clubLogo = (ImageView) findViewById(R.id.clubLogo);

        clubName.setText("동아리 이름"); //!!!!!동아리 이름
        postContent.setText("동아리 홍보글"); //!!!!!동아리 홍보글
        clubLogo.setImageResource(R.drawable.club_drawing1); //!!!!!동아리 로고

        RecyclerView recyclerView = findViewById(R.id.clubCommentRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Comment> commentList = new ArrayList<>(); //!!!!!동아리 포스트에 달린 댓글 대한 정보를 넣어주면 됨 ( 유저 네임, 댓글 내용, 프로필사진 순 )
        PostCommentAdapter adapter = new PostCommentAdapter(commentList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        Button Apply_btn = (Button) findViewById(R.id.btnClubApply);
        Apply_btn.setOnClickListener(new View.OnClickListener(){

            //버튼 클릭 후 해당 동아리 신청서로 감
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ClubApplyActivity.class);
                intent.putExtra("ClubCode", ClubCode); //!!!!!어떤 동아리에 대한 지원서인지 코드 전달
                startActivity(intent);
            }
        });
    }
}
