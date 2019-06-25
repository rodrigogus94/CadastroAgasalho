package com.example.cadastroagasalho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cadastroagasalho.BDHelper.UsuariosBD;
import com.example.cadastroagasalho.model.Usuario;

import static com.example.cadastroagasalho.R.layout.activity_cadastro;

public class FormularioAgasalho extends AppCompatActivity {

    EditText editText_nome, editText_endereco, editText_telefone;
    Button bt_cadastrar;
    Usuario editarUsuario, usuario;
    UsuariosBD bdHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_cadastro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        usuario = new Usuario();
        bdHelper = new UsuariosBD(FormularioAgasalho.this);

        Intent intent = getIntent();
        editarUsuario = (Usuario) intent.getSerializableExtra("usuario_escolhido");

        editText_nome= (EditText) findViewById(R.id.editText_nome);
        editText_telefone = (EditText) findViewById(R.id.editText_endereco);
        editText_telefone = (EditText) findViewById(R.id.editText_telefone);



        bt_cadastrar = (Button) findViewById(R.id.bt_cadastrar);
        if(editarUsuario != null){
            bt_cadastrar.setText("Alterar");
        }else{
            bt_cadastrar.setText("Cadastrar");

        }

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(editText_nome.getText().toString());
                usuario.setEndereco(editText_endereco.getText().toString());
                usuario.setTelefone(Integer.parseInt(editText_telefone.getText().toString()));

                if(bt_cadastrar.getText().toString().equals("Cadastrar")){
                    bdHelper.salvarUsuario(usuario);
                    bdHelper.close();
                }else{
                    bdHelper.alterarUsuario(usuario);
                    bdHelper.close();
                }

            }
        });



    }

}
