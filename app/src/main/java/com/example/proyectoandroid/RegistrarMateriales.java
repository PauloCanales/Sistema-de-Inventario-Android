package com.example.proyectoandroid;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarMateriales extends AppCompatActivity implements View.OnClickListener{

    private Spinner spinner;
    private EditText edtId, edtNombre, edtCant;
    private Button btnRegistrar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtId = (EditText)findViewById(R.id.edtId);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtCant = (EditText)findViewById(R.id.edtCant);
        spinner = (Spinner)findViewById(R.id.spinner);
        btnRegistrar = (Button)findViewById(R.id.btnMostrar);
        btnRegistrar.setOnClickListener(this);

        String [] opciones = {"Tipo", "Legumbres" , "Verduras", "Carnes", "Frutas", "Cereales", "Lacteos", "Bebestibles" };




        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);
    }

    private void registrarMaterail(){
        SQLUtilities conexion = new SQLUtilities(this, "Material", null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String id = edtId.getText().toString();
        String nombre = edtNombre.getText().toString();
        String cantidad = edtCant.getText().toString();
        String tipo = spinner.getSelectedItem().toString();


        if ( !id.isEmpty() && !nombre.isEmpty() && !cantidad.isEmpty() && !tipo.equals("Tipo") ){
            ContentValues registro = new ContentValues();

            registro.put("Id", id);
            registro.put("nombre", nombre);
            registro.put("cantidad", cantidad);
            registro.put("tipo", tipo);


            db.insert("Material", null, registro);

            db.close();

            Toast.makeText(this,nombre +" se ha registrado con exito", Toast.LENGTH_SHORT).show();

            edtId.setText("");
            edtNombre.setText("");
            edtCant.setText("");
            spinner.setSelection(0);


        }else{
            Toast.makeText(this," Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }







    }

    @Override
    public void onClick(View view) {
        registrarMaterail();

    }
}
