package com.valencia.oscar.w2d1_as5;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElements();
    }

    public void saveName(View view) {
        String nameValue = name.getText().toString();
        SharedPreferences settings = getSharedPreferences("profile", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("nameValue",nameValue );
        editor.commit();
        name.setText("");
    }

    public void showName(View view) {
        SharedPreferences settings = getSharedPreferences("profile", MODE_PRIVATE);
        String name = settings.getString("nameValue", "nothing saved yet!");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        Log.d("MY_TAG",name);
    }

    public void initElements(){
        name = findViewById(R.id.name);
    }
}
