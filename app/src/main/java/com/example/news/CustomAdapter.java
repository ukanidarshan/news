package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.databinding.DiscoveritemBinding;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<Integer> catimg;
    ArrayList<String> catname;

    public CustomAdapter(ArrayList<Integer> catimg, ArrayList<String> catname) {
        this.catimg = catimg;
        this.catname = catname;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discoveritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.binding.ivCategory.setImageResource(catimg.get(position));
        holder.binding.tvCategory.setText(catname.get(position));

    }

    @Override
    public int getItemCount() {
        return catname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        DiscoveritemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DiscoveritemBinding.bind(itemView);
        }
    }
}
