package com.metodista.metomapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private MetoMapaDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        db = new MetoMapaDB(this);

        final EditText etxt_nome = (EditText) findViewById(R.id.etxt_nome);
        final EditText etxt_email = (EditText) findViewById(R.id.etxt_email);
        final EditText etxt_usuario = (EditText) findViewById(R.id.etxt_usuario);
        final EditText etxt_senha = (EditText) findViewById(R.id.etxt_senha);

        Button btn_salvar_cadastro = (Button) findViewById(R.id.btn_salvar_cadastro);

        btn_salvar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etxt_nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo nome é obrigatório", Toast.LENGTH_SHORT).show();
                }else if (etxt_email.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo data é obrigatório", Toast.LENGTH_SHORT).show();
                }else if (etxt_usuario.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo usuário é obrigatório", Toast.LENGTH_SHORT).show();
                }else if (etxt_senha.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "O campo senha é obrigatório", Toast.LENGTH_SHORT).show();
                }else {

                    //Savar dados do usuario no sqlite
                    Usuario usuario = new Usuario();
                    usuario.setNome(etxt_nome.getText().toString());
                    usuario.setEmail(etxt_email.getText().toString());
                    usuario.setUsuario(etxt_usuario.getText().toString());
                    usuario.setSenha(etxt_senha.getText().toString());
                    db.salvar(usuario);

                    Intent principal = new Intent();
                    principal.putExtra("resultado", "Bem vindo " + etxt_nome.getText().toString() + " !!");
                    setResult(RESULT_OK, principal);
                    finish();
                }
            }
        });

    }
}
