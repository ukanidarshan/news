package com.example.news;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.news.databinding.ActivityNewsscrollerBinding;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    Context context;
    private ArrayList<Integer> listI;
    private ArrayList<String> list;
    private ArrayList<String> listt;
    private ArrayList<String> linklist;

    public AdapterClass(ArrayList<Integer> listI, ArrayList<String> list, ArrayList<String> listt, ArrayList<String> linklist) {

        this.listI = listI;
        this.list = list;
        this.listt = listt;
        this.linklist = linklist;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_newsscroller, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {

            holder.binding.image.setImageResource(listI.get(position));
            holder.binding.tvtitle.setText(listt.get(position));
            holder.binding.tvnews.setText(list.get(position));


            Glide.with(context)
                    .load(listI.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3)))
                    .into(holder.binding.imgblur);
        Glide.with(context)
                .load(listI.get(position))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3)))
                .into(holder.binding.ivwebblur);

        holder.binding.tvlink.setText(linklist.get(position));
        Linkify.addLinks(holder.binding.tvlink, Linkify.WEB_URLS);

    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ActivityNewsscrollerBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ActivityNewsscrollerBinding.bind(itemView);


        }

    }



}
