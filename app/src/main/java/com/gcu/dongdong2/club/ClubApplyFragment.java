package com.gcu.dongdong2.club;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubApplyFragment extends Fragment implements View.OnClickListener {

    Button btnCamera;
    ImageView imageView;
    TextView ClubName;

    private ArrayList<String> AnswerList;

    private String clubname;

    public ClubApplyFragment() {
        AnswerList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_apply, container, false);

        btnCamera = rootView.findViewById(R.id.btnCamera);
        imageView = rootView.findViewById(R.id.cameraProfile);
        btnCamera.setOnClickListener(this);

        ClubName = rootView.findViewById(R.id.club_apply_name);

        Bundle args = getArguments();
        if (args != null) {
            clubname = args.getString("Clubname", "동아리 이름");
        }

        ClubName.setText(clubname); // clubcode를 통해 동아리 이름을 받아야함

        RecyclerView recyclerView = rootView.findViewById(R.id.clubApplyRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<String> dataList = new ArrayList<>(); // 동아리 지원서에 대한 질문을 받아야함

        dataList.add("질문 1");
        dataList.add("질문 2");
        dataList.add("질문 3");

        ClubApplyAdapter adapter = new ClubApplyAdapter(dataList);
        recyclerView.setAdapter(adapter);

        Button submitBtn = rootView.findViewById(R.id.btnClubApplyEnter);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    View itemView = recyclerView.getChildAt(i);
                    EditText editText = itemView.findViewById(R.id.clubApplyAnswer);
                    String inputData = editText.getText().toString();
                    AnswerList.add(inputData);
                }
                // dataList을 사용하여 원하는 작업 수행
                // 예를 들어, 데이터를 서버로 전송하거나 다른 액티비티로 전달할 수 있습니다.

                ClubExploreFragment clubExploreFragment = new ClubExploreFragment();

                // FragmentManager를 사용하여 Fragment 트랜잭션 시작
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Fragment 트랜잭션에 ClubExploreFragment 추가
                fragmentTransaction.replace(R.id.frameLayout, clubExploreFragment);

                // Fragment 트랜잭션 커밋
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCamera:
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 0);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}