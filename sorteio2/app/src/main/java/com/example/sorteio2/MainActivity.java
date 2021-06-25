package com.example.sorteio2;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void alterarTexto(view View){
        TextView texto = (TextView) findViewById(R.id.textoExibicao);
        texto.setText("insira um numero válido");



    }
}
