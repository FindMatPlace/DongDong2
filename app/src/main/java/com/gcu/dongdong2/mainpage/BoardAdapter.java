package com.gcu.dongdong2.mainpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    private Context context;
    private List<BoardItem> boardItemList;

    public BoardAdapter(Context context, List<BoardItem> boardItemList) {
        this.context = context;
        this.boardItemList = boardItemList;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        return new BoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        BoardItem item = boardItemList.get(position);

        // 아이템의 데이터를 ViewHolder의 각 뷰에 설정
        holder.ivProfile.setImageResource(item.getProfileImage());
        holder.tvName.setText(item.getName());
        holder.tvContent.setText(item.getContent());
        holder.ivContent.setImageResource(item.getContentImage());
    }

    @Override
    public int getItemCount() {
        return boardItemList.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile, ivContent;
        TextView tvName, tvContent;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvName = itemView.findViewById(R.id.tv_name);
            ivContent = itemView.findViewById(R.id.iv_content);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}

