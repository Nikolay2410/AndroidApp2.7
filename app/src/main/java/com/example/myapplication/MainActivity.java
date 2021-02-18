package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private TextView message;
    private Button button;
    private String logT = "admin";
    private String pasT = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText)findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);
        message = (TextView)findViewById(R.id.message);
        button = (Button)findViewById(R.id.button);
        Resources resources = getResources();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((login.getText().toString().equals(logT))&&(password.getText().toString().equals(pasT))) {
                    message.setText(resources.getText(R.string.message_good));
                    message.setTextColor(resources.getColor(R.color.color_good));
                }
                else
                {
                    message.setText(resources.getText(R.string.message_bad));
                    message.setTextColor(resources.getColor(R.color.color_bad));
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivityForResult(intent,0);
                }
                login.setText("");
                password.setText("");
            }
        };
        button.setOnClickListener(listener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Resources resources = getResources();

        switch (resultCode) {
            case RESULT_OK:
                message.setText("Новый логин: "+data.getStringExtra("login2"));
                message.setTextColor(resources.getColor(R.color.white));
                logT = data.getStringExtra("login2");
                pasT = data.getStringExtra("password2");
                break;
        }
    }
}