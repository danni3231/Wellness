package com.parrotgames.wellness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.parrotgames.wellness.model.User;

public class SignUpActivity extends AppCompatActivity {

    private TextView signInText;
    private EditText nameTextSU;
    private EditText emailTextSU;
    private EditText passwordTextSU;
    private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signInText = findViewById(R.id.signInText);
        nameTextSU = findViewById(R.id.namelTextSU);
        emailTextSU = findViewById(R.id.emailTextSU);
        passwordTextSU = findViewById(R.id.passwordTextSU);
        signUpBtn = findViewById(R.id.signUpBtn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        signInText.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
        );

        signUpBtn.setOnClickListener(
                (v)->{

                    String name = nameTextSU.getText().toString();
                    String email = emailTextSU.getText().toString();
                    String password = passwordTextSU.getText().toString();

                    if(validateData(name,email,password)){
                        String id = database.getReference().child("Users").push().getKey();

                        User user = new User(id,name,email,password);
                        database.getReference().child("Users").child(id).setValue(user);

                        Intent i = new Intent(this, SelectActivity.class);
                        i.putExtra("id",id);
                        startActivity(i);
                    }

                }
        );
    }

    public boolean validateData(String name,String email,String password){
        boolean validate = true;
        if(name.equals("") || email.equals("") || password.equals("")){
            validate =false;
            Toast.makeText(SignUpActivity.this,"falta info",Toast.LENGTH_LONG).show();
        }
        else if(!email.endsWith("@hotmail.com")){
            validate = false;
            Toast.makeText(SignUpActivity.this,"correo no valido",Toast.LENGTH_LONG).show();
        }

        return  validate;
    }





}


