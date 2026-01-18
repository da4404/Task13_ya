package com.example.task13_ya;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Darya student@email.com
 *
 * @version 1.0
 *
 * @since 18/01/2026
 *
 * Activity that displays the credits for the application.
 */
public class Credits extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * Sets up the edge-to-edge display and the content view.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_credits);
    }
}