package com.metodista.metomapa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by rds_d on 02/11/2016.
 */

public class EventoAdapter extends ArrayAdapter<Evento> {

    public EventoAdapter(Context context, int resource, List<Evento> objects) {
        super(context, resource, objects);
    }
    public View getView(final int position, View convertView, final ViewGroup parent){
        return convertView;
    }
}
