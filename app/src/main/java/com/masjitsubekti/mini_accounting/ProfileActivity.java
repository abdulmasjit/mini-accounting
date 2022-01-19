package com.masjitsubekti.mini_accounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                Intent intent = new Intent(this, Simpanan.class);
                startActivity(intent);
                break;
        }
    }
}