package com.example.revisojamiltonv121;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Loja extends AppCompatActivity {

    private Button saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);

        saida = findViewById(R.id.sair);

        saida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finalizar = new Intent(getApplicationContext(),MainActivity.class);
                finish();
            }
        });
    }



    public void product(View view){ //este metodo que vai para o onclick
        this.varejo();
    }

    public void varejo (){  //este metodo vai para o parametro product
        TextView venda = findViewById(R.id.preco);
        TextView descricao = findViewById(R.id.produto);
        ImageView estoque = findViewById(R.id.compra);
        int fornecedor = new Random().nextInt(14);
        String [] mercadoria = {"Nescau", "Ades", "Maratá", "Ades Chocolate","itambé","betania","damare","nissin","qboa","queijo","requeijão","manteiga","yougurte","leite betania"};
        String bahia = mercadoria[fornecedor];

        switch (bahia){
            case "Nescau":
                estoque.setImageResource(R.drawable.nescau);
                descricao.setText("Achocolatado Nescau 200ML");
                venda.setText("6.56 R$");
                break;
            case "Maratá":
                estoque.setImageResource(R.drawable.marata);
                descricao.setText("Nectar Maratá 200ML"); 		//inseri agora
                venda.setText("3.98 R$");
                break;
            case "Ades Chocolate":
                estoque.setImageResource(R.drawable.ades);
                descricao.setText("Nectar com soja Ades 200ML");
                venda.setText("5.67 R$");
            case "Ades":
                estoque.setImageResource(R.drawable.images);
                descricao.setText("Nectar Maratá 200ML");
                venda.setText("4.97 R$");
                break;
            case "itambé":
                estoque.setImageResource(R.drawable.itambe);
                descricao.setText("Leite Liquido Itambé 1L");
                venda.setText("4.99 R$");
                break;
            case "betania":
                estoque.setImageResource(R.drawable.cremedeleite);
                descricao.setText("Creme de Leite Betânia 250ML");
                venda.setText("2.15 R$");
                break;
            case "damare":
                estoque.setImageResource(R.drawable.leiteliquido);
                descricao.setText(" Leite liquido Damare 1L");
                venda.setText("4.25 R$");
                break;
            case "nissin":
                estoque.setImageResource(R.drawable.nissin);
                descricao.setText("Macarrão Instantaneo Nissin");
                venda.setText("1.23 R$");
                break;
            case "qboa":
                estoque.setImageResource(R.drawable.qboa);
                descricao.setText("Àgua Sanitária Qboa 1L");
                venda.setText("2.18 R$");
                break;
            case "queijo":
                estoque.setImageResource(R.drawable.queijo);
                descricao.setText("Queijo Veneza");
                venda.setText("14.97 R$");
                break;
            case "requeijão":
                estoque.setImageResource(R.drawable.requeijao);
                descricao.setText("Requeijão Cremoso Betânia 250ML");
                venda.setText("5.25 R$");
                break;
            case "manteiga":
                estoque.setImageResource(R.drawable.veneza);
                descricao.setText("Manteiga Pote Veneza 500ML");
                venda.setText("17.98 R$");
                break;
            case "yougurte":
                estoque.setImageResource(R.drawable.yougurte);
                descricao.setText("Yougurte Veneza 250Ml");
                venda.setText("1.09 R$");
                break;
            case "leite betania":
                estoque.setImageResource(R.drawable.leite);
                descricao.setText("Leite Liquído Betânia 1L");
                venda.setText("3.95 R$");
                break;

        }

    }


}
