package dev.mofeed.reversi.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dev.mofeed.reversi.android.databinding.ActivityArlTeacherBinding;

public class ARL_Teacher_Activity extends AppCompatActivity {
    ActivityArlTeacherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArlTeacherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sendDataTeachBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameTeacher = binding.nameEt.getText().toString();
                    int idTeacher = Integer.parseInt(binding.idEt.getText().toString());
                    int ageTeacher = Integer.parseInt(binding.ageEt.getText().toString());
                    Intent intent = new Intent(getBaseContext(), ARL_moved_Intent.class);
                    intent.putExtra("nameTeacher", nameTeacher);
                    intent.putExtra("idTeacher", idTeacher);
                    intent.putExtra("ageTeacher", ageTeacher);
                    setResult(101, intent);
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(ARL_Teacher_Activity.this, "Not!!: the Write well be data", Toast.LENGTH_SHORT).show();
                    System.out.println("The Data Empty!!");
                }


            }
        });


    }
}