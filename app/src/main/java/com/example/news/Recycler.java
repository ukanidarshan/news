package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.news.databinding.ActivityRecyclerBinding;

public class Recycler extends AppCompatActivity {
    ActivityRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler);

        AdapterClass adapterClass = new AdapterClass();
        binding.rcv.setAdapter(adapterClass);

    }
}