package dev.mofeed.reversi.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dev.mofeed.reversi.android.databinding.ActivityArlStudentBinding;

public class ARL_Student_Activity extends AppCompatActivity {

    ActivityArlStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArlStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sendDataStudBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameStudent = binding.nameEt.getText().toString();
                    int idStudent = Integer.parseInt(binding.idEt.getText().toString());
                    int ageStudent = Integer.parseInt(binding.ageEt.getText().toString());
                    Intent intent = new Intent(getBaseContext(), ARL_moved_Intent.class);
                    intent.putExtra("nameStudent", nameStudent);
                    intent.putExtra("idStudent", idStudent);
                    intent.putExtra("ageStudent", ageStudent);
                    setResult(102, intent);
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(ARL_Student_Activity.this, "Not!!: the Write well be data", Toast.LENGTH_SHORT).show();
                    System.out.println("The Data Empty!!");
                }


            }
        });

    }
}