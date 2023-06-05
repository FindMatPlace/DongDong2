package com.gcu.dongdong2.mainpage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gcu.dongdong2.HomeFragment;
import com.gcu.dongdong2.R;
import com.squareup.picasso.Picasso;

public class WriteFragment extends Fragment {

    private EditText editText;
    private ImageButton uploadButton;
    private ImageView uploadView;
    private ImageButton submitButton;
    private Uri selectedImageUri;

    public WriteFragment() {
        // Required empty public constructor
    }

    public static WriteFragment newInstance() {
        return new WriteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write, container, false);

        Toolbar toolbar = view.findViewById(R.id.write_toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 뒤로 가기 버튼 클릭 시 동작
                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        editText = view.findViewById(R.id.write_text);
        uploadButton = view.findViewById(R.id.upload_button);
        uploadView = view.findViewById(R.id.upload_view);
        submitButton = view.findViewById(R.id.submit_button);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open image picker
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle post submission logic here
                String text = editText.getText().toString();
                Uri imageUri = selectedImageUri; // Get the selected image URI from onActivityResult
                if (imageUri != null) {
                    // Load and display the selected image using Picasso
                    Picasso.get().load(imageUri).into(uploadView);
                }
                BoardItem boardItem = new BoardItem(R.drawable.profile_image1, "Your Name", text, imageUri, 4);

                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            // Get selected image URI
            selectedImageUri = data.getData();

            // Load and display the selected image using Picasso
            Picasso.get().load(selectedImageUri).into(uploadView);
        }
    }
}
