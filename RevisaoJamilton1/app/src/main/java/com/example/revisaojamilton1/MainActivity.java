package com.example.revisaojamilton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

        public void produto(View view){
            TextView adicionando = findViewById(R.id.Add);

                /*int n = 10;

                for(int i = 0; i < n; i++){
                adicionando.setText(String.valueOf(i));   este é um conversor de int para String
                System.out.println(i);
                        }
                */
                int n = new Random().nextInt(10);
                adicionando.setText(String.valueOf(n));   //este é um conversor de int para String
                //tive erro com tipos e resolvi mudar o tipo para ser exibido e
                // ai pesquisei sobre conversão de tipos ai consegui resolver!
                //27/04/2020
    }
}
