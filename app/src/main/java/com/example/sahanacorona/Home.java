package com.example.sahanacorona;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    //Button mark_people, provide,show_data;
    CardView mark_needy, donate_food, find_needy, ngo_only;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mark_needy = findViewById(R.id.home_MARK_NEEDY);
        donate_food = findViewById(R.id.home_DONATE_FOOD);
        find_needy = findViewById(R.id.home_FIND_NEEDY);
        ngo_only = findViewById(R.id.home_NGO_ONLY);

        mark_needy.setOnClickListener(this);
        donate_food.setOnClickListener(this);
        find_needy.setOnClickListener(this);
        ngo_only.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.home_MARK_NEEDY:
                Intent intent = new Intent(Home.this, MarkPeoples.class);
                startActivity(intent);
                break;

            case R.id.home_DONATE_FOOD:
                Intent intent1 = new Intent(Home.this, ProvideFodd.class);
                startActivity(intent1);
                break;

            case R.id.home_FIND_NEEDY:
                Intent intent2 = new Intent(Home.this,ShowData.class);
                startActivity(intent2);
                break;

            case R.id.home_NGO_ONLY:
                Intent intent3 = new Intent(Home.this,ShowData.class);
                startActivity(intent3);
        }

    }
}
