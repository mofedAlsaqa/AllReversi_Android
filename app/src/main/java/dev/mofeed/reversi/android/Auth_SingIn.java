package dev.mofeed.reversi.android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dev.mofeed.reversi.android.databinding.ActivityAuthSingInBinding;
import io.github.muddz.styleabletoast.StyleableToast;


public class Auth_SingIn extends AppCompatActivity {
    ActivityAuthSingInBinding binding;
    String singInEmailEt, signInPasswordEt;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode()==1&&result.getData()!=null)
                    {
                        Intent intent=result.getData();
                        signInPasswordEt=intent.getStringExtra("password");
                        binding.singInEmailEt.setText(singInEmailEt,null);
                        binding.singInEmailEt.setText(signInPasswordEt,null);


                    }


                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthSingInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.singInBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singInEmailEt = binding.singInEmailEt.getText().toString();
                signInPasswordEt = binding.singInPasswordEt.getText().toString();
                if (getIntent().getStringExtra("email").equals(singInEmailEt) && getIntent().getStringExtra("password").equals(signInPasswordEt)) {
                    StyleableToast.makeText(Auth_SingIn.this, "Log In Success", R.style.myToast).show();
                } else {
                    StyleableToast.makeText(Auth_SingIn.this, "Log In Success", R.style.myToast).show();
                }
            }
        });

        binding.forgetPSDTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Auth_RestPassword.class);
                intent.putExtra("singInEmailEt",singInEmailEt);
                launcher.launch(intent);


            }
        });


    }
}