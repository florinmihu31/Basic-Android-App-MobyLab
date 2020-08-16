package com.example.mobylabtema1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.example.mobylabtema1.Constants.IMAGE_WIDTH;
import static com.example.mobylabtema1.Constants.IMAGE_HEIGHT;

public class SecondDescendantActivity extends AppCompatActivity {

    private static final int SIZE = 10;
    private final List<String> mButtonList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ButtonTextAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_descendant);

        ImageView imageView = findViewById(R.id.image_view);
        Glide.with(this)
                .load(R.drawable.happy_turtle)
                .override(IMAGE_WIDTH, IMAGE_HEIGHT)
                .into(imageView);

        for (int i = 0; i < SIZE; i++) {
            mButtonList.add(Integer.toString(i + 1));
        }

        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new ButtonTextAdapter(this, mButtonList);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void startFirstDescendantActivity(View view) {
        Intent firstDescendantIntent = new Intent(this, FirstDescendantActivity.class);
        startActivity(firstDescendantIntent);
    }
}