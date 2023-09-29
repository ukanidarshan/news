package com.example.news;

import static androidx.appcompat.graphics.drawable.DrawableContainerCompat.Api21Impl.getResources;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.databinding.ActivityNewsscrollerBinding;

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
            Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.newslogo);

            Glide.with(Recycler.this).load(R.drawable.newslogo)
                    .bitmapTransform(new MyBlurBuilder().applyBlur(context,srcBitmap,1.5))
                    .into(binding.imgblur(R.drawable.newslogo);
        }
    }
}
