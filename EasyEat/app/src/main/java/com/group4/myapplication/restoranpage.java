package com.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class restoranpage extends AppCompatActivity implements View.OnClickListener {

    TextView restoranpage_title;
    String restoranname;
    RelativeLayout table_1,table_2,table_3,table_4,table_5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoranpage);

        //set ui
        restoranpage_title = (TextView) findViewById(R.id.restoranpage_title);
        table_1 = (RelativeLayout) findViewById(R.id.table_1);
        table_2 = (RelativeLayout) findViewById(R.id.table_2);
        table_3 = (RelativeLayout) findViewById(R.id.table_3);
        table_4 = (RelativeLayout) findViewById(R.id.table_4);
        table_5 = (RelativeLayout) findViewById(R.id.table_5);

        //get restoran name
        Intent intent = getIntent();
        restoranname = intent.getStringExtra("cafename");

        restoranpage_title.setText(restoranname);

        table_1.setOnClickListener(this);
        table_2.setOnClickListener(this);
        table_3.setOnClickListener(this);
        table_4.setOnClickListener(this);
        table_5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(restoranpage.this,chooseitem.class);
        switch (v.getId()){
            case R.id.table_1:
                intent.putExtra("table","1");
                intent.putExtra("cafename",restoranname);
                startActivity(intent);
                break;
            case R.id.table_2:
                intent.putExtra("table","2");
                intent.putExtra("cafename",restoranname);
                startActivity(intent);
                break;
            case R.id.table_3:
                intent.putExtra("table","3");
                intent.putExtra("cafename",restoranname);
                startActivity(intent);
                break;
            case R.id.table_4:
                intent.putExtra("table","4");
                intent.putExtra("cafename",restoranname);
                startActivity(intent);
                break;
            case R.id.table_5:
                intent.putExtra("table","5");
                intent.putExtra("cafename",restoranname);
                startActivity(intent);
                break;
                default:break;
        }
    }
}
