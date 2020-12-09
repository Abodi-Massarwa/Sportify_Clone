package com.example.sportify;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportify.tools.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {
    Button Signin;
    Button Signup;
    EditText name;
    EditText pass;
    User user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Signin = (Button)findViewById(R.id.signin);
        Signup  = (Button)findViewById(R.id.signup);
        name= (EditText) findViewById(R.id.name);
        pass =(EditText) findViewById(R.id.password) ;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        //Bundle received= getIntent().getBundleExtra("User");
        //user=(User)received.get("User"); //////
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    public void contact_us(View view) {
        Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0524472633"));
        startActivity(intent);
    }
}