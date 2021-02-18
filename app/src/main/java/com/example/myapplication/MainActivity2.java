package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText login2;
    private EditText password2;
    private Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login2 = (EditText)findViewById(R.id.login2);
        password2 = (EditText)findViewById(R.id.password2);
        button2 = (Button)findViewById(R.id.button2);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("login2", login2.getText().toString());
                i.putExtra("password2", password2.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        };
        button2.setOnClickListener(listener);
    }
}