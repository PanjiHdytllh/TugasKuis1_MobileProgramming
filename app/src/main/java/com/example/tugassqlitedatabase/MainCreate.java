package com.example.tugassqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Emerk, Eharga;
    private String Snama, Smerk, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Eharga = (EditText) findViewById(R.id.create_harga);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Smerk = String.valueOf(Emerk.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Smerk.equals("")) {
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merk",
                            Toast.LENGTH_SHORT).show();
                }else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Emerk.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateLaptop(new Laptop(null, Snama, Smerk, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

