package com.gcu.dongdong2.club;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class ClubExploreAdapter extends RecyclerView.Adapter<ClubExploreAdapter.ClubExploreViewHolder> {
    private List<Club> clubList;
    private List<Club> filteredList;



    public ClubExploreAdapter(List<Club> clubList) {
        this.clubList = clubList;
        this.filteredList = new ArrayList<>(clubList);

    }

    @NonNull
    @Override
    public ClubExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_explore_list, parent, false);
        return new ClubExploreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubExploreViewHolder holder, int position) {
        Club club = filteredList.get(position);
        holder.bindData(club);

        holder.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer clubcode = 0; //!!!!!어떤 동아리에 대한건지에 대한 Code

                // Example: Sending data to another activity
                Intent intent = new Intent(view.getContext(), ClubPostFragment.class); //데이터를 전송할 클래스
                intent.putExtra("ClubCode", clubcode);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(clubList);
        } else {
            query = query.toLowerCase();
            for (Club club : clubList) {
                if (club.getName().toLowerCase().contains(query) ||
                        club.getCategory().toLowerCase().contains(query)) {
                    filteredList.add(club);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ClubExploreViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewClubName;
        private TextView textViewCategory;
        private ImageView imageViewClubLogo;
        private Button enterButton;

        public ClubExploreViewHolder(View itemView) {
            super(itemView);
            textViewClubName = itemView.findViewById(R.id.clubName);
            textViewCategory = itemView.findViewById(R.id.clubCategory);
            imageViewClubLogo = itemView.findViewById(R.id.clubLogo);
            enterButton = itemView.findViewById(R.id.clubEnterBtn);
        }

        public void bindData(Club club) {
            textViewClubName.setText(club.getName());
            textViewCategory.setText(club.getCategory());
            imageViewClubLogo.setImageResource(club.getLogoResId());
        }
    }





}
