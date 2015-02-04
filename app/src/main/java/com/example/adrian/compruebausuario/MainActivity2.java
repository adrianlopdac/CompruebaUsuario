package com.example.adrian.compruebausuario;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity2 extends ActionBarActivity {
    TextView miTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        miTexto = (TextView)findViewById(R.id.textView3);
        compruebaUsuario();
    }

    private void compruebaUsuario(){
        int i = 0;
        Bundle miBundle = getIntent().getExtras();
        String usuario = miBundle.getString("USUARIO");
        String clave = miBundle.getString("CLAVE");
        Boolean existeUsuario = false;
        Boolean contraseñaCorrecta = false;

        String[] listaUsuarios = getResources().getStringArray(R.array.Nombres);

        for (String encontrarString:listaUsuarios){
            if(encontrarString.equals(usuario)){
                existeUsuario=true;
                break;
            }else{
                i++;
            }
        }

        if (existeUsuario){
            String[] listaContraseñas = getResources().getStringArray(R.array.Passwords);
            if (listaContraseñas[i].equals(clave)){
                miTexto.setText(R.string.mensaje_correcto);
            }else{
                miTexto.setTextColor(Color.RED);
                miTexto.setText(R.string.mensaje_contraseña);
            }
        }else{
            miTexto.setTextColor(Color.RED);
            miTexto.setText(R.string.mensaje_usuario);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
