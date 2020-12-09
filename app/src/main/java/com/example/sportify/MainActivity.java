package com.example.sportify;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button sign_in_button;
    Button sign_up_button;
    EditText email_edit;
    EditText pass_edit;


    FirebaseAuth auth = FirebaseAuth.getInstance();
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // login activity

        email_edit =  findViewById(R.id.email_edit);
        pass_edit = findViewById(R.id.password) ;
        sign_in_button =findViewById(R.id.signin);
        sign_up_button = findViewById(R.id.signup);

        sign_in_button.setOnClickListener(view ->{
            String email_text = email_edit.getText().toString().trim();
            String password_text = pass_edit.getText().toString().trim();

            auth.signInWithEmailAndPassword(email_text,password_text).addOnCompleteListener(login ->{
                if(login.isSuccessful()) {
                    Intent myIntent = new Intent(getApplicationContext(), productsActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_LONG).show();
                }

            });
        });
        
        sign_up_button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        });

    }

    public void contact_us(View view) {
        Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0524472633"));
        startActivity(intent);
    }
}