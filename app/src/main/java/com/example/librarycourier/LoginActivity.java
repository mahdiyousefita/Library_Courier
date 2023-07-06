package com.example.librarycourier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    private TextInputLayout etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewBind();

        btnLogin.setOnClickListener(view -> {

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

            if (Objects.requireNonNull(etUserName.getEditText()).getText().length() > 0 &&
                    Objects.requireNonNull(etPassword.getEditText()).getText().length() > 0){

                Toast.makeText(this, "Hi " +
                        Objects.requireNonNull(etUserName.getEditText()).getText().toString(),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void viewBind(){

        btnLogin = findViewById(R.id.btn_login);
        etUserName = findViewById(R.id.ti_userName);
        etPassword = findViewById(R.id.ti_password);

    }
}