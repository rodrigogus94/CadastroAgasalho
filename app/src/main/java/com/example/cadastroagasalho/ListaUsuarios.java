package com.example.cadastroagasalho;

import android.os.Bundle;

import com.example.cadastroagasalho.BDHelper.UsuariosBD;
import com.example.cadastroagasalho.model.Usuario;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaUsuarios extends AppCompatActivity {

    ListView lista;
    UsuariosBD bdHelper;
    ArrayList<Usuario> listView_Usuarios;
    Usuario usuario;
    ArrayAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = (ListView) findViewById(R.id.listView_Usuarios);



    }

    protected void onResume(){
        super.onResume();
        carregarUsuario();
    }

    public void carregarUsuario(){
        bdHelper = new UsuariosBD(ListaUsuarios.this);
        listView_Usuarios = bdHelper.getList();
        bdHelper.close();

        if(listView_Usuarios != null){
            adapter = new ArrayAdapter<Usuario>(ListaUsuarios.this, android.R.layout.simple_list_item_1, listView_Usuarios);
            lista.setAdapter(adapter);
        }

    }

}
