package com.gcu.dongdong2.mainpage;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.gcu.dongdong2.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ViewpagerFragmentAdapter extends FragmentStateAdapter {

    private List<Fragment> fragmentList = Arrays.asList(
            new HomeFragment.Fragment01(), new HomeFragment.Fragment02(), new HomeFragment.Fragment03());

    // 2. Set the number of Fragments to be displayed in ViewPager2
    public ViewpagerFragmentAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    // 3. Set the Fragment to be displayed on each page of ViewPager2
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }
}
