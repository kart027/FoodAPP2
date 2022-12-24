package com.example.foodapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OwnerHomeActivity extends AppCompatActivity {

    EditText e;
    LinearLayout l;
    Button b,clearbutton;
    SQLiteDatabase db;
    TextView k,t;
    int f = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home);
        clearbutton = findViewById(R.id.clear);
        t = findViewById(R.id.table);
        l = findViewById(R.id.linearlayout);
        db=openOrCreateDatabase("OwnerDB", Context.MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS Restruant1(Name VARCHAR,Spicy VARCHAR,Vegitrain VARCHAR,Quantity number);");

        Cursor j = db.rawQuery("SELECT * FROM Table1", null);

        if(j.getCount()==0){
            t.setText("Total number of table required: 0");
        }else{
            j.moveToFirst();
            t.setText("Total number of table reuired :"+j.getString(0));
        }





        Cursor c = db.rawQuery("SELECT * FROM Restruant1 ", null);


        final TextView[] myTextViews = new TextView[5]; // create an empty array;

        while(c.moveToNext()) {


            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something



            rowTextView.setText("Name "+c.getString(0) + "\n"+"Quantity"+ c.getString(1) +"\n"+"Time of order "+ c.getString(2)+"\n");

            // add the textview to the linearlayout
            l.addView(rowTextView);

            // save a reference to the textview for later

        }

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.execSQL("DELETE    FROM Restruant1 ");

               db.execSQL("DELETE from Table1");

                finish();
                startActivity(getIntent());



                }

        });



    }
}