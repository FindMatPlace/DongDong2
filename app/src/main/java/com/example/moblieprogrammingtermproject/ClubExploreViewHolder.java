package com.example.moblieprogrammingtermproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ClubExploreViewHolder extends RecyclerView.ViewHolder {
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView;

    public ClubExploreViewHolder(View itemView) {
        super(itemView);
        textView1 = itemView.findViewById(R.id.clubName);
        textView2 = itemView.findViewById(R.id.clubCategory);// 아이템 뷰의 텍스트뷰 참조
        imageView = itemView.findViewById(R.id.clubLogo); // 아이템 뷰의 이미지뷰 참조
    }

    public void bindData(String data1, String data2, int imageResId) {
        textView1.setText(data1);
        textView2.setText(data2);
        imageView.setImageResource(imageResId);
    }
}
