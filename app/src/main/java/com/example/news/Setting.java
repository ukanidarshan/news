package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.news.databinding.ActivitySettingBinding;

import java.util.ArrayList;

public class Setting extends AppCompatActivity {

    ActivitySettingBinding binding;

    ArrayList<String> name = new ArrayList<>();
    ArrayList<modal> img;
    SettingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);

        img = new ArrayList<modal>();
        img.add(new modal(R.drawable.account, "Account"));
        img.add(new modal(R.drawable.bell, "Notification"));
        img.add(new modal(R.drawable.eye, "Appearence"));
        img.add(new modal(R.drawable.lock, "Privacy and Security"));
        img.add(new modal(R.drawable.headphone, "Help and Support"));
        img.add(new modal(R.drawable.aboutus, "About"));

        adapter = new SettingAdapter(img);
        binding.recset.setAdapter(adapter);

        binding.searchview.clearFocus();

        // below line is to call set on query text listener method.
        binding.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<modal> filteredlist = new ArrayList<modal>();

        // running a for loop to compare elements.
        for (modal item : img) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }
}