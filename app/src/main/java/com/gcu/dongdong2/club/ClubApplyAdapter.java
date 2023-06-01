package com.gcu.dongdong2.club;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.List;

public class ClubApplyAdapter extends RecyclerView.Adapter<ClubApplyViewHolder>{
    private List<String> dataList;

    public ClubApplyAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ClubApplyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_apply_qna, parent, false);
        return new ClubApplyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubApplyViewHolder holder, int position) {
        String data = dataList.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
