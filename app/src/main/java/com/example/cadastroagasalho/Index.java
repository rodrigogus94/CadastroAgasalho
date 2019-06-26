package com.example.cadastroagasalho;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



import static com.example.cadastroagasalho.R.layout.activity_index;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_index);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button bt_Local = (Button) findViewById(R.id.bt_telaLocal);
        bt_Local.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Index.this, LocalDeArrecadacao.class);
                startActivity(intent);
            }
        });



        Button bt_cadastrar = (Button) findViewById(R.id.bt_telaCadastro);
        bt_cadastrar.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Index.this, FormularioAgasalho.class);
                startActivity(intent);
            }
        });


    }


}
