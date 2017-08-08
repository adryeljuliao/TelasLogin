package com.juliao.adryel.telaslogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    private static final String PREFS_NAME = "panelinha" ;
    EditText login;
    EditText senha;
    Button botao;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        login = (EditText) findViewById(R.id.idLogin);
        senha = (EditText) findViewById(R.id.idSenha);
        label = (TextView) findViewById(R.id.idPdi);
        botao = (Button) findViewById(R.id.idBotao);
        Intent i = new Intent(getApplicationContext(), OutraTela.class);
        startActivity(i);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE );





    }

    public void clicar(View v){
        String inLogin = login.getText().toString();
        String inSenha = senha.getText().toString();
        if(inLogin.equals("adryel") && inSenha.equals("123")){

            Intent i = new Intent(getApplicationContext(), OutraTela.class);
            Bundle param = new Bundle();

            param.putString("nome", login.getText().toString());
            i.putExtras(param);
            startActivity(i);


        }else{
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        label.setText(login.getText().toString());
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("nome", login.getText().toString());
        editor.commit();
    }
}
