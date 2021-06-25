package com.example.newexercise;

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
    public void eLemento(View view){
        TextView mercadoria = (TextView) findViewById(R.id.novoProduto);
        double y = new Random().nextDouble();
        mercadoria.setText("codigo:" + y);

    }
}
