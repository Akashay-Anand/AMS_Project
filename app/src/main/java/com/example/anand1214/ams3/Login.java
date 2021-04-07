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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private TextView singup, fpass;
    private EditText userEmail,userPass;
    private Button btn_login;

    ProgressDialog progressDialog;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        singup= (TextView) findViewById(R.id.tv_singup);
        fpass= (TextView) findViewById(R.id.tv_fpass);
        userEmail= (EditText) findViewById(R.id.et_email);
        userPass= (EditText) findViewById(R.id.et_pass);
        btn_login = (Button) findViewById(R.id.btn_login);

        auth= FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setTitle("Working");
        progressDialog.setMessage("In progress");
        getSupportActionBar().hide();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n= new Intent(Login.this,Singup.class);
                startActivity(n);

            }
        });

        // here we are checking usre is registered or not
        if(auth.getCurrentUser()!=null){
            Intent n = new Intent(Login.this,MainActivity.class);
            startActivity(n);
        }
    }

    private void validation(){

        final String v_email = userEmail.getText().toString().trim();
        final String v_pass = userPass.getText().toString().trim();
        if(v_email.isEmpty()){
            userEmail.setError("enter mail id");
            userEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(v_email).matches()){
            userEmail.setError("Enter a valid email!");
            userEmail.requestFocus();
            return;
        }
        if(v_pass.isEmpty()){
            userPass.setError("Enter password");
            userPass.requestFocus();
            return;
        }

        progressDialog.show();
        auth.signInWithEmailAndPassword(userEmail.getText().toString(),userPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Intent n = new Intent(Login.this,MainActivity.class);
                    startActivity(n);
                }
                else {
                    Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}