package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.news.databinding.AddsliderBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class AdAdapter extends SliderViewAdapter<AdAdapter.SliderAdapterViewHolder> {
    private ArrayList<Integer> imglist;

    public AdAdapter(ArrayList<Integer> imglist) {

        this.imglist = imglist;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addslider, null);
        return new SliderAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
        viewHolder.setData(position);
    }

    @Override
    public int getCount() {
        return imglist.size();
    }

    public class SliderAdapterViewHolder extends ViewHolder {
        AddsliderBinding binding;
        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            binding = AddsliderBinding.bind(itemView);
        }

        public void setData(int position) {
            Glide.with(itemView)
                    .load(imglist.get(position))
                    .fitCenter()
                    .into(binding.imgadd);
        }
    }
}
