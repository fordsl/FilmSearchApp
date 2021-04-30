package com.vladborisov.filmsearchproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.zip.Inflater;

public class ShowFilm extends AppCompatActivity {

    final static String TAG = ShowFilm.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_film);
        final Intent intent = getIntent();
        int data;
        data = intent.getIntExtra(MainActivity.NAME_NUMBER_OF_CHOOSE_FILM_EXTRA, 1);
        ViewGroup showFilmConstraint = findViewById(R.id.container);
        View view = null;
        switch (data) {
            case 1:
                view = LayoutInflater.from(this).inflate(R.layout.film1, showFilmConstraint, false);
                break;
            case 2:
            case 3:
                view = LayoutInflater.from(this).inflate(R.layout.film2, showFilmConstraint, false);
                break;
        }
        showFilmConstraint.addView(view);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShowFilm.this, MainActivity.class);
        EditText editText = findViewById(R.id.text_input_comment2);
        CheckBox checkBox = findViewById(R.id.checkBox);
        Log.d(TAG, checkBox.isChecked() + editText.getText().toString());
        intent.putExtra(MainActivity.ANSWER_CHECKBOX, checkBox.isChecked());
        intent.putExtra(MainActivity.ANSWER_COMMENT, editText.getText().toString());
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}


