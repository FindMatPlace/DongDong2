package com.gcu.dongdong2;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.gcu.dongdong2.mainpage.BoardItem;
import com.gcu.dongdong2.mainpage.PayFragment;
import com.gcu.dongdong2.mainpage.RecyclerViewAdaptor;
import com.gcu.dongdong2.mainpage.ScheduleFragment;

import com.gcu.dongdong2.mainpage.ViewpagerFragmentAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        ImageView imageView = view.findViewById(R.id.pay_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PayFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        // 1) Get reference to ViewPager2
        ViewPager2 viewPager = view.findViewById(R.id.bannerViewPager);

        // 2) Create FragmentStateAdapter: responsible for connecting multiple Fragments to ViewPager2
        ViewpagerFragmentAdapter viewpagerFragmentAdapter = new ViewpagerFragmentAdapter(getActivity());
        // 3) Set the adapter for ViewPager2
        viewPager.setAdapter(viewpagerFragmentAdapter);

        List<BoardItem> boardItemList = createDummyData();

        RecyclerView recyclerView = view.findViewById(R.id.recycle_board);
        RecyclerViewAdaptor adaptor = new RecyclerViewAdaptor(getContext(), boardItemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptor);

        return view;
    }
/*
    private List<BoardItem> createPost() {
        List<BoardItem> boardItemList = new ArrayList<>();
        CollectionReference postsRef = db.collection("posts");
        postsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                int num = 0;
                if (task.isSuccessful()) {
                    QuerySnapshot querySnapshot = task.getResult();
                    if (querySnapshot != null) {
                        for (QueryDocumentSnapshot document : querySnapshot) {
                            num++;
                            int profile = 0;
                            int contentImage = 0;
                            // 각 문서의 데이터 가져오기
                            String postId = document.getId();
                            switch (num % 3) {
                                case 0: {
                                    profile = R.drawable.profile_image1;
                                    contentImage = R.drawable.board_image1;
                                    break;
                                }
                                case 1: {
                                    profile = R.drawable.profile_image2;
                                    contentImage = R.drawable.board_image2;
                                    break;
                                }
                                case 2: {
                                    profile = R.drawable.profile_image3;
                                    contentImage = R.drawable.board_image1;
                                    break;
                                }
                                default: {
                                    profile = R.drawable.profile_image1;
                                    contentImage = R.drawable.board_image2;
                                }
                            }
                            Map<String, Object> postData = document.getData();
//                            new BoardItem(postData.get("profileImage"), postData.get("name"), postData.get("content"), postData.get("contentImage"));
                            boardItemList.add(new BoardItem(profile, (String) postData.get("name"), (String) postData.get("content"), contentImage));
                        }
                    } else {
                        Log.d(TAG, "컬렉션은 비어 있습니다.");
                    }
                } else {
                    Log.d(TAG, "데이터 가져오기 실패: " + task.getException());
                }
            }
        });

        return boardItemList;
    }
*/
    // Method to create dummy data for the board
    private List<BoardItem> createDummyData() {
        List<BoardItem> boardItemList = new ArrayList<>();
        // Add dummy items
        BoardItem item1 = new BoardItem(R.drawable.profile_image1, "정규원", "Lorem ipsum dolor sit amet", R.drawable.board_image1, 1);
        BoardItem item2 = new BoardItem(R.drawable.profile_image2, "이현석", "Consectetur adipiscing elit", R.drawable.board_image2, 2);
        BoardItem item3 = new BoardItem(R.drawable.profile_image3, "권민우", "Sed do eiusmod tempor incididunt", R.drawable.board_image1, 3);

        boardItemList.add(item1);
        boardItemList.add(item2);
        boardItemList.add(item3);

        return boardItemList;
    }

    public static class Fragment01 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.banner1_fragment, container, false);

            LinearLayout banner1Layout = view.findViewById(R.id.banner1);
            banner1Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 프래그먼트 전환 코드 작성
                    Fragment fragment = new ScheduleFragment(); // 전환할 프래그먼트로 대체해주세요
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment); // fragment_container는 프래그먼트를 표시할 레이아웃의 ID입니다.
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
            return view;
        }
    }

    public static class Fragment02 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.banner2_fragment, container, false);

            LinearLayout banner2Layout = view.findViewById(R.id.banner2);
            banner2Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 프래그먼트 전환 코드 작성
                    Fragment fragment = new ScheduleFragment(); // 전환할 프래그먼트로 대체해주세요
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment); // fragment_container는 프래그먼트를 표시할 레이아웃의 ID입니다.
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
            return view;
        }
    }

    public static class Fragment03 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.banner3_fragment, container, false);

            LinearLayout banner3Layout = view.findViewById(R.id.banner3);
            banner3Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 프래그먼트 전환 코드 작성
                    Fragment fragment = new ScheduleFragment(); // 전환할 프래그먼트로 대체해주세요
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment); // fragment_container는 프래그먼트를 표시할 레이아웃의 ID입니다.
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
            return view;
        }
    }
}