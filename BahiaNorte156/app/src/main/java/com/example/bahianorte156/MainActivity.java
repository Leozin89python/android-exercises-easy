package com.example.bahianorte156;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    public Button Login;
    public TextInputEditText Senha, Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.login);
        Senha = findViewById(R.id.senha);
        Email = findViewById(R.id.email);
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent logando = new Intent(getApplicationContext(), Loja.class);
                startActivity(logando);
            }
        });
    }

}
