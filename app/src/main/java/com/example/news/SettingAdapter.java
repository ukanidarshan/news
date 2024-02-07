package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.databinding.SettingitemBinding;

import java.util.ArrayList;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder> {

    ArrayList<modal> img = new ArrayList<>();

    Context context;

    public SettingAdapter(ArrayList<modal> img) {
this.img = img;
    }
    public void filterList(ArrayList<modal> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        this.img = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SettingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settingitem,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.ViewHolder holder, int position) {

        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return img.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SettingitemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SettingitemBinding.bind(itemView);

        }

        public void setData(int position) {

            modal md = img.get(position);
            binding.imgv.setImageResource(md.getImg());
            binding.tvv.setText(md.getName());

            binding.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position==0){
                        context.startActivity(new Intent(context,Account.class));
                    }
                }
            });

        }
    }
}
