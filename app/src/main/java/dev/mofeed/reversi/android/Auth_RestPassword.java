package dev.mofeed.reversi.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import dev.mofeed.reversi.android.databinding.ActivityAuthRestPasswordBinding;
import io.github.muddz.styleabletoast.StyleableToast;

public class Auth_RestPassword extends AppCompatActivity {
    ActivityAuthRestPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthRestPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String email = getIntent().getStringExtra("singInEmailEt");

        binding.restPasswordBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String restEmailEt = binding.restEmailEt.getText().toString();
                String password = binding.restNewPasswordEt.getText().toString();

                if (restEmailEt.equals("")) {
                    Log.d("resetPasswordTesting", "onClick: 1"+email);
                    StyleableToast.makeText(Auth_RestPassword.this, "Log In Success", R.style.myToast).show();

                } else if (restEmailEt.equals(email)) {
                    Log.d("resetPasswordTesting", "onClick: 2"+email);

                    Intent intent = new Intent();
                    intent.putExtra("password", password);
                    setResult(101, intent);
                    finish();
                } else {
                    Log.d("resetPasswordTesting", "onClick: 3"+email);
                    StyleableToast.makeText(Auth_RestPassword.this, "Log In Success", R.style.myToast).show();
                }
            }
        });


    }
}