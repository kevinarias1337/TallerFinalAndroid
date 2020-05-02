package com.enterprise.version1.tallerfinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText matricula;
    private EditText nombre;
    private EditText calificacion1;
    private EditText calificacion2;
    private EditText calificacion3;
    private Button guardar;
    private Button salir;

    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matricula = findViewById(R.id.txtmatricula);
        nombre = findViewById(R.id.txtnombre);
        calificacion1 = findViewById(R.id.txtcalificacion1);
        calificacion2 = findViewById(R.id.txtcalificacion2);
        calificacion3 = findViewById(R.id.txtcalificacion3);
        guardar = findViewById(R.id.btnguardar);
        salir = findViewById(R.id.btnsalir);

       /* String ca1 = calificacion1.getText().toString();
        double cal1 = Double.parseDouble(ca1);
        String ca2 = calificacion2.getText().toString();
        double cal2 = Double.parseDouble(ca2);
        String ca3 = calificacion3.getText().toString();
        double cal3 = Double.parseDouble(ca3);

        double calculo = ((cal1+cal2+cal3)/3);
        String total = Double.toString(calculo); */

        databaseReference = FirebaseDatabase.getInstance().getReference("Calificaciones");
        progressDialog = new ProgressDialog(this);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mat = matricula.getText().toString().trim();
                String nom = nombre.getText().toString().trim();
                String c1 = calificacion1.getText().toString().trim();
                String c2 = calificacion2.getText().toString().trim();
                String c3 = calificacion3.getText().toString().trim();

               String ca1 = calificacion1.getText().toString();
                double cal1 = Double.parseDouble(ca1);
                String ca2 = calificacion2.getText().toString();
                double cal2 = Double.parseDouble(ca2);
                String ca3 = calificacion3.getText().toString();
                double cal3 = Double.parseDouble(ca3);

                double calculo = ((cal1+cal2+cal3)/3);
                String total = Double.toString(calculo);


                progressDialog.setMessage("Realizando registro");
                progressDialog.show();

                String id = databaseReference.push().getKey();

                DtoRegistroCalificaciones dtoRegistroCalificaciones = new DtoRegistroCalificaciones(id, mat, nom, c1, c2, c3, total);

                databaseReference.child(id).setValue(dtoRegistroCalificaciones);

                Toast.makeText(MainActivity.this, "Guardado", Toast.LENGTH_LONG).show();

                matricula.setText("");
                nombre.setText("");
                calificacion1.setText("");
                calificacion2.setText("");
                calificacion3.setText("");

                progressDialog.dismiss();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
