package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubPostFragment extends Fragment {

    private String Clubname;
    private String realclubname;
    private TextView clubName;
    private TextView postContent;
    private ImageView clubLogo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_post, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Clubname = bundle.getString("Clubname", "전달된 동아리가 없습니다");
            realclubname=Clubname;
        }

        clubName = rootView.findViewById(R.id.clubName);
        postContent = rootView.findViewById(R.id.clubPostContent);
        clubLogo = rootView.findViewById(R.id.clubLogo);

        clubName.setText(realclubname); // !!!!!동아리 이름
        postContent.setText("동아리 홍보글"); // !!!!!동아리 홍보글
        clubLogo.setImageResource(R.drawable.club_drawing1); // !!!!!동아리 로고

        RecyclerView recyclerView = rootView.findViewById(R.id.clubCommentRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()); // 세로 방향으로 아이템을 배치하는 레이아웃 매니저
        recyclerView.setLayoutManager(layoutManager);

        List<Comment> commentList = new ArrayList<>(); // !!!!!동아리 포스트에 달린 댓글 대한 정보를 넣어주면 됨 ( 유저 네임, 댓글 내용, 프로필사진 순 )

        commentList.add(new Comment("정규원","질문 1",R.drawable.club_drawing1));
        commentList.add(new Comment("이현석","질문 2",R.drawable.club_drawing1));
        commentList.add(new Comment("이한슬","질문 3",R.drawable.club_drawing1));

        PostCommentAdapter adapter = new PostCommentAdapter(commentList); // 데이터 소스를 가진 어댑터 객체 생성
        recyclerView.setAdapter(adapter); // RecyclerView에 어댑터 설정

        Button applyButton = rootView.findViewById(R.id.btnClubApply);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClubApplyFragment clubApplyFragment = new ClubApplyFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Clubname", realclubname);
                clubApplyFragment.setArguments(bundle);

                // Fragment 전환
                FragmentManager fragmentManager = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, clubApplyFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }
}