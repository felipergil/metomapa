package com.metodista.metomapa;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.ParseException;


public class EventoActivity extends AppCompatActivity {
    private EventoService service = new EventoService();
    private MetoMapaDB db;
    private String nome;
    private String data;
    private String hora;
    private String predio;
    private String sala;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        db = new MetoMapaDB(this);
        String usuario_logado = db.consultar();
        TextView txt_autor = (TextView) findViewById(R.id.txt_autor);
        if (usuario_logado != null) {
            txt_autor.setText(usuario_logado);
        } else {
            txt_autor.setText(" -- ");
        }

        //Intent intent = getIntent();
        //Bundle dados = intent.getExtras();
        //String edificio = dados.getString("edificio");

        //TextView txt_edificio = (TextView) findViewById(txt_edificio);
        //txt_edificio.setText("EDIFÍCIO " + edificio.toString().toUpperCase());

        //final EditText etxt_nome = (EditText) findViewById(etxt_nome);
        //final EditText etxt_sala = (EditText) findViewById(etxt_sala);

        /* Mascara campo data */
        // final EditText etxt_data = (EditText) findViewById(etxt_data);
        /*etxt_data.addTextChangedListener(new TextWatcher() {
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

        Mascara campo tempo
       // final EditText etxt_duracao = (EditText) findViewById(//etxt_duracao);
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
        });*/

       /* Button btn_salvar_evento = (Button) findViewById(R.id.btn_salvar_evento);
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
        });*/

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public void onStart(){
        super.onStart();
        EditText data = (EditText)findViewById(R.id.etxt_data);
        EditText hora = (EditText)findViewById(R.id.etxt_hora);
        data.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus){
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    dialog.show(ft,"DatePicker");
                }
            }
        });
        hora.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus){
                    TimeDialog dialog = new TimeDialog(v);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    dialog.show(ft,"TimePicker");
                }
            }
        });
    }


    public void salvar(View view) throws ParseException {


        nome = (((EditText) findViewById(R.id.etxt_nome)).getText().toString());
        data = (((EditText) findViewById(R.id.etxt_data)).getText().toString());
        hora = (((EditText) findViewById(R.id.etxt_hora)).getText().toString());
        predio = (((TextView)findViewById(R.id.txt_edificio)).getText().toString());
        sala = (((EditText)findViewById(R.id.etxt_sala)).getText().toString());


        new EnviarMeusEventosTask(new Evento(nome, predio, data, hora, sala)).execute();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Evento Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }



    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public class EnviarMeusEventosTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog dialog;
        private Evento evento;

        public EnviarMeusEventosTask(Evento evento) {
            this.evento = evento;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(EventoActivity.this);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            ((EditText) findViewById(R.id.etxt_nome)).setText("");
            ((EditText) findViewById(R.id.etxt_sala)).setText("");
            dialog.dismiss();
        }

        @Override
        protected Void doInBackground(String... params) {
            service.post(evento);
            return null;
        }
    }


}
