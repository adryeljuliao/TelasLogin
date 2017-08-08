package com.juliao.adryel.telaslogin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OutraTela extends AppCompatActivity {

    private static final String PREFS_NAME = "preferencia";
    TextView labelNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra_tela);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE );

        labelNome = (TextView) findViewById(R.id.idNome);

        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");

        labelNome.setText(nome);

    }
}
