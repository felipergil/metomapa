package com.metodista.metomapa;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventoActivity extends AppCompatActivity {

    private MetoMapaDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        db = new MetoMapaDB(this);
        String usuario_logado = db.consultar();
        TextView txt_autor = (TextView) findViewById(R.id.txt_autor);
        if (usuario_logado != null){
            txt_autor.setText(usuario_logado);
        }else{
            txt_autor.setText(" -- ");
        }

        Intent intent = getIntent();
        Bundle dados = intent.getExtras();
        String edificio = dados.getString("edificio");

        TextView txt_edificio = (TextView) findViewById(R.id.txt_edificio);
        txt_edificio.setText("EDIFÍCIO " + edificio.toString().toUpperCase());

        final EditText etxt_nome = (EditText) findViewById(R.id.etxt_nome);
        final EditText etxt_sala = (EditText) findViewById(R.id.etxt_sala);

        /* Mascara campo data */
        final EditText etxt_data = (EditText) findViewById(R.id.etxt_data);
        etxt_data.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String data = etxt_data.getText().toString();

                if (data.length() == 2){
                    etxt_data.append("/");
                }

                if (data.length() == 5){
                    etxt_data.append("/");
                }
            }
        });

        /* Mascara campo tempo */
        final EditText etxt_duracao = (EditText) findViewById(R.id.etxt_duracao);
        etxt_duracao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String hora = etxt_duracao.getText().toString();

                if (hora.length() == 2){
                    etxt_duracao.append(":");
                }
            }
        });

        Button btn_salvar_evento = (Button) findViewById(R.id.btn_salvar_evento);
        btn_salvar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etxt_nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo nome é obrigatório", Toast.LENGTH_SHORT).show();
                }else if (etxt_data.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo data é obrigatório", Toast.LENGTH_SHORT).show();
                }else if (etxt_duracao.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo duração é obrigatório", Toast.LENGTH_SHORT).show();
                }else if (etxt_sala.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo nº sala é obrigatório", Toast.LENGTH_SHORT).show();
                }else{

                    //Salvar dados do WS

                    Intent principal = new Intent();
                    principal.putExtra("resultado", "Evento criado com sucesso !!");
                    setResult(RESULT_OK, principal);
                    finish();
                }
            }
        });

    }

}
