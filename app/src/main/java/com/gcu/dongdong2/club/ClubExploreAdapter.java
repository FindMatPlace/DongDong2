package com.gcu.dongdong2.club;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

//public class ClubExploreAdapter extends RecyclerView.Adapter<ClubExploreViewHolder> {
//    private List<Club> clubList;
//
//    public ClubExploreAdapter(List<Club> clubList) {
//        this.clubList = clubList;
//    }
//
//    @NonNull
//    @Override
//    public ClubExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_explore_list, parent, false);
//        return new ClubExploreViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ClubExploreViewHolder holder, int position) {
//        Club club = clubList.get(position);
//        holder.bindData(club.getName(), club.getCategory(), club.getLogoResId());
//    }
//
//    @Override
//    public int getItemCount() {
//        return clubList.size();
//    }
//}

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

        public ClubExploreViewHolder(View itemView) {
            super(itemView);
            textViewClubName = itemView.findViewById(R.id.clubName);
            textViewCategory = itemView.findViewById(R.id.clubCategory);
            imageViewClubLogo = itemView.findViewById(R.id.clubLogo);
        }

        public void bindData(Club club) {
            textViewClubName.setText(club.getName());
            textViewCategory.setText(club.getCategory());
            imageViewClubLogo.setImageResource(club.getLogoResId());
        }
    }
}
