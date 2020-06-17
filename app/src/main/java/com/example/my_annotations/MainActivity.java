package com.example.my_annotations;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AnnotationPreferences preferences;
    private EditText editText;
    private final String TEXT_KEY = "text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextMultiline);
        preferences = new AnnotationPreferences(getApplicationContext());

        // recovering previous text
        final String anotation = preferences.recoverAnotation(TEXT_KEY);
        editText.setText(anotation);

        // Saving text on Shared Preferences
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                // Save file only if its different of the last saved
                if(!text.equals(preferences.recoverAnotation(TEXT_KEY))) {
                    preferences.saveAnnotation(TEXT_KEY, text);
                    Snackbar.make(v, "Text Saved!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

}