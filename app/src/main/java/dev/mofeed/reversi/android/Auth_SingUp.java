package dev.mofeed.reversi.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import java.io.NotActiveException;

import dev.mofeed.reversi.android.databinding.ActivityAuthSingUpBinding;

public class Auth_SingUp extends AppCompatActivity {
    ActivityAuthSingUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthSingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.singUpBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String email = binding.emailEt.getText().toString();
                    int phone = Integer.parseInt(binding.phoneNumberEt.getText().toString());
                    String password = binding.passwordEt.getText().toString();
                    String confirm_Password = binding.confirmPasswordEt.getText().toString();
                    if (password.equals(confirm_Password)) {
                        Intent intent = new Intent(getBaseContext(), Auth_SingIn.class);
                        intent.putExtra("email", email);
                        intent.putExtra("phone", phone);
                        intent.putExtra("password", password);
                        intent.putExtra("confirm_Password", confirm_Password);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Auth_SingUp.this, "Data Not like this !!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    e.getMessage();
                } catch (Exception e) {
                    e.getMessage();
                } finally {
                    System.out.println("Finally!!");
                }
            }

        });
        /*
        * if (password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {

    //Show Password
    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
} else {
    //Hide Password
    password.setTransformationMethod(PasswordTransformationMethod.getInstance());

}*/
        binding.hidePasswordImg.setImageResource(R.drawable.ic_eyes_24);
        binding.hidePasswordImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.passwordEt.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    //If password is visible then Hide it
                    binding.passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.hidePasswordImg.setImageResource(R.drawable.ic_eyes_24);

                } else
                    binding.passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                 binding.hidePasswordImg.setImageResource(R.drawable.hide_eyes);
            }
        });


    }
}