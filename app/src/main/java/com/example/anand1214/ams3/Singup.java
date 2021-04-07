package com.example.anand1214.ams3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anand1214.ams3.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Singup extends AppCompatActivity {

    //[ declaration variables ]
    private Button btn_singup;
    private EditText userEmail,userName,userPass,userContact;
    private TextView login_page;

    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    //[ end of variable declaration ]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(Singup.this);
        progressDialog.setTitle("Working");
        progressDialog.setMessage("In progress");
        getSupportActionBar().hide();

        login_page =(TextView) findViewById(R.id.tv_singup);
        userEmail = (EditText) findViewById(R.id.etUemail);
        userPass = (EditText) findViewById(R.id.etUpass);
        userName = (EditText) findViewById(R.id.etUname);
        userContact = (EditText) findViewById(R.id.etUcontact);
        btn_singup = (Button)findViewById(R.id.btn_login);

        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(Singup.this,Login.class);
                startActivity(n);
            }
        });

        btn_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
    }

    private void validation() {

        final String v_email = userEmail.getText().toString().trim();
        final String v_pass = userPass.getText().toString().trim();
        final String v_name = userName.getText().toString().trim();
        final String v_contact = userContact.getText().toString().trim();

        if (v_email.isEmpty()) {
            userEmail.setError("enter mail id");
            userEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(v_email).matches()) {
            userEmail.setError("Enter a valid email!");
            userEmail.requestFocus();
            return;
        }
        if (v_pass.isEmpty()) {
            userPass.setError("Enter password");
            userPass.requestFocus();
            return;
        }
        if (v_pass.length() < 6 ) {
            userPass.setError("Password should be 6 to 8 characters!");
            userPass.requestFocus();
            return;
        }
        if (v_pass.length() > 8 ) {
            userPass.setError("Password should be 6 to 8 characters!");
            userPass.requestFocus();
            return;
        }
        if (v_contact.isEmpty()) {
            userContact.setError("required for verification!!");
            userContact.requestFocus();
            return;
        }
        if (v_contact.length() != 10) {
            userContact.setError("enter a valid number");
            userContact.requestFocus();
            return;
        }

        progressDialog.show();
        auth.createUserWithEmailAndPassword(userEmail.getText().toString(),userPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    User user = new User(userName.getText().toString(),userEmail.getText().toString(),userContact.getText().toString(),userPass.getText().toString());

                    String id = task.getResult().getUser().getUid();
                    database.getReference().child("User").child(id).setValue(user);

                    Toast.makeText(Singup.this, "User Created succesfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Singup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}