package com.example.cadastroagasalho.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cadastroagasalho.model.Usuario;

import java.util.ArrayList;

public class UsuariosBD extends SQLiteOpenHelper {

    private static String BDusuarios;
    private static final String DATABASE = BDusuarios;
    private static final int VERSION =1;

    public UsuariosBD(Context context) {
        super(context, DATABASE, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String usuario = "CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nomeusuario TEXT NOT NULL, endereco  TEXT NOT NULL, telefone INTEGER);";
        db.execSQL(usuario);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String usuario = "DROP TABLE IF EXISTS usuarios";
        db.execSQL(usuario);
    }

    public void salvarUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put("nomeusuario", usuario.getNome());
        values.put("endereco", usuario.getEndereco());
        values.put("telefone", usuario.getTelefone());

        getWritableDatabase().insert("usuarios", null, values);


    }


    public void alterarUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put("nomeusuario", usuario.getNome());
        values.put("endereco", usuario.getEndereco());
        values.put("telefone", usuario.getTelefone());

        String[] args = {usuario.getId().toString()};
        getWritableDatabase().update("usuarios", values, "id=?", args );

    }


    public void deletarUsuario(Usuario usuario){

        String[] args = {usuario.getId().toString()};
        getWritableDatabase().delete("usuarios", "id=?", args );

    }


    public ArrayList<Usuario> getList(){

        String[] columns ={"id", "nomeusuario", "endereco", "telefone"};
        Cursor cursor = getWritableDatabase().query("usuarios", columns, null, null, null, null, null, null );
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        while(cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getLong(0));
            usuario.setNome(cursor.getString(1));
            usuario.setEndereco(cursor.getString(2));
            usuario.setTelefone(cursor.getInt(3));

            usuarios.add(usuario);
        }
        return usuarios;
    }
}
