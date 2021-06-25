package com.example.sorteio;

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

    public void mudancadeTexto(View view){
        TextView texto = (TextView) findViewById(R.id.novoTexto);
        texto.setText("cadastro confirmado");
        //bugou após mudanças
        //no design.. observar estes erros!
    }
}
