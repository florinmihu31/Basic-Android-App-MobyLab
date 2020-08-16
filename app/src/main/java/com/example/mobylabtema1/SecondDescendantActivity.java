package com.example.mobylabtema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.example.mobylabtema1.Constants.IMAGE_WIDTH;
import static com.example.mobylabtema1.Constants.IMAGE_HEIGHT;

public class SecondDescendantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_descendant);

        ImageView imageView = findViewById(R.id.image_view);
        Glide.with(this)
                .load(R.drawable.happy_turtle)
                .override(IMAGE_WIDTH, IMAGE_HEIGHT)
                .into(imageView);
    }

    public void startFirstDescendantActivity(View view) {
        Intent firstDescendantIntent = new Intent(this, FirstDescendantActivity.class);
        startActivity(firstDescendantIntent);
    }
}