package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.gcu.dongdong2.R;

public class ClubTemp extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_temp, container, false);

        Button Back_btn = rootView.findViewById(R.id.btnApplyTemp);
        Back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubApplyActivity.class);
                startActivity(intent);
            }
        });

        Button Back_btn2 = rootView.findViewById(R.id.btnExploreTemp);
        Back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubExploreActivity.class);
                startActivity(intent);
            }
        });

        Button Back_btn3 = rootView.findViewById(R.id.btnPostTemp);
        Back_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubPostActivity.class);
                startActivity(intent);
            }
        });

        Button Back_btn4 = rootView.findViewById(R.id.btnPostSearchedTemp);
        Back_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubSearchedActivity.class);
                startActivity(intent);
            }
        });

        Button Back_btn5 = rootView.findViewById(R.id.btnPostSearchingTemp);
        Back_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubSearchingActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
