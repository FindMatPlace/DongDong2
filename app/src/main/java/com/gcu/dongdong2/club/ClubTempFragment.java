package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.gcu.dongdong2.R;

public class ClubTempFragment extends Fragment {

    public ClubTempFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_temp, container, false);

        Button btnApplyTemp = rootView.findViewById(R.id.btnApplyTemp);
        btnApplyTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubApplyFragment.class);
                startActivity(intent);
            }
        });

        Button btnExploreTemp = rootView.findViewById(R.id.btnExploreTemp);
        btnExploreTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubExploreFragment.class);
                startActivity(intent);
            }
        });

        Button btnPostTemp = rootView.findViewById(R.id.btnPostTemp);
        btnPostTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubPostFragment.class);
                startActivity(intent);
            }
        });

        Button btnPostSearchedTemp = rootView.findViewById(R.id.btnPostSearchedTemp);
        btnPostSearchedTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubSearchedFragment.class);
                startActivity(intent);
            }
        });

        Button btnPostSearchingTemp = rootView.findViewById(R.id.btnPostSearchingTemp);
        btnPostSearchingTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ClubSearchingFragment.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
