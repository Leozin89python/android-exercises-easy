package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        private  EditText editvalor;
        private  TextView textPorcentagem;
        private  TextView textGorjeta;
        private  TextView textTotal;
        private  SeekBar  seekBarGorjeta;

        private double portcentagem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editvalor       = findViewById(R. id.editValor);
        textPorcentagem = findViewById(R. id.textPorcentagem);
        textGorjeta     = findViewById(R. id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);
        seekBarGorjeta  = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                portcentagem = progress;
                textPorcentagem.setText(Math.round(portcentagem) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void metodoCalcular(){

        String valorRecuperado = editvalor.getText().toString();
        if (valorRecuperado == null|| valorRecuperado.equals(" ") ){
            Toast.makeText(
                    getApplicationContext(),
                    text: "Escreva algo primeiro.",
                    Toast.LENGTH_LONG).Show();
        }else{
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta       = valorDigitado * (portcentagem/100);
            double total         = gorjeta + valorDigitado;
            //textGorjeta.setText("R$" + Math.round(gorjeta) ); elimina os excessos decimais
            textGorjeta.setText("R$" + gorjeta);
            textTotal.setText("R$" + total);
        }
    }
}
