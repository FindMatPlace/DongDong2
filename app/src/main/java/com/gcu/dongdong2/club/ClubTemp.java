
package com.gcu.dongdong2.club;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.gcu.dongdong2.FindFragment;
import com.gcu.dongdong2.databinding.ClubTempBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gcu.dongdong2.MainActivity;
import com.gcu.dongdong2.R;

public class ClubTemp extends Fragment {

    private ClubTempBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.club_temp, container, false);

        if (binding == null) {
            binding = ClubTempBinding.inflate(inflater, container, false);
        }

        binding.btnApplyTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 여기다 이벤트 작성

                ((MainActivity)getActivity()).replaceFragment(new ClubApplyActivity());
//                startActivity(intent);

            }
        });

        return binding.getRoot();
    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.club_temp);
//
//
//        Button Back_btn = (Button) findViewById(R.id.btnApplyTemp);
//        Back_btn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), ClubApplyActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button Back_btn2 = (Button) findViewById(R.id.btnExploreTemp);
//        Back_btn2.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), ClubExploreActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        Button Back_btn3 = (Button) findViewById(R.id.btnPostTemp);
//        Back_btn3.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), ClubPostActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button Back_btn4 = (Button) findViewById(R.id.btnPostSearchedTemp);
//        Back_btn4.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), ClubSearchedActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button Back_btn5 = (Button) findViewById(R.id.btnPostSearchingTemp);
//        Back_btn5.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(getApplicationContext(), ClubSearchingActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
}