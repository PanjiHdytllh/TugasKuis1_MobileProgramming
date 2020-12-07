package com.example.tugassqlitedatabase;

public class Laptop {
    private String _id, _nama, _merk, _harga;
    public Laptop (String id, String nama, String merk,String harga) {
        this._id = id;
        this._nama = nama;
        this._merk = merk;
        this._harga=harga;
    }
    public Laptop() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }

    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}

