package dev.mofeed.reversi.android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dev.mofeed.reversi.android.databinding.ActivityArlMovedIntentBinding;
import io.github.muddz.styleabletoast.StyleableToast;

public class ARL_moved_Intent extends AppCompatActivity {
    ActivityArlMovedIntentBinding binding;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //get Data Intent.
                    Intent intent = result.getData();
                    if (result != null) {
                        if (result.getResultCode() == 101) {
                            String nameTeacher = intent.getStringExtra("nameTeacher");
                            int idTeacher = intent.getIntExtra("idTeacher", 120220000);
                            int ageTeacher = intent.getIntExtra("ageTeacher", 0);
                            binding.myTv.setText("Teacher Name: " + nameTeacher + "\n" + "Teacher id: " + "\n" + idTeacher + "Teacher age: " + "\n" + ageTeacher);
                        } else if (result.getResultCode() == 102) {

                            String nameStudent = intent.getStringExtra("nameStudent");
                            int idStudent = intent.getIntExtra("idStudnet", 120220000);
                            int ageStudent = intent.getIntExtra("ageStudent", 0);
                            binding.myTv.setText("Student name: " + nameStudent + "\n" + "Student id: " + "\n" + idStudent + "Student age: " + "\n" + ageStudent);
                        }
                    } else {
                        Toast.makeText(ARL_moved_Intent.this, "Not!! : the write wel be must all data", Toast.LENGTH_SHORT).show();
                    }


                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArlMovedIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.moveTeacherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ARL_Teacher_Activity.class);
                launcher.launch(intent);
            }
        });

        binding.moveStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ARL_Student_Activity.class);
                launcher.launch(intent);

            }
        });

        binding.myTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    binding.myTv.setTextColor(Color.RED);
                    StyleableToast.makeText(getBaseContext(), "change color Successfully🎉", R.style.myToast).show();


                } catch (IllegalArgumentException e) {
                    System.out.println("Color Not Found");
                }

            }
        });


    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}