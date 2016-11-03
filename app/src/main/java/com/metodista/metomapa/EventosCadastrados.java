package com.metodista.metomapa;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by rds_d on 02/11/2016.
 */

public class EventosCadastrados extends AppCompatActivity {
    private EventoService service = new EventoService();
    private EventoArrayAdapter adapter;

    private void carregarDados() {
        new CarregarMeusEventostosTask().execute();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_cadastrados);

        carregarDados();
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarDados();
    }


    private class CarregarMeusEventostosTask extends AsyncTask<String, Void, List<Evento>> {
        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(EventosCadastrados.this);
            dialog.show();
        }

        @Override

        protected void onPostExecute(List<Evento> eventos) {
            if (eventos != null) {
                adapter = new EventoArrayAdapter(getBaseContext(), 0, eventos);
                ((ListView) findViewById(R.id.eventos)).setAdapter(adapter);
            }
            dialog.dismiss();
        }

        @Override
        protected List<Evento> doInBackground(String... params) {
            try {
                return service.getAll();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }
}
