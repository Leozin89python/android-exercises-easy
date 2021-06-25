package com.example.revisojamiltonv121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     logar = findViewById(R.id.entrar);

     logar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             Intent mercado = new Intent(getApplicationContext(),Loja.class);
             startActivity(mercado);
         }
     });
    }
}
