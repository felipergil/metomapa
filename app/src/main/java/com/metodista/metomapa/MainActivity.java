package com.metodista.metomapa;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private MetoMapaDB db;
    private String usuario_logado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apresentarMensagem("- Pressione as letras para ver a história dos edifícios.\n- Mantenha pressionado as letras para criar um evento.");

        ImageButton btn_cadastro = (ImageButton) findViewById(R.id.btn_cadastro);
        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novo_cadastro();
            }
        });

        db = new MetoMapaDB(this);
        usuario_logado = db.consultar();

        TextView txt_logado = (TextView) findViewById(R.id.txt_usuario);
        TextView txt_ola = (TextView) findViewById(R.id.txt_ola);
        TextView txt_cadastro = (TextView) findViewById(R.id.txt_cadastro);
        if (usuario_logado != null){
            txt_ola.setText("Olá " + usuario_logado + ",");
            txt_logado.setText("Pressione ou segure pressionado as letras para interagir");
            btn_cadastro.setVisibility(View.GONE);
            txt_cadastro.setVisibility(View.GONE);
        }else{
            txt_ola.setText("Olá Visitante,");
            txt_logado.setText("Faça o cadastro para poder criar eventos");
        }

        final String msg = "Você precisa estar logado para criar eventos.\nPor favor, cadastre-se.";

        /* Edifício Capa */
        Button btn_capa = (Button) findViewById(R.id.btn_capa);
        btn_capa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("capa");
            }
        });
        btn_capa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("capa");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });


        /* Edifício Delta */
        Button btn_delta = (Button) findViewById(R.id.btn_delta);
        btn_delta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("delta");
            }
        });
        btn_delta.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("delta");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Alfa */
        Button btn_alfa = (Button) findViewById(R.id.btn_alfa);
        btn_alfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("alfa");
            }
        });
        btn_alfa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("alfa");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Gama */
        Button btn_gama = (Button) findViewById(R.id.btn_gama);
        btn_gama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("gama");
            }
        });
        btn_gama.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("gama");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Zeta */
        Button btn_zeta = (Button) findViewById(R.id.btn_zeta);
        btn_zeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("zeta");
            }
        });
        btn_zeta.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("zeta");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Omicron */
        Button btn_omicron = (Button) findViewById(R.id.btn_omicron);
        btn_omicron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("omicron");
            }
        });
        btn_omicron.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("omicron");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Lambda */
        Button btn_lambda = (Button) findViewById(R.id.btn_lambda);
        btn_lambda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("lambda");
            }
        });
        btn_lambda.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("lambda");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício PSI */
        Button btn_psi = (Button) findViewById(R.id.btn_psi);
        btn_psi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("psi");
            }
        });
        btn_psi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("psi");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício CC */
        Button btn_cc = (Button) findViewById(R.id.btn_cc);
        btn_cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("cc");
            }
        });
        btn_cc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("cc");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Iota */
        Button btn_iota = (Button) findViewById(R.id.btn_iota);
        btn_iota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("iota");
            }
        });
        btn_iota.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("iota");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });

        /* Edifício Teta */
        Button btn_teta = (Button) findViewById(R.id.btn_teta);
        btn_teta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ver_historia("teta");
            }
        });
        btn_teta.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (usuario_logado != null){
                    criar_evento("teta");
                }else{
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });


    }

    /* Ir para tela de cadastro */
    public void novo_cadastro(){
        Intent intent_evento = new Intent(this, CadastroActivity.class);
        startActivityForResult(intent_evento, 1);
    }

    /* Ir para página da história do edifício */
    public void ver_historia(String edificio){
        Intent intent_historia = new Intent(this, HistoriaActivity.class);
        Bundle dados = new Bundle();
        dados.putString("edificio", edificio);
        intent_historia.putExtras(dados);
        startActivity(intent_historia);
    }


    /* Ir para página de criar evento no edifício */
    public void criar_evento(String edificio){
        Intent intent_evento = new Intent(this, EventoActivity.class);
        Bundle dados = new Bundle();
        dados.putString("edificio", edificio);
        intent_evento.putExtras(dados);
        startActivityForResult(intent_evento, 2);
    }

    /* Retorno */
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    usuario_logado = db.consultar();
                    TextView txt_ola = (TextView) findViewById(R.id.txt_ola);
                    TextView txt_logado = (TextView) findViewById(R.id.txt_usuario);

                    if (usuario_logado != null){
                        txt_ola.setText("Olá " + usuario_logado + ",");
                        txt_logado.setText("Pressione ou segure pressionado as letras para interagir");
                        TextView txt_cadastro = (TextView) findViewById(R.id.txt_cadastro);
                        ImageButton btn_cadastro = (ImageButton) findViewById(R.id.btn_cadastro);
                        txt_cadastro.setVisibility(View.GONE);
                        btn_cadastro.setVisibility(View.GONE);
                    }
                    String resultado = data.getStringExtra("resultado");
                    Toast toast = Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG);
                    toast.show();
                }
                if(resultCode == RESULT_CANCELED){
                    //erro
                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    String resultado = data.getStringExtra("resultado");
                    Toast toast = Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG);
                    toast.show();
                }
                if(resultCode == RESULT_CANCELED){
                    //erro
                }
                break;
        }

    }

    private void apresentarMensagem(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("MetoMapa - Instruções");
        builder.setMessage(msg)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Bem Vindo", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
