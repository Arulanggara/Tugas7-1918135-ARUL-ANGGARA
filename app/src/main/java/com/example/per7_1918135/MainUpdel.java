package com.example.per7_1918135;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snamaroko, Sjenisroko, Sharga;
    private EditText Enamaroko, Ejenisroko, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snamaroko = i.getStringExtra("Inamaroko");
        Sjenisroko = i.getStringExtra("Ijemisroko");
        Sharga = i.getStringExtra("Iharga");
        Enamaroko = (EditText) findViewById(R.id.updel_namaroko);
        Ejenisroko = (EditText) findViewById(R.id.updel_jenisroko);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enamaroko.setText(Snamaroko);
        Ejenisroko.setText(Sjenisroko);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snamaroko = String.valueOf(Enamaroko.getText());
                Sjenisroko = String.valueOf(Ejenisroko.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snamaroko.equals("")){
                    Enamaroko.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama roko", Toast.LENGTH_SHORT).show();
                } else if (Sjenisroko.equals("")){
                    Ejenisroko.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis roko", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga roko",
                            Toast.LENGTH_SHORT).show();
                } else {db.UpdatePenjualanRoko(new PenjualanRoko(Sid, Snamaroko, Sjenisroko, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePenjualanRoko (new PenjualanRoko(Sid, Snamaroko, Sjenisroko, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
