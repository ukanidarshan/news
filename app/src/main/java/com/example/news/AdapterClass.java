package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.news.databinding.ActivityNewsscrollerBinding;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder>{

    Context context;
    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_newsscroller,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ActivityNewsscrollerBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ActivityNewsscrollerBinding.bind(itemView);

            Glide.with(context)
                    .load(R.drawable.newslogo)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3)))
                    .into(binding.imgblur);
        }
    }
}
