package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import static com.example.pedrapapeltesoura.R.drawable.papel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
       this.opcaoSelecionada("Pedra" );
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel" );
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura" );
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imageCPU = findViewById(R.id.imageCPU);
        TextView Result = findViewById(R.id.Reult);
        int numero = new Random().nextInt(3);//quantidade de valores gerados (n)
        /*ponha somente o numero entre os parenteses
          que está escrito "(bound: n)" o compilador
          preenche o resto, pois estava dando erro quando eu preenchi! */
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];
        switch(opcaoApp) {
                case "Pedra":
                imageCPU.setImageResource(R.drawable.pedra);
                break;
                case "Papel":
                imageCPU.setImageResource(R.drawable.papel);
                break;
                case "Tesoura":
                imageCPU.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel")||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra")||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")
        ){
                 Result.setText("você perdeu :(");
        }
        else if(
                (opcaoSelecionada  == "Tesoura" && opcaoApp == "Papel")||
                (opcaoSelecionada == "Papel" &&  opcaoApp  == "Pedra")||
                (opcaoSelecionada == "Pedra" && opcaoApp  == "Tesoura")
        ){
                Result.setText("você venceu :)");
        }
        else{
            Result.setText("Empatamos ^____^ ");
        }

        System.out.println("item clicado:" + opcaoApp);
    }
}
