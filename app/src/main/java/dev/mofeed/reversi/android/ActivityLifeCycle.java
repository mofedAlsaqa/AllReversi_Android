package dev.mofeed.reversi.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import dev.mofeed.reversi.android.databinding.ActivityLifeCycleBinding;

public class ActivityLifeCycle extends AppCompatActivity {
    String TAG = "LifeCycle";


    ActivityLifeCycleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLifeCycleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameEt.getText().toString();
                binding.myTv.setText(name);
            }
        });

        binding.hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.myTv.getVisibility() == View.VISIBLE)
                    binding.myTv.setVisibility(View.INVISIBLE);
                else
                    binding.myTv.setVisibility(View.VISIBLE);
            }
        });

        binding.myTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.myTv.setTextColor(Color.RED);
            }
        });
        Intent intent = getIntent();
        String nameEt = intent.getStringExtra("nameEt");
        int ageEt = intent.getIntExtra("ageEt", 0);
        String spinner = intent.getStringExtra("spinner");
        String six = intent.getStringExtra("sixRB");
        String status = intent.getStringExtra("status");
        binding.myTv.setText(nameEt+ageEt+spinner+six+status);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        binding.myTv.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        binding.myTv.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        binding.myTv.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        binding.myTv.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        binding.myTv.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nameEt", binding.nameEt.getText().toString());
        outState.putString("Text_ViewColor", "#ff0000");


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("nameEt", "null");
        String color = savedInstanceState.getString("Text_ViewColor");
        binding.myTv.setText(name);
        binding.myTv.setTextColor(Color.parseColor(color));
    }


}