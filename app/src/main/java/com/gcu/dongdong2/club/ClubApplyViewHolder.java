package com.gcu.dongdong2.club;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

public class ClubApplyViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public ClubApplyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.clubApplyQuestion); // 아이템 뷰의 텍스트뷰 참조
    }

    public void bindData(String data) {
        textView.setText(data);
    }
}
