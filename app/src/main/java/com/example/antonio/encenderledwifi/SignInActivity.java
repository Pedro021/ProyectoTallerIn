package com.example.antonio.encenderledwifi;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;


public class SignInActivity extends OrmLiteBaseActivity<DbHelper> implements View.OnClickListener {

    private EditText etUserName, etPassword;
    Button btnSignIn;
    Dao dao;
    DbHelper helper;
    Usuario useer;
    String nombre;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        helper = OpenHelperManager.getHelper(this, DbHelper.class);
        inicializarComponentes();
        actionBar();
    }

    private void actionBar() {
        ab = getActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.show();
    }

    private void inicializarComponentes() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPass);
        btnSignIn = (Button) findViewById(R.id.btnSingIn2);

        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSingIn2) {
            try {
                dao = getHelper().getUsuarioDao();
                QueryBuilder queryBuilder = dao.queryBuilder();
                queryBuilder.setWhere(queryBuilder.where().eq(Usuario.EMAIL, etUserName.getText().toString()));
                queryBuilder.setWhere(queryBuilder.where().eq(Usuario.CONTRASENA, etPassword.getText().toString()));
                List usuarios = dao.query(queryBuilder.prepare());

                if (usuarios.isEmpty()) {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                    etPassword.setFocusable(true);
                } else {
                    useer = new Usuario();
                    useer = (Usuario) usuarios.get(0);
                    nombre = useer.getNombre().toString();
                    Toast.makeText(this, "Bienvenido " + nombre, Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(this, Configuracion.class);
                    //i.putExtra("u", nombre);
                    startActivity(i);
                }
            } catch (SQLException e) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }

        }
    }

    //<editor-fold desc="MENU">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
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

    //</editor-fold>
}
