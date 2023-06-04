package com.gcu.dongdong2.mainpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gcu.dongdong2.R;

public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the LinearLayout container
        LinearLayout eventContainer = view.findViewById(R.id.eventContainer);

        // Add example events
        addEvent(eventContainer, R.drawable.profile_image1, "Club Name 1", "Event 1", "Event Time 1", "Event Location 1");
        addEvent(eventContainer, R.drawable.profile_image2, "Club Name 2", "Event 2", "Event Time 2", "Event Location 2");
        addEvent(eventContainer, R.drawable.profile_image3, "Club Name 3", "Event 3", "Event Time 3", "Event Location 3");
    }

    private void addEvent(LinearLayout container, int clubImageRes, String clubName, String eventName, String eventTime, String eventLocation) {
        // Create a new LinearLayout for the event
        LinearLayout eventLayout = new LinearLayout(requireContext());
        eventLayout.setOrientation(LinearLayout.HORIZONTAL);
        eventLayout.setPadding(16, 16, 16, 16);

        // Create ImageView for club image
        ImageView clubImageView = new ImageView(requireContext());
        clubImageView.setImageResource(clubImageRes);
        LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        imageLayoutParams.setMarginEnd(16);
        eventLayout.addView(clubImageView, imageLayoutParams);

        // Create LinearLayout for event details
        LinearLayout eventDetailsLayout = new LinearLayout(requireContext());
        eventDetailsLayout.setOrientation(LinearLayout.VERTICAL);

        // Create TextView for club name
        TextView clubNameTextView = new TextView(requireContext());
        clubNameTextView.setText(clubName);
        clubNameTextView.setTextSize(18);
        eventDetailsLayout.addView(clubNameTextView);

        // Create TextView for event name
        TextView eventNameTextView = new TextView(requireContext());
        eventNameTextView.setText(eventName);
        eventDetailsLayout.addView(eventNameTextView);

        // Create TextView for event time
        TextView eventTimeTextView = new TextView(requireContext());
        eventTimeTextView.setText(eventTime);
        eventDetailsLayout.addView(eventTimeTextView);

        // Create TextView for event location
        TextView eventLocationTextView = new TextView(requireContext());
        eventLocationTextView.setText(eventLocation);
        eventDetailsLayout.addView(eventLocationTextView);

        LinearLayout.LayoutParams detailsLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        eventLayout.addView(eventDetailsLayout, detailsLayoutParams);

        // Add the event layout to the container
        LinearLayout.LayoutParams eventLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        eventLayoutParams.setMargins(0, 0, 0, 16);
        container.addView(eventLayout, eventLayoutParams);
    }
}
