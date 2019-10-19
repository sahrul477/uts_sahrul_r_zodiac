package com.example.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button tes_zodiac;
    ImageView show_tgl;
    EditText nama, tgl_lahir;
    String var_tanggal,var_nama;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_tgl = findViewById(R.id.show_tgl);
        tes_zodiac = findViewById(R.id.tes_zodiac);
        nama = findViewById(R.id.nama);
        tgl_lahir = findViewById(R.id.tgl_lahir);



        show_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        tgl_lahir.setText(mDay + "/" +(mMonth+1) + "/" + mYear);
                    }
                },day,month,year);
                dpd.show();
            }
        });

        tes_zodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tgl_lahir.getText().toString().length()==0){
                    tgl_lahir.setError("Tangal Tidak Boleh Kosong");
                }else {
                    var_tanggal = tgl_lahir.getText().toString();
                    var_nama = nama.getText().toString();
                    Intent abc = new Intent(MainActivity.this,tes.class);
                    Bundle b = new Bundle();
                    b.putString("parse_tanggal", var_tanggal);
                    b.putString("parse_nama", var_nama);
                    abc.putExtras(b);
                    startActivity(abc);
                }
            }
        });



    }
}
