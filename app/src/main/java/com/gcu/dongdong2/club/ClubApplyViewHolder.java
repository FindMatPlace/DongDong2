package com.gcu.dongdong2.club;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;

public class ClubApplyViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    EditText editText;

    public ClubApplyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.clubApplyQuestion); // 아이템 뷰의 텍스트뷰 참조
        editText = itemView.findViewById(R.id.clubApplyAnswer);
    }

    public void bindData(String data) {
        textView.setText(data);
    }




}
