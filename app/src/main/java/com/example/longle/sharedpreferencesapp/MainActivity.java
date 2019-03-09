package com.example.longle.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.example.longle.sharedpreferenceapp.preferences";
    private static final String KEY_EDITTEXT = "key_edittext" ;
    private EditText editText;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare fields
        editText = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String editTextString = sharedPreferences.getString(KEY_EDITTEXT, "");
        editText.setText(editTextString);
    }

    @Override
    protected void onPause() {
        super.onPause();

        editor.putString(KEY_EDITTEXT, editText.getText().toString());
        editor.apply();
    }
}
