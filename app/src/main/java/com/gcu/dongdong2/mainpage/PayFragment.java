package com.gcu.dongdong2.mainpage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gcu.dongdong2.HomeFragment;
import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class PayFragment extends Fragment {
    private List<PayFragment.Event> events;

    public PayFragment() {
        // Required empty public constructor
    }

    public static PayFragment newInstance() {
        return new PayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pay, container, false);

        Toolbar toolbar = view.findViewById(R.id.pay_toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 뒤로 가기 버튼 클릭 시 동작
                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout container = view.findViewById(R.id.payContainer);

        // Add example events
        events = new ArrayList<>();
        events.add(new PayFragment.Event(R.drawable.club_logo1, "바보 동아리", "5차 정모", "2023년 5월 17일 20시", "노원역", 25000, 0));
        events.add(new PayFragment.Event(R.drawable.club_logo2, "가천 동아리", "번개모임", "2023년 5월 18일 14시", "가천대역", 20000, 0));
        events.add(new PayFragment.Event(R.drawable.club_logo3, "바보 동아리", "6차 정모", "2023년 5월 20일 17시", "창동역", 30000, 0));

        for (PayFragment.Event event : events) {
            View eventView = LayoutInflater.from(requireContext()).inflate(R.layout.pay_item, container, false);

            // Find views within the event item layout
            ImageView clubImageView = eventView.findViewById(R.id.pay_logo);
            TextView clubNameTextView = eventView.findViewById(R.id.pay_club);
            TextView eventNameTextView = eventView.findViewById(R.id.pay_name);
            TextView eventTimeTextView = eventView.findViewById(R.id.pay_time);
            TextView eventLocationTextView = eventView.findViewById(R.id.pay_location);
            Button payAmount = eventView.findViewById(R.id.pay_amount);
            Button paySend = eventView.findViewById(R.id.pay_send);

            // Set data to the views
            clubImageView.setImageResource(event.clubImageRes);
            clubNameTextView.setText(event.clubName);
            eventNameTextView.setText(event.eventName);
            eventTimeTextView.setText(event.eventTime);
            eventLocationTextView.setText(event.eventLocation);
            payAmount.setText(String.valueOf(event.payment));
            if(event.sendCheck == 0) {
                paySend.setText("송금하기");
                paySend.setBackgroundColor(Color.parseColor("#23C562"));
                payAmount.setBackgroundColor(Color.parseColor("#1867FF"));
            } else if (event.sendCheck == 1) {
                paySend.setText("송금중");
                paySend.setBackgroundColor(Color.parseColor("#FFAD31"));
                payAmount.setBackgroundColor(Color.parseColor("#1867FF"));
            }else {
                paySend.setText("송금완료");
                paySend.setBackgroundColor(Color.parseColor("#D3D3D3"));
                payAmount.setBackgroundColor(Color.parseColor("#D3D3D3"));
            }

            // Set click listener to the participation button
            paySend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (event.sendCheck == 0) {
                        paySend.setText("송금중");
                        paySend.setBackgroundColor(Color.parseColor("#FFAD31"));
                    } else if(event.sendCheck == 1){
                        paySend.setText("송금완료");
                        paySend.setBackgroundColor(Color.parseColor("#D3D3D3"));
                        payAmount.setBackgroundColor(Color.parseColor("#D3D3D3"));
                    }
                    event.sendCheck = event.sendCheck + 1;
                }
            });
            container.addView(eventView);
        }
    }

    private static class Event {
        private int clubImageRes;
        private String clubName;
        private String eventName;
        private String eventTime;
        private String eventLocation;
        private int payment;
        private int sendCheck; // 0: 송금하기, 1: 송금중, 2: 송금완료

        public Event(int clubImageRes, String clubName, String eventName, String eventTime, String eventLocation, int payment, int sendCheck) {
            this.clubImageRes = clubImageRes;
            this.clubName = clubName;
            this.eventName = eventName;
            this.eventTime = eventTime;
            this.eventLocation = eventLocation;
            this.payment = payment;
            this.sendCheck = sendCheck;
        }

        public int getClubImageRes() {
            return clubImageRes;
        }

        public String getClubName() {
            return clubName;
        }

        public String getEventName() {
            return eventName;
        }

        public String getEventTime() {
            return eventTime;
        }

        public String getEventLocation() {
            return eventLocation;
        }

        public int getPayment() {
            return payment;
        }

        public int getSendCheck() {
            return sendCheck;
        }
    }
}
