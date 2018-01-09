package com.example.toshiba_l15w.pwebchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    TextView tvnama, tvemail, tvnomor;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    tvnama =(TextView) findViewById(R.id.tvNama);
    tvemail=(TextView)findViewById(R.id.tvEmail);
    tvnomor=(TextView)findViewById(R.id.tvNomor);

    user=getIntent().getParcelableExtra("user");
    tvnama.setText(user.getNama());
    tvemail.setText(user.getEmail());
    tvnomor.setText(user.getTelepon());
    }
}
