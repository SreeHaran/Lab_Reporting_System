package com.sreeharan.labreportingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_OUT = 1;
    TextView details, appointment, history;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                //signed out
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders((Arrays.asList(
                                        new AuthUI.IdpConfig.GoogleBuilder().build(),
                                        new AuthUI.IdpConfig.EmailBuilder().build()))
                                )
                                .build(), RC_SIGN_OUT);
            }
        };

        details = findViewById(R.id.details);
        details.setOnClickListener(v -> {
            Intent detailsIntent = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(detailsIntent);
        });

        appointment = findViewById(R.id.appointment);
        appointment.setOnClickListener(v -> {
            Intent appointmentIntent = new Intent(MainActivity.this, AppointmentActivity.class);
            startActivity(appointmentIntent);
        });

        history = findViewById(R.id.history);
        history.setOnClickListener(v -> {
            Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(historyIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

}