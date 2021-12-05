package com.example.per7_1918135;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<PenjualanRoko> ListPenjualanRoko = new ArrayList<PenjualanRoko>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPenjualanRoko );
        mListView = (ListView) findViewById(R.id.list_penjualan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPenjualanRoko.clear();
        List<PenjualanRoko> contacts = db.ReadPenjualanRoko();
        for (PenjualanRoko cn : contacts) {
            PenjualanRoko judulModel = new PenjualanRoko();
            judulModel.set_id(cn.get_id());
            judulModel.set_namaroko(cn.get_namaroko());
            judulModel.set_jenisroko(cn.get_jenisroko());
            judulModel.set_harga(cn.get_harga());
            ListPenjualanRoko.add(judulModel);
            if ((ListPenjualanRoko.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        PenjualanRoko obj_itemDetails = (PenjualanRoko) o;
        String Sid = obj_itemDetails.get_id();
        String Snamaroko = obj_itemDetails.get_namaroko();
        String Sjenisroko = obj_itemDetails.get_jenisroko();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inamaroko", Snamaroko);
        goUpdel.putExtra("Ijenisroko", Sjenisroko);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPenjualanRoko.clear();
        mListView.setAdapter(adapter_off);
        List<PenjualanRoko> contacts = db.ReadPenjualanRoko();
        for (PenjualanRoko cn : contacts) {
            PenjualanRoko judulModel = new PenjualanRoko();
            judulModel.set_id(cn.get_id());
            judulModel.set_namaroko(cn.get_namaroko());
            judulModel.set_jenisroko(cn.get_jenisroko());
            judulModel.set_harga(cn.get_harga());
            ListPenjualanRoko.add(judulModel);
            if ((ListPenjualanRoko.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
