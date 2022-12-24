package com.example.foodapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TablePages extends AppCompatActivity {

    //    ListView superListView;
    Button b1;
    EditText t;
    RadioGroup rg;
    RadioButton t1, t2, t3, t4, t5, t6, t7, t8;
    int S;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.onbooked);
        t = (EditText) findViewById(R.id.inputtable);
        db = openOrCreateDatabase("OwnerDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Table1(Notable number);");

//        b1 = findViewById(R.id.button);
//        rg = findViewById(R.id.radio);
//        t1 = findViewById(R.id.table1);
//        t2 = findViewById(R.id.table2);
//        t3 = findViewById(R.id.table3);
//        t4 = findViewById(R.id.table4);
//        t5 = findViewById(R.id.table5);
//        t6 = findViewById(R.id.table6);
//        t7 = findViewById(R.id.table7);
//        t8 = findViewById(R.id.table8);


//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == R.id.table1)
//                    S = 1;
//                else if (i == R.id.table2)
//                    S = 2;
//                else if (i == R.id.table3)
//                    S = 3;
//                else if (i == R.id.table4)
//                    S = 4;
//                else if (i == R.id.table5)
//                    S = 5;
//                else if (i == R.id.table6)
//                    S = 6;
//                else if (i == R.id.table7)
//                    S = 7;
//                else if (i == R.id.table8)
//                    S = 8;
//
//
//            }
//        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String table = t.getText().toString();
                int k = Integer.parseInt(table);

                if (k > 5) {
                    Toast.makeText(TablePages.this, "Please enter valid number of table(not more than 5)", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                    Cursor c = db.rawQuery("SELECT * FROM Table1", null);
                    if (c.getCount() == 0) {
                        db.execSQL("INSERT INTO Table1 VALUES('" + k + "');");

                    } else {
                        c.moveToFirst();
                        int i = c.getInt(0);
                        db.execSQL("UPDATE Table1 SET Notable ='" + (i + k) + "'");
                    }


                    intent.putExtra("message_key", "No of table Booked " + S);
                    startActivity(intent);
                }
            }
        });
    }
}

