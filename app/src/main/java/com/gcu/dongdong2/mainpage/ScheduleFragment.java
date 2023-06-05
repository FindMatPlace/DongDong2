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
import com.google.firebase.events.Event;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    private List<Event> events;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        Toolbar toolbar = view.findViewById(R.id.sche_toolbar);
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

        LinearLayout container = view.findViewById(R.id.eventContainer);

        // Add example events
        events = new ArrayList<>();
        events.add(new Event(R.drawable.club_logo1, "Club Name 1", "Event 1", "Event Time 1", "Event Location 1", false));
        events.add(new Event(R.drawable.club_logo2, "Club Name 2", "Event 2", "Event Time 2", "Event Location 2", true));
        events.add(new Event(R.drawable.club_logo3, "Club Name 3", "Event 3", "Event Time 3", "Event Location 3", false));

        for (Event event : events) {
            View eventView = LayoutInflater.from(requireContext()).inflate(R.layout.schedule_item, container, false);

            // Find views within the event item layout
            ImageView clubImageView = eventView.findViewById(R.id.cl_img);
            TextView clubNameTextView = eventView.findViewById(R.id.cl_name);
            TextView eventNameTextView = eventView.findViewById(R.id.schedule_name);
            TextView eventTimeTextView = eventView.findViewById(R.id.schedule_time);
            TextView eventLocationTextView = eventView.findViewById(R.id.schedule_location);
            Button participationButton = eventView.findViewById(R.id.participation);

            // Set data to the views
            clubImageView.setImageResource(event.clubImageRes);
            clubNameTextView.setText(event.clubName);
            eventNameTextView.setText(event.eventName);
            eventTimeTextView.setText(event.eventTime);
            eventLocationTextView.setText(event.eventLocation);
            participationButton.setText(event.isParticipating() ? "참여예정" : "참여하기");
            participationButton.setTextColor(event.isParticipating() ? Color.parseColor("#000000") : Color.parseColor("#23C562"));

            // Set click listener to the participation button
            participationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    event.setParticipating(!event.isParticipating()); // Toggle participation

                    if (event.isParticipating()) {
                        participationButton.setText("참여예정");
                        participationButton.setTextColor(Color.parseColor("#000000"));
                    } else {
                        participationButton.setText("참여하기");
                        participationButton.setTextColor(Color.parseColor("#23C562"));
                    }
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
        private boolean participating; // 참여 여부를 나타내는 변수

        public Event(int clubImageRes, String clubName, String eventName, String eventTime, String eventLocation, boolean participating) {
            this.clubImageRes = clubImageRes;
            this.clubName = clubName;
            this.eventName = eventName;
            this.eventTime = eventTime;
            this.eventLocation = eventLocation;
            this.participating = participating;
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

        public boolean isParticipating() {
            return participating;
        }

        public void setParticipating(boolean participating) {
            this.participating = participating;
        }
    }
}
