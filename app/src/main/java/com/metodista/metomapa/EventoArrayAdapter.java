package com.metodista.metomapa;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rds_d on 02/11/2016.
 */

public class EventoArrayAdapter extends ArrayAdapter<Evento> {
    private Context context;
    private List<Evento> eventos;

    public EventoArrayAdapter(Context context, int resource, List<Evento> objects) {
        super(context, resource, objects);
        this.context = context;
        this.eventos = objects;
    }

    @TargetApi(Build.VERSION_CODES.FROYO)

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View linha = inflater.inflate(R.layout.activity_lista_eventos, parent, false);
        TextView nome =(TextView) linha.findViewById(R.id.nome);
        TextView predio =(TextView) linha.findViewById(R.id.predio);
        TextView data =(TextView) linha.findViewById(R.id.data);
        TextView hora =(TextView) linha.findViewById(R.id.hora);
        TextView sala = (TextView) linha.findViewById(R.id.n_sala);




        Evento e = eventos.get(position);
        nome.setText(e.getNome());
        predio.setText(e.getLocal());
        data.setText(e.getData());
        hora.setText(e.getHora());
        sala.setText(e.getSala());


        return linha;
    }


}
