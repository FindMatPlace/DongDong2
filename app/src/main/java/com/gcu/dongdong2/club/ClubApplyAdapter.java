package com.gcu.dongdong2.club;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gcu.dongdong2.R;
import com.gcu.dongdong2.club.ClubApplyViewHolder;

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

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력 전 호출됩니다.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 입력 중 호출됩니다.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 입력 후 호출됩니다. 이곳에서 입력된 값을 사용할 수 있습니다.
                String enteredText = s.toString();
                // 입력된 값을 처리하거나 저장하는 등의 작업을 수행합니다.
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public interface OnTextChangedListener {
        void onTextChanged(int position, String inputText);
    }

}
