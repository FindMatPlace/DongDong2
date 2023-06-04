package com.gcu.dongdong2.club;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

import java.util.ArrayList;
import java.util.List;

public class PostCommentAdapter extends RecyclerView.Adapter<PostCommentViewHolder> {
    private List<Comment> commentList;

    public PostCommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public PostCommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_post_comment, parent, false);
        return new PostCommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostCommentViewHolder holder, int position) {


        Comment comment = commentList.get(position);
        holder.bindData(comment.getName(), comment.getComment(), comment.getLogoResId());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
