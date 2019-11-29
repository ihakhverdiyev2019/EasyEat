package com.group4.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pay extends AppCompatActivity {

    TextView restoranpage_title,pay_items,pay_table,pay_price;

    String amount = "",itemname = "",restoranname = "",table = "";

    Button visa_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        //set ui
        restoranpage_title = (TextView) findViewById(R.id.restoranpage_title);
        pay_items = (TextView) findViewById(R.id.pay_items);
        pay_table = (TextView) findViewById(R.id.pay_table);
        pay_price = (TextView) findViewById(R.id.pay_price);
        visa_card = (Button) findViewById(R.id.visa_card);

        Intent intent = getIntent();
        amount = intent.getStringExtra("amount");
        itemname = intent.getStringExtra("itemname");
        restoranname = intent.getStringExtra("restoranname");
        table = intent.getStringExtra("table");

        restoranpage_title.setText(restoranname);
        pay_table.setText(" Table: "+table+" ");
        pay_items.setText(" Items: "+itemname+" ");
        pay_price.setText(" Price: "+amount+"$ ");

        visa_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callpassworddialog();
            }
        });

    }

    public void callpassworddialog(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(pay.this);
        edittext.setHint("Please enter a password");
        edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());
        alert.setTitle("Restaurants");
        alert.setMessage("Credit Cart");
        alert.setIcon(R.drawable.ic_lock);
        alert.setView(edittext);
        alert.setCancelable(false);

        alert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                final String password = edittext.getText().toString();
                if(password.trim().toLowerCase().equals("12345")){
//                if(password.trim().toLowerCase().equals("")){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Operation successful.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),restaurantslist.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }},2000);
                }else{
                    Toast.makeText(getApplicationContext(),"Your password is incorrect, please enter the correct password",Toast.LENGTH_SHORT).show();
                    callpassworddialog();
                }
            }
        });
        alert.show();
    }

}
