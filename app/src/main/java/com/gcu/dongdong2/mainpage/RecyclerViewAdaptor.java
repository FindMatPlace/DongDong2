package com.gcu.dongdong2.mainpage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;
import com.squareup.picasso.Picasso;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.MyViewHolder> {
    private Context mContext;
    List<BoardItem> itemList;

    public RecyclerViewAdaptor(Context context, List<BoardItem> itemList){
        this.mContext = context;
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_profile;
        ImageView iv_content;
        TextView tv_name;
        TextView tv_content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            iv_content = itemView.findViewById(R.id.iv_content);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_content = itemView.findViewById(R.id.tv_content);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                BoardItem item = itemList.get(position);
                showBoardPageFragment(item);
            }
        }
        private void showBoardPageFragment(BoardItem item) {
            Fragment fragment = BoardPageFragment.newInstance(item);
            FragmentTransaction transaction = ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.frameLayout, fragment);

            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BoardItem item = itemList.get(position);
        holder.tv_name.setText(item.getName());
        holder.tv_content.setText(item.getContent()); // 원하는 내용으로 변경해주세요
        holder.iv_profile.setImageResource(item.getProfileImage()); // 프로필 이미지를 설정해주세요
        Picasso.get().load(item.getContentImageUri()).into(holder.iv_content);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }
}
