package dev.mofeed.reversi.android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import dev.mofeed.reversi.android.databinding.ActivityMenusBinding;

public class Menus_Activity extends AppCompatActivity {
    ActivityMenusBinding binding;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 101 && result.getData() != null) {
                        String nameTeacher = result.getData().getStringExtra("nameTeacher");
                        int idTeacher = result.getData().getIntExtra("idTeacher", 120220000);
                        int ageTeacher = result.getData().getIntExtra("ageTeacher", 0);
                        binding.myShowTv.append(nameTeacher + "\n" + idTeacher + "\n" + ageTeacher);


                    } else if (result.getResultCode() == 102 && result.getData() != null) {
                        String nameStudent = result.getData().getStringExtra("nameStudent");
                        int idStudent = result.getData().getIntExtra("idStudent", 120220000);
                        int ageStudent = result.getData().getIntExtra("ageStudent", 0);
                        binding.myShowTv.append(nameStudent + "\n" + idStudent + "\n" + ageStudent);
                    } else
                        Toast.makeText(Menus_Activity.this, "Data Field!!", Toast.LENGTH_SHORT).show();


                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //inflate context menu
        registerForContextMenu(binding.myShowTv);
    }

    //Option Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    //Option Menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.first_Item) {
            Intent intent = new Intent(getBaseContext(), ARL_Teacher_Activity.class);
            launcher.launch(intent);

            return true;

        } else if (item.getItemId() == R.id.second_Item) {
            Intent intent = new Intent(getBaseContext(), ARL_Student_Activity.class);
            launcher.launch(intent);
        }
        return true;
    }

    //Context Menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }
    //Context Menu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Black_Color:
                binding.myShowTv.setTextColor(Color.BLACK);
                return true;
            case R.id.Red_Color:
                binding.myShowTv.setTextColor(Color.RED);
                return true;
            case R.id.Green_Color:
                binding.myShowTv.setTextColor(Color.GREEN);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
