package com.gcu.dongdong2;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlarmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlarmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmFragment newInstance(String param1, String param2) {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        ListView listView = view.findViewById(R.id.alarmview);
        AlarmListViewAdapter adapter = new AlarmListViewAdapter();

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(requireContext(), R.drawable.ic_account_circle_balck_36dp),
                "동아리 이름", "알림 내용");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(requireContext(), R.drawable.ic_account_circle_balck_36dp),
                "동아리 이름", "알림 내용");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(requireContext(), R.drawable.ic_account_circle_balck_36dp),
                "동아리 이름", "알림 내용");

        listView.setAdapter(adapter);

        return view;
    }
}