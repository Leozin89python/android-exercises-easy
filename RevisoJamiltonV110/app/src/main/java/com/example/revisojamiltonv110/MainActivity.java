package com.example.revisojamiltonv110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            }

    public void BahiaNorteProdutos(View view) {
            this.BahiaNorteProduct();

            }
    public void BahiaNorteQuantidades(View view) {
            this.BahiaNorteQuantity();

            }
    public void BahiaNorteQuantity() {

        int quantity = new Random().nextInt(9);
        TextView compras = findViewById(R.id.quantidade);
        compras.setText(String.valueOf(quantity));
        }
        public void BahiaNorteProduct() {
            int product = new Random().nextInt(4);
            String[] estoque = {"Nescau", "Ades", "Maratá", "Ades Chocolate"};
            String comprado = estoque[product];

            ImageView comprados = findViewById(R.id.produto);
            //System.out.println(estoque[product]);//funciona só não muda por ser do tipo image e o chamado é um vetor de String

            switch (comprado) {
                case "Nescau":
                    comprados.setImageResource(R.drawable.nescau);
                    break;
                case "Ades Chocolate":
                    comprados.setImageResource(R.drawable.ades);
                    break;
                case "maratá":
                    comprados.setImageResource(R.drawable.marata);
                    break;
                case "Ades":
                    comprados.setImageResource(R.drawable.images);
                    break;
            }
        }
}
//neste exercicio fiz dus funções uma para cada execução pois uma só interferia bas duas execuções e gereva um BUG!