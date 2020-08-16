package com.example.mobylabtema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstDescendantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_descendant);
    }

    public void startSecondDescendantActivity(View view) {
        Intent secondDescendantIntent = new Intent(this, SecondDescendantActivity.class);
        startActivity(secondDescendantIntent);
    }
}