package com.example.sahanacorona;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ProvideFodd extends AppCompatActivity implements View.OnClickListener{

    Button provide_food, provide_package, provide_other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_fodd);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        provide_food = findViewById(R.id.povide_FOOD);

        provide_package = findViewById(R.id.provide_PACKING);

        provide_other =findViewById(R.id.provide_other);

        provide_food.setOnClickListener(this);

        provide_package.setOnClickListener(this);

        provide_other.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.povide_FOOD:
                Intent intent = new Intent(ProvideFodd.this, GiveFood.class);
                startActivity(intent);
                break;

            case  R.id.provide_PACKING:
                Intent intent1 = new Intent(ProvideFodd.this,GivePacking.class);
                startActivity(intent1);
                break;

            case R.id.provide_other:
                Intent intent2 = new Intent(ProvideFodd.this, GiveNecessity.class);
                startActivity(intent2);
                break;
        }
    }
}
