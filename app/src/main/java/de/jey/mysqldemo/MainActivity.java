package de.jey.mysqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText) findViewById(R.id.edtUserName);
        PasswordEt = (EditText) findViewById(R.id.edtPassword);
    }
    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";

        BackgroundWorker back = new BackgroundWorker(this);
        back.execute(type,username, password) ;

    }
    public void goToReg(View view) {
        startActivity(new Intent(this,Register.class));
    }
}