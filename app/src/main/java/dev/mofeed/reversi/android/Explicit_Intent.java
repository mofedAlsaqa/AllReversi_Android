package dev.mofeed.reversi.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import dev.mofeed.reversi.android.databinding.ActivityExplicitIntentBinding;

public class Explicit_Intent extends AppCompatActivity {
    ActivityExplicitIntentBinding binding;
    public static final String TAG="Life Cycle";
    String status;
    String six;
    ArrayList<String>citySpinner;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExplicitIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.movedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name= binding.nameEt.getText().toString();
               int age=Integer.parseInt(binding.ageEt.getText().toString());
               String spinner=binding.spinnerOne.getSelectedItem().toString();
               if (binding.radioGroup.getCheckedRadioButtonId()==R.id.male_RButton)
               {
                   six="Male";
               }else if (binding.radioGroup.getCheckedRadioButtonId()==R.id.female_RButton)
               {
                   six="Female";
               }
               if (binding.marriedCB.isChecked())
               {
                   status="Married";
               }else
                   status="Single";

                Intent intent=new Intent(getBaseContext(),ActivityLifeCycle.class);
                intent.putExtra("nameEt",name);
                intent.putExtra("ageEt",age);
                intent.putExtra("spinner",spinner);
                intent.putExtra("sixRB",six);
                intent.putExtra("status",status);
                startActivity(intent);
            }
        });

        citySpinner=new ArrayList<>();
        adapter=new ArrayAdapter<>(Explicit_Intent.this, android.R.layout.simple_dropdown_item_1line,citySpinner);
        binding.spinnerOne.setAdapter(adapter);
      binding.addCityBt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String nameCity=binding.itemSpinnerEt.getText().toString();
              citySpinner.add(nameCity);
              adapter.notifyDataSetChanged();
          }
      });
     binding.spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             new AlertDialog.Builder(Explicit_Intent.this)
                     .setTitle("Are you sure remover")
                     .setMessage("That Remove City in Spinner!!")
                     .setIcon(R.drawable.hide_eyes)
                     .setPositiveButton("Yes I'm Sure ", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             citySpinner.remove(position);
                         }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             Toast.makeText(Explicit_Intent.this, "Ok!", Toast.LENGTH_SHORT).show();
                         }
                     }).setCancelable(true)
                     .show();

         }

         @Override
         public void onNothingSelected(AdapterView<?> parent) {

         }
     });





    }
}