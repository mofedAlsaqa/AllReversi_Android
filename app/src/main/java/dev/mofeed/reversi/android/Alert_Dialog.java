package dev.mofeed.reversi.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import dev.mofeed.reversi.android.databinding.ActivityAlertDialogBinding;
import io.github.muddz.styleabletoast.StyleableToast;

public class Alert_Dialog extends AppCompatActivity {
    ActivityAlertDialogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlertDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.buttonAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick: ");


                AlertDialog.Builder dialog=new AlertDialog.Builder(Alert_Dialog.this);

                dialog.setTitle("Welcome to Alert Dialog ");
                dialog.setMessage("Alert Dialog with Activity");
                dialog.setIcon(R.drawable.ic_star_24);
                dialog.setPositiveButton("hello Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StyleableToast.makeText(Alert_Dialog.this, "Hello", R.style.myToast).show();
                            }
                        });
                dialog.setNegativeButton("hello", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StyleableToast.makeText(Alert_Dialog.this, "Hello", R.style.myToast).show();
                    }
                });
                dialog.show();


            }
        });


            }




    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(Alert_Dialog.this)
                .setTitle("Exit Activity")
                .setMessage("Are you exit the activity")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setCancelable(false)
                .show();
    }
}