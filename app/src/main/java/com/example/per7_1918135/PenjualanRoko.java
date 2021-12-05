package com.example.per7_1918135;

public class PenjualanRoko {
    private String _id, _namaroko, _jenisroko, _harga;
    public PenjualanRoko(String id, String namaroko, String jenisroko, String harga) {
        this._id = id;
        this._namaroko = namaroko;
        this._jenisroko= jenisroko;
        this._harga = harga;
    }
    public PenjualanRoko() {

    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_namaroko() {
        return _namaroko;
    }
    public void set_namaroko(String _namaroko) {
        this._namaroko = _namaroko;
    }
    public String get_jenisroko() {
        return _jenisroko;
    }
    public void set_jenisroko(String _jenisroko) {
        this._jenisroko = _jenisroko;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }

}
