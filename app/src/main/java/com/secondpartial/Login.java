package com.secondpartial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    // Variables para obtener datos del login
    Button btn_login;
    EditText edt_user, edt_pass;

    // Variables para manejar caché
    String user;

    public static final String loginDataCache = "loginData";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        
        validateLogin();

        sharedPreferences = getSharedPreferences(loginDataCache, modo_private);
        editor = sharedPreferences.edit();

        btn_login = findViewById(R.id.btn_login);
        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_user.getText().toString();
                String pass = edt_pass.getText().toString();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(Login.this, "You must complete all fields", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("user", user);
                    editor.commit();

                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void validateLogin() {
        user = getApplicationContext().getSharedPreferences(loginDataCache, modo_private).getString("user", null);
        if (user != null) {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
        }
    }
}