package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText Palcool, Pgasolina;
    private TextView TextoFinalUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Palcool       = findViewById(R.id.Palcool);
        Pgasolina     = findViewById(R.id.Pgasolina);
        TextoFinalUser= findViewById(R.id.TextoFinalUser);
    }
    public void calcule(View view){
        //recuperar valores digitados
        String Alcool   = Palcool.getText().toString();
        String Gasolina = Pgasolina.getText().toString();
       //validar os campos digitados
        boolean dados = usuario(Alcool,Gasolina);

        if(dados){
        //converter String para numeros
            double valorAlcool   = Double.parseDouble(Alcool);
            double valorGasolina = Double.parseDouble(Gasolina);
            //calculando
            double Total         = valorAlcool/valorGasolina;
            if(Total >= 0.7){
                TextoFinalUser.setText("melhor usar gasolina.");
            }
            else{
                TextoFinalUser.setText("melhor usar alcool.");
            }
        }
        else {
            TextoFinalUser.setText("preencha os preços primeiro.");
        }
    }
    public boolean usuario(String Alcool, String Gasolina) {
        boolean dados = true;
        String campo = "preenchido.";
        if (Alcool == null || Alcool.equals("")) {
            dados = false;
            campo = "alcool.";
        } else if (Gasolina == null || Gasolina.equals("")) {
            dados = false;
            campo = "gasolina.";
        }
        return dados;
      }
    }
