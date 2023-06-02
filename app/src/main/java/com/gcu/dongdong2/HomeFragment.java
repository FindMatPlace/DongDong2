package com.gcu.dongdong2;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.gcu.dongdong2.mainpage.BoardAdapter;
import com.gcu.dongdong2.mainpage.BoardItem;
import com.gcu.dongdong2.mainpage.ViewpagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 1) Get reference to ViewPager2
        ViewPager2 viewPager = view.findViewById(R.id.bannerViewPager);

        // 2) Create FragmentStateAdapter: responsible for connecting multiple Fragments to ViewPager2
        ViewpagerFragmentAdapter viewpagerFragmentAdapter = new ViewpagerFragmentAdapter(getActivity());
        // 3) Set the adapter for ViewPager2
        viewPager.setAdapter(viewpagerFragmentAdapter);
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycle_board);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<BoardItem> boardItemList = createDummyData();
        BoardAdapter boardAdapter = new BoardAdapter(getActivity(), boardItemList);
        recyclerView.setAdapter(boardAdapter);

        return view;
    }

    // Method to create dummy data for the board
    private List<BoardItem> createDummyData() {
        List<BoardItem> boardItemList = new ArrayList<>();

        // Add dummy items
        BoardItem item1 = new BoardItem(R.drawable.profile_image1, "정규원", "Lorem ipsum dolor sit amet", R.drawable.board_image1);
        BoardItem item2 = new BoardItem(R.drawable.profile_image2, "이현석", "Consectetur adipiscing elit", R.drawable.board_image2);
        BoardItem item3 = new BoardItem(R.drawable.profile_image3, "권민우", "Sed do eiusmod tempor incididunt", R.drawable.board_image1);

        boardItemList.add(item1);
        boardItemList.add(item2);
        boardItemList.add(item3);

        return boardItemList;
    }
    public static class Fragment01 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.banner1_fragment, container, false);
        }
    }

    public static class Fragment02 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.banner2_fragment, container, false);
        }
    }

    public static class Fragment03 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.banner3_fragment, container, false);
        }
    }
}