package dev.mofeed.reversi.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.mofeed.reversi.android.databinding.ActivityListViewBinding;

public class list_View extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityListViewBinding binding;
    ArrayAdapter<String> adapter;
    ArrayList<String> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        products = new ArrayList<>();
        adapter = new ArrayAdapter<String>(list_View.this, android.R.layout.simple_dropdown_item_1line, products);
        binding.listView.setAdapter(adapter);
//        products.add(input.next());
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");
//        products.add("Milk");


        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameProduct = binding.nameEt.getText().toString();
                products.add(nameProduct);
                adapter.notifyDataSetChanged();
            }
        });

//      binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//          @Override
//          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              new AlertDialog.Builder(list_View.this)
//                      .setTitle("Are you sure remove: "+products.get(position))
//                      .setMessage("That Remove City in Spinner!!")
//                      .setIcon(R.drawable.hide_eyes)
//                      .setPositiveButton("Yes I'm Sure ", new DialogInterface.OnClickListener() {
//                          @Override
//                          public void onClick(DialogInterface dialog, int which) {
//                              products.remove(position);
//                              adapter.notifyDataSetChanged();
//                          }
//                      }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                          @Override
//                          public void onClick(DialogInterface dialog, int which) {
//                              Toast.makeText(list_View.this, "Ok!", Toast.LENGTH_SHORT).show();
//                          }
//                      }).setCancelable(true)
//                      .show();
//          }
//      });

        binding.listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        new AlertDialog.Builder(list_View.this)
                .setTitle("Are you sure remove: " + products.get(position))
                .setMessage("That Remove City in Spinner!!")
                .setIcon(R.drawable.hide_eyes)
                .setPositiveButton("Yes I'm Sure ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        products.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(list_View.this, "Ok!", Toast.LENGTH_SHORT).show();
                    }
                }).setCancelable(true)
                .show();
    }
}