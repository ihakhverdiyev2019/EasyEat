package com.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class chooseitem extends AppCompatActivity implements View.OnClickListener {

    TextView restoranpage_title;
    String restoranname,table;
    Button button_pay;
    CheckBox menu_item1,menu_item2,menu_item3,menu_item4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseitem);

        restoranpage_title = (TextView) findViewById(R.id.restoranpage_title);
        button_pay = (Button) findViewById(R.id.button_pay);
        menu_item1 = (CheckBox) findViewById(R.id.menu_item1);
        menu_item2 = (CheckBox) findViewById(R.id.menu_item2);
        menu_item3 = (CheckBox) findViewById(R.id.menu_item3);
        menu_item4 = (CheckBox) findViewById(R.id.menu_item4);

        Intent intent = getIntent();
        restoranname = intent.getStringExtra("cafename");
        table = intent.getStringExtra("table");

        restoranpage_title.setText(restoranname);


        button_pay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_pay:

                if(!menu_item1.isChecked() && !menu_item2.isChecked() && !menu_item3.isChecked() && !menu_item4.isChecked()){
                    Toast.makeText(chooseitem.this,"Please choose item",Toast.LENGTH_LONG).show();
                    return;
                }

                int amount = 0;
                String itemname = "";
                if(menu_item1.isChecked()){
                    amount = amount + 10;
                    itemname = itemname + " 'Tater tots' ";
                }
                if(menu_item2.isChecked()){
                    amount = amount + 15;
                    itemname = itemname + " 'Cobb salad' ";
                }
                if(menu_item3.isChecked()){
                    amount = amount + 8;
                    itemname = itemname + " 'Pot roast' ";
                }
                if(menu_item4.isChecked()){
                    amount = amount + 12;
                    itemname = itemname + " 'Twinkies' ";
                }

                Intent intent = new Intent(chooseitem.this,pay.class);
                intent.putExtra("amount",""+amount);
                intent.putExtra("itemname",itemname);
                intent.putExtra("restoranname",restoranname);
                intent.putExtra("table",table);

                startActivity(intent);

                break;


                default:break;
        }
    }
}
