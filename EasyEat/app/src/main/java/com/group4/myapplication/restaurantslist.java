package com.group4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class restaurantslist extends AppCompatActivity implements View.OnClickListener {

    LinearLayout restauranstlist_restoran1,restauranstlist_restoran2,restauranstlist_restoran3,restauranstlist_restoran4;
    EditText cafecontrol_searchcafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantslist);

        //set uri
        restauranstlist_restoran1 = (LinearLayout) findViewById(R.id.restauranstlist_restoran1);
        restauranstlist_restoran2 = (LinearLayout) findViewById(R.id.restauranstlist_restoran2);
        restauranstlist_restoran3 = (LinearLayout) findViewById(R.id.restauranstlist_restoran3);
        restauranstlist_restoran4 = (LinearLayout) findViewById(R.id.restauranstlist_restoran4);

        cafecontrol_searchcafe = (EditText) findViewById(R.id.cafecontrol_searchcafe);

        cafecontrol_searchcafe.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()){

                    String word = s.toString().trim().toLowerCase();

                    if(("telequlle").contains(word) ||
                            ("akademik abbaszadə 12").contains(word)){
                        restauranstlist_restoran1.setVisibility(View.VISIBLE);
                        restauranstlist_restoran2.setVisibility(View.GONE);
                        restauranstlist_restoran3.setVisibility(View.GONE);
                        restauranstlist_restoran4.setVisibility(View.GONE);
                    }else if(("sefa balıq evi").contains(word) ||
                            ("namiq quliyev kucesi").contains(word)){
                        restauranstlist_restoran1.setVisibility(View.GONE);
                        restauranstlist_restoran2.setVisibility(View.VISIBLE);
                        restauranstlist_restoran3.setVisibility(View.GONE);
                        restauranstlist_restoran4.setVisibility(View.GONE);
                    }else if(("sirvansah").contains(word) ||
                            ("salatin esgerova kucəsi 86").contains(word)){
                        restauranstlist_restoran1.setVisibility(View.GONE);
                        restauranstlist_restoran2.setVisibility(View.GONE);
                        restauranstlist_restoran3.setVisibility(View.VISIBLE);
                        restauranstlist_restoran4.setVisibility(View.GONE);
                    }else if(("nergiz restorani").contains(word) ||
                            ("fevvareler meydani").contains(word)){
                        restauranstlist_restoran1.setVisibility(View.GONE);
                        restauranstlist_restoran2.setVisibility(View.GONE);
                        restauranstlist_restoran3.setVisibility(View.GONE);
                        restauranstlist_restoran4.setVisibility(View.VISIBLE);
                    }else if(("tater tots").contains(word) || ("cobb salad").contains(word) || ("pot roast").contains(word) || ("twinkies").contains(word)){
                        restauranstlist_restoran1.setVisibility(View.VISIBLE);
                        restauranstlist_restoran2.setVisibility(View.VISIBLE);
                        restauranstlist_restoran3.setVisibility(View.VISIBLE);
                        restauranstlist_restoran4.setVisibility(View.VISIBLE);
                    }else{
                        restauranstlist_restoran1.setVisibility(View.GONE);
                        restauranstlist_restoran2.setVisibility(View.GONE);
                        restauranstlist_restoran3.setVisibility(View.GONE);
                        restauranstlist_restoran4.setVisibility(View.GONE);
                    }

                } else {
                    restauranstlist_restoran1.setVisibility(View.VISIBLE);
                    restauranstlist_restoran2.setVisibility(View.VISIBLE);
                    restauranstlist_restoran3.setVisibility(View.VISIBLE);
                    restauranstlist_restoran4.setVisibility(View.VISIBLE);

                }

            }});


        restauranstlist_restoran1.setOnClickListener(this);
        restauranstlist_restoran2.setOnClickListener(this);
        restauranstlist_restoran3.setOnClickListener(this);
        restauranstlist_restoran4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(restaurantslist.this,restoranpage.class);

        switch (v.getId()){
            case R.id.restauranstlist_restoran1:
                intent.putExtra("cafename","Teleqüllə");
                startActivity(intent);
                break;
            case R.id.restauranstlist_restoran2:
                intent.putExtra("cafename","Şəfa Balıq Evi");
                startActivity(intent);
                break;
            case R.id.restauranstlist_restoran3:
                intent.putExtra("cafename","Şirvanşah");
                startActivity(intent);
                break;
            case R.id.restauranstlist_restoran4:
                intent.putExtra("cafename","Nərgiz Restoranı");
                startActivity(intent);
                break;

                default:break;
        }
    }

}
