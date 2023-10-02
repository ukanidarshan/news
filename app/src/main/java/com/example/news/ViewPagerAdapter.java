package com.example.news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
//        Recycler recycler = new Recycler(position);
        if (position == 1)
            fragment = new Feed();

        else if (position == 0)
            fragment = new Discover();

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
//    @Override
//    public CharSequence getPageTitle(int position)
//    {
//        String title = null;
//        if (position == 0)
//            title = "Feed";
//
//        else if (position == 1)
//            title = "Discover";
//        return title;
//    }
}
