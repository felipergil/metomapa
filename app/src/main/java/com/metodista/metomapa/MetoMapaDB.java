package com.metodista.metomapa;

/**
 * Created by rafael on 30/10/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MetoMapaDB extends SQLiteOpenHelper {

    public MetoMapaDB(Context context){
        super(context, "MetoMapa", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Usuario (id integer primary key autoincrement, nome text, email text, usuario text, senha text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Usuario salvar(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        try {

            ContentValues values = new ContentValues();
            values.put("nome", usuario.getNome());
            values.put("email", usuario.getEmail());
            values.put("usuario", usuario.getUsuario());
            values.put("senha", usuario.getSenha());

            if (usuario.getId() == null){
                long id = db.insert("Usuario", null, values);
            }else{
                //update
            }

        } finally {
            db.close();
        }

        return usuario;
    }


    public String consultar(){
        SQLiteDatabase db = getReadableDatabase();
        try{

            String nome = null;

            Cursor cursor = db.rawQuery("SELECT nome FROM Usuario", null);
            cursor.moveToFirst();

            if(cursor.getCount() > 0){
                nome = cursor.getString(cursor.getColumnIndex("nome"));
            }

            return nome;

        }finally {
            db.close();
        }
    }

}
