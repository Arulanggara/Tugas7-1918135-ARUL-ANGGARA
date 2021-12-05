package com.example.per7_1918135;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<PenjualanRoko> movieItems;
    public CustomListAdapter(Activity activity, List<PenjualanRoko> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView text_namaroko = (TextView)
                convertView.findViewById(R.id.text_namaroko);
        TextView text_jenisroko = (TextView)
                convertView.findViewById(R.id.text_jenisroko);
        TextView text_harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        PenjualanRoko m = movieItems.get(position);
        text_namaroko.setText("Nama : "+ m.get_namaroko());
        text_jenisroko.setText("JENIS : "+ m.get_jenisroko());
        text_harga.setText("HARGA : "+ m.get_harga());
        return convertView;
    }
}
