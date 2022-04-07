package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.axat.starbarn.R;
import com.axat.starbarn.adapter.SearchAdapter;
import com.axat.starbarn.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;
    SearchAdapter recyclerAdapter;

    List<String> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_search);
//        setContentView(R.layout.activity_search);



        moviesList = new ArrayList<>();
        moviesList.add("Basketball");
        moviesList.add("Basketball");
        moviesList.add("Basketball");


        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recycler.setLayoutManager(mLayoutManager);
        recyclerAdapter = new SearchAdapter(moviesList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(recyclerAdapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}