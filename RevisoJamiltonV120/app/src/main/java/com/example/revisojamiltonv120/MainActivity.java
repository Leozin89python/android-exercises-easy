package com.example.revisojamiltonv120;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void product(View view){ //este metodo que vai para o onclick
        this.varejo();
    }

    public void varejo (){  //este metodo vai para o parametro product
        TextView preco = findViewById(R.id.price);
        ImageView estoque = findViewById(R.id.product);
        int fornecedor = new Random().nextInt(4);
        String [] mercadoria = {"Nescau", "Ades", "Maratá", "Ades Chocolate"};
        String bahia = mercadoria[fornecedor];

       switch (bahia){
           case "Nescau":
                estoque.setImageResource(R.drawable.nescau);
                preco.setText("6,99 R$");
               break;
           case "Maratá":
               estoque.setImageResource(R.drawable.marata);
               preco.setText("3,98 R$");
               break;
           case "Ades Chocolate":
               estoque.setImageResource(R.drawable.ades);
               preco.setText("5,67 R$");
           case "Ades":
               estoque.setImageResource(R.drawable.images);
               preco.setText("4,97 R$");
               break;
       }

    }

}
