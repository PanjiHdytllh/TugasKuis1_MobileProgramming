package com.example.tugassqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Smerk,Sharga;
    private EditText Enama, Emerk, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Smerk = i.getStringExtra("Imerk");
        Sharga = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Emerk = (EditText) findViewById(R.id.updel_merk);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama.setText(Snama);
        Emerk.setText(Smerk);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Smerk = String.valueOf(Emerk.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merk",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateLaptop(new Laptop(Sid, Snama, Smerk, Sharga));
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
                db.DeleteLaptop(new Laptop(Sid, Snama, Smerk, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

