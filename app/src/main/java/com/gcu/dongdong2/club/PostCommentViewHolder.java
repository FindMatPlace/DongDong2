package com.gcu.dongdong2.club;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

public class PostCommentViewHolder extends RecyclerView.ViewHolder {
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView;

    public PostCommentViewHolder(View itemView) {
        super(itemView);
        textView1 = itemView.findViewById(R.id.userName);
        textView2 = itemView.findViewById(R.id.userComment);// 아이템 뷰의 텍스트뷰 참조
        imageView = itemView.findViewById(R.id.userProfile); // 아이템 뷰의 이미지뷰 참조
    }

    public void bindData(String data1, String data2, int imageResId) {
        textView1.setText(data1);
        textView2.setText(data2);
        imageView.setImageResource(imageResId);
    }
}
