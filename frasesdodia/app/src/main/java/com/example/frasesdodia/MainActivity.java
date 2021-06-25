package com.example.frasesdodia;

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
    public void newFrases(View v)  {  //pode-se usar (View v) ou (View view)
        String[] frases = {
            "Bom dia dona Elenildes, já leu a biblia",
            "Oi senhor Leo, tenha um ótimo dia",
            "Sabe toda aquela energia boa que temos dentro de nós e que não sabemos onde ou como canalizar? Em um trabalho voluntário ela é muito bem-vinda, pois ali cria-se amor e passamos a dar o nosso sentimento por uma razão que vai além de nossos interesses. ",
            "Para muitos, viver em função de trabalho voluntário é loucura, pois acham que muitas vezes não dá para realizar algumas coisas, mas, acreditem: sempre dá.",
            "O trabalho voluntário só cobra uma coisa: amor! De resto, não há mais nada que seja exigido, afinal, tudo se busca e se alcança pelo próximo. ",
            "Toda a boa ação vale a pena! Fazer trabalho voluntário pensando apenas nisso é um ótimo motivo para nos mexermos já. ",
            "Technology (\"science of craft\", from Greek τέχνη, techne, \"art, skill, cunning of hand\"; and -λογία, -logia) is the sum of techniques, skills, methods, and processes used in the production of goods or services or in the accomplishment of objectives, such as scientific investigation.",
            "Technology is the sum of techniques, skills, methods, and processes used in the production of goods or services or in the accomplishment of objectives, such as scientific investigation.",
            "Mesmo vindo de centenas de grupos étnicos e falando centenas de idiomas, somos unidos pelos mesmos objetivos. Acima de tudo, queremos honrar a Jeová.",
            "Fazemos o nosso melhor para imitar a Jesus Cristo e temos orgulho de ser chamados cristãos.",
            "90% of the world’s data has been created in just the past few years. Faced with overwhelming amounts of data, organizations are struggling to extract the powerful insights they need to make smarter business decisions.",
            "Introduce innovaciones en urbanismo, construcción e ingeniería, pero sus críticos denuncian que la tecnológica quiere dirigir una ciudad sin pasar por las urnas y los residentes recelan del sistema que vigilará sus movimientos para mejorar los servicios",
            "O conjunto de notas que uma tonalidade gera, através do princípio da sobreposição de terças,é denominado campo harmônico da tonalidade o conjunto de acordes.",
            "Cinema (do em grego: κίνημα, kinema \"movimentos\" e γράφειν, graphein \"registrar\"), também chamada sétima arte, ou, em certos contextos cinematografia, pode ser definida como a técnica e a arte de fixar e de reproduzir imagens que suscitam impressão de movimento, assim como a indústria que produz estas imagens. ",
        };
        int numero = new Random().nextInt(14);
        TextView fraseando = findViewById(R.id.fraseando);
        fraseando.setText( frases[numero] );

    }
}
