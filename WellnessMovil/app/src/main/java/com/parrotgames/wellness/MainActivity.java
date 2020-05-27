package com.parrotgames.wellness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.parrotgames.wellness.model.User;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private TextView SignUpText;
    private EditText emailTextSI;
    private EditText passwordTextSI;
    private Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignUpText = findViewById(R.id.signUpText);
        emailTextSI = findViewById(R.id.emailTextSI);
        passwordTextSI = findViewById(R.id.passwordTextSI);
        signInBtn = findViewById(R.id.signInBtn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        SignUpText.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, SignUpActivity.class);
                    startActivity(i);
                }
        );

        signInBtn.setOnClickListener(
                (v)->{

                    String email = emailTextSI.getText().toString();
                    String password = passwordTextSI.getText().toString();

                    if(email.equals("") || password.equals("")){
                        Toast.makeText(MainActivity.this, "falta info", Toast.LENGTH_SHORT).show();
                    }else{
                        database.getReference().child("Users").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                User user = dataSnapshot.getValue(User.class);
                                if(email.equals(user.getEmail()) && password.equals(user.getPassword()) ) {
                                    Intent i = new Intent(MainActivity.this,SelectActivity.class);
                                    i.putExtra("id",user.getId());
                                    startActivity(i);
                                }else{
                                    Toast.makeText(MainActivity.this, "Los datos son incorrectos", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
        );
    }
}