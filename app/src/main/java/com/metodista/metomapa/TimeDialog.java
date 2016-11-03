package com.metodista.metomapa;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by rds_d on 02/11/2016.
 */

public class TimeDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    EditText hora;


    public TimeDialog(View view){
        hora = (EditText)view;
    }
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minuto = c.get(Calendar.MINUTE);
        boolean am_pm = true;

        return new TimePickerDialog(getActivity(), this, hora, minuto,am_pm);
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String horaMin = hourOfDay+":"+ minute;
        hora.setText(horaMin);
    }
}
