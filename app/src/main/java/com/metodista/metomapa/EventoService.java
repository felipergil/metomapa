package com.metodista.metomapa;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rds_d on 02/11/2016.
 */

public class EventoService {
    private static final String URL = "https://openws.herokuapp.com/eventos_pap";
    private static final String API_KEY = "?apiKey=aaa002be072ad6ec0bd1997da67d88a2";
    public List<Evento> getAll() {
        List<Evento> eventos = new ArrayList();
        HttpURLConnection urlConnection = null;

        try {
            java.net.URL url = new URL(URL + API_KEY);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String resultado = s.useDelimiter("\\A").next();
            Log.d("msg", resultado);

            Gson gson = new Gson();
            Type token = new TypeToken<List<Evento>>(){}.getType();
            eventos = gson.fromJson(resultado,token );
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            urlConnection.disconnect();
        }
        return eventos;
    }

    public void post(Evento evento) {
        HttpURLConnection urlConnection = null;

        Gson gson = new Gson();
        String json = gson.toJson(evento);
        Log.d("evento", json);

        try {
            URL url = new URL(URL + API_KEY);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            Log.d("evento", "configurou conexao");
            Log.d("evento", evento.toString());
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream( ));
            Writer w = new BufferedWriter(new OutputStreamWriter(out));
            Log.d("evento", "criou writer");

            w.write(json);
            w.close();
            Log.d("evento", "fechou writer");

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.nextLine();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            urlConnection.disconnect();
        }
    }

    public void delete(String id) {
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(URL + "/" + id + API_KEY);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("DELETE");

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            urlConnection.disconnect();
        }
    }
}
