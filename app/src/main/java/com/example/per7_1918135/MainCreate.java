package com.example.per7_1918135;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enamaroko, Ejenisroko, Eharga;
    private String Snamaroko, Sjenisroko, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enamaroko = (EditText) findViewById(R.id.create_namaroko);
        Ejenisroko = (EditText) findViewById(R.id.create_jenisroko);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Snamaroko = String.valueOf(Enamaroko.getText());
                Sjenisroko = String.valueOf(Ejenisroko.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snamaroko.equals("")){
                    Enamaroko.requestFocus();
                    Toast.makeText(MainCreate.this, "Tambahkan Nama Roko", Toast.LENGTH_SHORT).show();
                } else if (Sjenisroko.equals("")){
                    Ejenisroko.requestFocus();
                    Toast.makeText(MainCreate.this, "Tambahkan Jenis Roko", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Tambahkan Harga Roko", Toast.LENGTH_SHORT).show();
                }else
                    {
                    Enamaroko.setText("");
                    Ejenisroko.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreatePenjualanRoko(new PenjualanRoko(null, Snamaroko, Sjenisroko, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
