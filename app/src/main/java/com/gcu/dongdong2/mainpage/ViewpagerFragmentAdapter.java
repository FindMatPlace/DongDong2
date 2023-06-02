package com.gcu.dongdong2.mainpage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.gcu.dongdong2.HomeFragment;

import java.util.Arrays;
import java.util.List;

public class ViewpagerFragmentAdapter extends FragmentStateAdapter {

    // 1. Create Fragments to be connected to ViewPager2
    private List<Fragment> fragmentList = Arrays.asList(new HomeFragment.Fragment01(), new HomeFragment.Fragment02(), new HomeFragment.Fragment03());

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
