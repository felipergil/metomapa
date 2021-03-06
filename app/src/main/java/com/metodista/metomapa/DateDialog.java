package com.metodista.metomapa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by rds_d on 31/10/2016.
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    EditText data;
    public DateDialog(View view){
        data = (EditText)view;
    }
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public void onDateSet(DatePicker view, int year, int month, int day){
        String date = day+"/"+(month+1)+"/"+year;
        data.setText(date);
    }
}