package de.jey.mysqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText name, surname, age, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.edtName);
        surname = (EditText) findViewById(R.id.edtSurname);
        age = (EditText) findViewById(R.id.edtAge);
        username = (EditText) findViewById(R.id.edtUserName);
        password = (EditText) findViewById(R.id.edtPassword);
    }
    public void onReg(View view) {
        String s_name = name.getText().toString();
        String s_surname = surname.getText().toString();
        String s_age = age.getText().toString();
        String s_username = username.getText().toString();
        String s_password = password.getText().toString();

        String type = "register";

        BackgroundWorker back = new BackgroundWorker(this);
        back.execute(type, s_name, s_surname, s_age, s_username, s_password) ;

    }
}