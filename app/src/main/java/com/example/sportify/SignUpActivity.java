package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportify.tools.User;
import com.example.sportify.tools.UserDataHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Console;
import java.io.Serializable;

public class SignUpActivity extends AppCompatActivity {

    private Button button;
private EditText e1;
private EditText e2;
private EditText e3;
private EditText e4;
private EditText e5;
private User user ;
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button = (Button)findViewById(R.id.userbtn);
        e1 =  (EditText) findViewById(R.id.name);
        e2 =  (EditText) findViewById(R.id.ln);
        e3 = (EditText) findViewById(R.id.email);
        e4 =  (EditText) findViewById(R.id.area);
        e5 =  (EditText) findViewById(R.id.num);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User(e1.getText().toString(),e2.getText().toString(),e4.getText().toString(),e5.getText().toString(),e3.getText().toString());
               // myRef.child("Users").setValue(user);
                UserDataHolder.s_user = user;
            }
        });
    }

    //        android:onClick="sign_up"
    public void sign_up(View view) throws Exception {
        //user = new User(e1.getText().toString(),e2.getText().toString(),e4.getText().toString(),e5.getText().toString(),e3.getText().toString(),null);
        if(e1 == null)
            throw new Exception("Holy shiiit");
        if(e1.getText() == null)
            throw  new Exception("lo ba3aya");
        String n1 = e1.getText().toString();
        String n5 = e5.getText().toString();
        String n3 = e3.getText().toString();
        String n4 = e4.getText().toString();
        String n2 = e2.getText().toString();

        UserDataHolder.s_user = new User(e1.getText().toString(),e2.getText().toString(),e4.getText().toString(),e5.getText().toString(),e3.getText().toString(),null);
       // String [] info= {e1.getText().toString(),e2.getText().toString(),e4.getText().toString(),e5.getText().toString(),e3.getText().toString()};
           // intent.putExtra("User",user);
    }
}