package com.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class findrestaurants extends AppCompatActivity implements View.OnClickListener {

    Button findrestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set ui
        findrestaurants = (Button) findViewById(R.id.findrestaurants);

        findrestaurants.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findrestaurants:
                startActivity(new Intent(findrestaurants.this,restaurantslist.class));

                default:
                    break;
        }
    }
}
