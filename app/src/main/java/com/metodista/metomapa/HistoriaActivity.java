package com.metodista.metomapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HistoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        Intent intent = getIntent();
        Bundle dados = intent.getExtras();
        String edificio = dados.getString("edificio");

        TextView txt_titulo = (TextView) findViewById(R.id.txt_titulo);
        txt_titulo.setText("EDIFÍCIO " + edificio.toString().toUpperCase());

        TextView txt_historia = (TextView) findViewById(R.id.txt_historia);
        txt_historia.setMovementMethod(new ScrollingMovementMethod());

        ImageView img_historia = (ImageView) findViewById(R.id.img_historia);
        switch (edificio){
            case "CAPA":
                img_historia.setImageResource(R.drawable.historia_capa);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "DELTA":
                img_historia.setImageResource(R.drawable.historia_delta);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "ALFA":
                img_historia.setImageResource(R.drawable.historia_alfa);
                txt_historia.setText("Tombado como patrimônio histórico do município de São Bernardo do Campo. O primeiro prédio construído para abrigar a Faculdade de Teologia em 1942, tendo sido o primeiro edifício educacional do município para cursos superiores. Nele funciona o Centro Otília Chaves, o programa de Relações Eclesiásticas e Missionárias, o Centro de Estudos Wesleyanos (CEW), a Coordenação Pesquisa, a Coordenação dos Cursos de Especialização, a Coordenação de Cursos Livres, e a Área de Projetos Institucionais. No edifício Alfa também estão localizados o Arquivo Histórico da Igreja Metodista, o Museu do Metodismo e o Museu de Obras Raras.");
                break;
            case "GAMA":
                img_historia.setImageResource(R.drawable.historia_gama);
                txt_historia.setText("Prédio onde está localizada a administração central da Faculdade de Teologia: a reitoria, a diretoria administrativa, a coordenação da Área Comunicação e Relações Externas e a Secretaria de Eventos e Serviços. Neste espaço também está localizado o Salão de Leitura. As dependências da reitoria contêm objetos trazidos da antiga Chácara Flora, propriedade da Igreja Metodista na cidade de São Paulo (bairro Santo Amaro), construída no início do século XX com o apoio das mulheres metodistas dos Estados Unidos para funcionar como centro de formação para líderes leigas e diaconisas metodistas no Brasil (o Instituto Metodista). A propriedade, vendida pela Igreja Metodista, nas últimas décadas do século passado, havia se transformado na Sede Geral da Igreja Metodista, cenário de reuniões do Colégio Episcopal Metodista e de momentos históricos como a redação do Plano para Vida e Missão da Igreja Metodista.");
                break;
            case "ZETA":
                img_historia.setImageResource(R.drawable.historia_zeta);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "OMICRON":
                img_historia.setImageResource(R.drawable.historia_zeta);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "LAMBDA":
                img_historia.setImageResource(R.drawable.historia_lambda);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "PSI":
                img_historia.setImageResource(R.drawable.historia_psi);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "CC":
                img_historia.setImageResource(R.drawable.historia_cc);
                edificio="Centro de convivência";
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "IOTA":
                img_historia.setImageResource(R.drawable.historia_iota);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "TETA":
                img_historia.setImageResource(R.drawable.historia_teta);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "NI":
                img_historia.setImageResource(R.drawable.historia_ni);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "SIGMA":
                img_historia.setImageResource(R.drawable.historia_sigma);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "EPSILON":
                img_historia.setImageResource(R.drawable.historia_epsilon);
                txt_historia.setText("História do edifício " + edificio);
                break;
            case "RO":
                img_historia.setImageResource(R.drawable.historia_ro);
                txt_historia.setText("História do edifício " + edificio);
                break;
        }

    }
}
