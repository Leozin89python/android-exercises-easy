package com.example.newexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrodePessoa(View view) {
        TextView cadastro = (TextView) findViewById(R.id.aceiteOtexto);
        cadastro.setText("concluido");
    }
}
