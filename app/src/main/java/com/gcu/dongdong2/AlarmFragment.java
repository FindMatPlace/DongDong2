package com.gcu.dongdong2;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class AlarmFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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