package com.example.foodapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ownerSignin extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_signin);



        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(ownerSignin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else if (user.equals("kartik") && pass.equals("kartik8901")) {

                    Toast.makeText(ownerSignin.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), OwnerHomeActivity.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(ownerSignin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                }
            }

        ;



});

}
}