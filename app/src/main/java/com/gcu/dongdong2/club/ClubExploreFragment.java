package com.gcu.dongdong2.club;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;
import com.gcu.dongdong2.club.Club;
import com.gcu.dongdong2.club.ClubExploreAdapter;

import java.util.ArrayList;
import java.util.List;

public class ClubExploreFragment extends Fragment {

    public ClubExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.club_explore, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.clubExploreRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        List<Club> clubList = new ArrayList<>();
        clubList.add(new Club("Club A", "Category 1", R.drawable.club_drawing1));
        clubList.add(new Club("Club B", "Category 2", R.drawable.club_drawing1));
        clubList.add(new Club("Club C", "Category 3", R.drawable.club_drawing1));

        ClubExploreAdapter adapter = new ClubExploreAdapter(clubList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}