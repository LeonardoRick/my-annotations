package com.example.my_annotations;

import android.content.Context;
import android.content.SharedPreferences;

public class AnnotationPreferences {

    private Context context;
    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    private final String FILE_NAME = "annotation.preferences";

    public AnnotationPreferences(Context c) {
        this.context = c;
        preferences = this.context.getSharedPreferences(FILE_NAME, 0);
        editor = preferences.edit();
    }

    /**
     * Recovering user data if he saved something os Preferences
     *
     * @param key to save on Preferences
     * @param value that will be saved on the specified key
     */
    public void saveAnnotation(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Recovering user data if he saved something os Preferences
     *
     * @param key that was saved before on user Preferences
     * @return String text recovered
     */
    public String recoverAnotation(String key) {
        return preferences.getString(key, "");
    }
}
