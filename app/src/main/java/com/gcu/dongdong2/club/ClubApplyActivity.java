package com.gcu.dongdong2.club;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubApplyActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCamera;
    ImageView imageView;
    TextView ClubName;

    private int clubcode = (Integer)getIntent().getSerializableExtra("ClubCode"); //!!!!!ClubPostActivity에서 받은 clubcode

    private ArrayList<String> AnswerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_apply);

        btnCamera = (Button) findViewById(R.id.btnCamera);
        imageView = (ImageView) findViewById(R.id.cameraProfile);
        btnCamera.setOnClickListener(this);

        ClubName= (TextView)findViewById(R.id.club_apply_name);
        ClubName.setText("동아리 이름"); //!!!!!clubcode를 통해 동아리 이름을 받아야함

        RecyclerView recyclerView = findViewById(R.id.clubApplyRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);


        List<String> dataList = new ArrayList<>(); //!!!!! 동아리 지원서에 대한 질문을 받아야함
        ClubApplyAdapter adapter = new ClubApplyAdapter(dataList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        Button submitBtn = (Button) findViewById(R.id.btnClubApplyEnter);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 리사이클러뷰의 아이템을 순회하면서 EditText의 값을 읽어와서 dataList에 추가
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    View itemView = recyclerView.getChildAt(i);
                    EditText editText = itemView.findViewById(R.id.clubApplyAnswer);
                    String inputData = editText.getText().toString();
                    AnswerList.add(inputData);
                }
                // dataList을 사용하여 원하는 작업 수행
                // 예를 들어, 데이터를 서버로 전송하거나 다른 액티비티로 전달할 수 있습니다.
            }
        });
    }

    @Override
    public void onClick(View view)    {
        switch (view.getId()) {
            // 카메라촬영 클릭 이벤트
            case R.id.btnCamera:
                // 카메라 기능을 Intent
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)    {
        super.onActivityResult(requestCode, resultCode, data);

        // 카메라 촬영을 하면 이미지뷰에 사진 삽입
        if(requestCode == 0 && resultCode == RESULT_OK) {
            // Bundle로 데이터를 입력
            Bundle extras = data.getExtras();

            // Bitmap으로 컨버전
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // 이미지뷰에 Bitmap으로 이미지를 입력
            imageView.setImageBitmap(imageBitmap);
        }
    }


}