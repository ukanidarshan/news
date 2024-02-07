package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.news.databinding.ActivityRecyclerBinding;

public class Recycler extends AppCompatActivity {
//    public Recycler() {
//    }

    ActivityRecyclerBinding binding;

    ViewPagerAdapter viewPagerAdapter;
    private Handler delayhandler;

//    public Recycler(int position) {
//        if (position==0){
//            binding.forward.setVisibility(View.GONE);
//            binding.f2.setVisibility(View.GONE);
//            binding.d2.setVisibility(View.GONE);
//            binding.setting.setVisibility(View.GONE);
//
//            binding.Discover.setVisibility(View.VISIBLE);
//            binding.Feed.setVisibility(View.VISIBLE);
//            binding.back.setVisibility(View.VISIBLE);
//        } else if (position==1) {
//            binding.back.setVisibility(View.GONE);
//            binding.Feed.setVisibility(View.GONE);
//            binding.Discover.setVisibility(View.GONE);
//
//            binding.forward.setVisibility(View.VISIBLE);
//            binding.f2.setVisibility(View.VISIBLE);
//            binding.d2.setVisibility(View.VISIBLE);
//            binding.setting.setVisibility(View.VISIBLE);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager());
        binding.viewpage.setAdapter(viewPagerAdapter);
        binding.viewpage.setCurrentItem(1);
        inIt();
        binding.setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recycler.this, Setting.class);
                startActivity(intent);

            }
        });

        // It is used to join TabLayout with ViewPager.
    }

    private void inIt() {
        delayhandler = new Handler();
        delayhandler.postDelayed(mUpdateTimeTask, 1);
        binding.Discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewpage.setCurrentItem(0);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewpage.setCurrentItem(0);
            }
        });
        binding.f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewpage.setCurrentItem(1);
            }
        });
        binding.forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewpage.setCurrentItem(1);
            }
        });
    }

    Runnable mUpdateTimeTask= new Runnable() {
        public void run() {

            if (binding.viewpage.getCurrentItem() == 0) {
                binding.back.setVisibility(View.GONE);
                binding.Discover.setVisibility(View.GONE);
                binding.Feed.setVisibility(View.GONE);

                binding.forward.setVisibility(View.VISIBLE);
                binding.d2.setVisibility(View.VISIBLE);
                binding.f2.setVisibility(View.VISIBLE);
                binding.setting.setVisibility(View.VISIBLE);
            } else if (binding.viewpage.getCurrentItem() == 1) {
                binding.forward.setVisibility(View.GONE);
                binding.d2.setVisibility(View.GONE);
                binding.f2.setVisibility(View.GONE);
                binding.setting.setVisibility(View.GONE);

                binding.back.setVisibility(View.VISIBLE);
                binding.Discover.setVisibility(View.VISIBLE);
                binding.Feed.setVisibility(View.VISIBLE);
            }

            delayhandler.postDelayed(this, 1);
 }
};;

}