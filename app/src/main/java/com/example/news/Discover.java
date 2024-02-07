package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.databinding.FragmentDiscoverBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Discover extends Fragment {

    FragmentDiscoverBinding binding;

    ArrayList<Integer> imglist = new ArrayList<>();
    ArrayList<Integer> catimg = new ArrayList<>();
    ArrayList<String> catname = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_discover,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.slider.startAutoCycle();
        catimg.add(R.drawable.google);
        catimg.add(R.drawable.facebook);
        catimg.add(R.drawable.twitter);

        catname.add("google");
        catname.add("facebook");
        catname.add("twitter");

        CustomAdapter customAdapter = new CustomAdapter(catimg,catname);
        binding.rcvd.setAdapter(customAdapter);

        imglist.add(R.drawable.new2);
        imglist.add(R.drawable.news11);
        imglist.add(R.drawable.news);

        AdAdapter adapter = new AdAdapter(imglist);

        binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        binding.slider.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        binding.slider.setScrollTimeInSec(1);

        // to set it scrollable automatically
        // we use below method.
        binding.slider.setAutoCycle(true);

        // to start autocycle below method is used.



    }
}