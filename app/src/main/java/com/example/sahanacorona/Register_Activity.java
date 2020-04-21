package com.example.sahanacorona;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class Register_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    FirebaseFirestore db;

    private EditText name;
    private EditText mPhoneNumber;
    private EditText address;
    private EditText address_landmark;
    private EditText password;
    // private RadioGroup gender;

    private Button register;
    private ProgressBar mLoginProgress;

    private TextView mLoginFeedbackText;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        name = findViewById(R.id.register_name);
        address = findViewById(R.id.register_ADDRESS);
        address_landmark = findViewById(R.id.register_ADDRESS_LANDMARK);
        mPhoneNumber = findViewById(R.id.register_phone);
        password = findViewById(R.id.register_PASSWORD);
        //radio button val to be addded
        mLoginProgress = findViewById(R.id.progressBar2);
        mLoginProgress.setVisibility(View.INVISIBLE);

        register = findViewById(R.id.register_submit);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_val = name.getText().toString();
                String address_val = address.getText().toString();
                String address_landmark_val = address_landmark.getText().toString();
                String mphone_val = mPhoneNumber.getText().toString();
                String password_val = password.getText().toString();
                //String name_val = name.getText().toString();


                String complete_phone_number = "+" + "91" + mphone_val;

                if (mphone_val.isEmpty() || mphone_val.length() < 10
                        || name.getText().toString().trim()== ""
                        || address.getText().toString().trim()==""
                        || address_landmark.getText().toString().trim()==""
                        || mPhoneNumber.getText().toString().trim()==""
                        || password.getText().toString().trim()=="") {
                                Toast.makeText(Register_Activity.this,"Please fill in all fields",Toast.LENGTH_SHORT).show();
                                mLoginFeedbackText.setVisibility(View.VISIBLE);
                } else {
                    mLoginProgress.setVisibility(View.VISIBLE);
                    register.setEnabled(false);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            complete_phone_number,
                            60,
                            TimeUnit.SECONDS,
                            Register_Activity.this,
                            mCallbacks
                    );

                }

            }
        });


        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                name.setText("Verification Failed, please try again.");
                name.setVisibility(View.VISIBLE);
                mLoginProgress.setVisibility(View.INVISIBLE);
                register.setEnabled(true);
            }

            @Override
            public void onCodeSent(final String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                Intent otpIntent = new Intent(Register_Activity.this, Main2Activity.class);
                                otpIntent.putExtra("AuthCredentials", s);
                                startActivity(otpIntent);
                            }
                        },
                        10000);
            }
        };


    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Register_Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            sendUserToHome();
                            // ...
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                name.setVisibility(View.VISIBLE);
                                name.setText("There was an error verifying OTP");
                            }
                        }
                        mLoginProgress.setVisibility(View.INVISIBLE);
                        register.setEnabled(true);
                    }
                });
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mCurrentUser != null) {
            sendUserToHome();
        }
    }

    public void sendUserToHome() {

//        String uid_str =  mCurrentUser.getUid();
//        mAuth.getCurrentUser().getUid()
        Log.i("Register_Activity"," on if (mAuth.getCurrentUser() != null)");
        if (mAuth.getCurrentUser() != null) {
            String uid_str = mAuth.getCurrentUser().getUid();


            Profiledata user_profile_data = new Profiledata("test", "test", uid_str, "test", "test", "test","test_password");

            Log.i("Register_Activity"," on db.collection");
            db.collection("profile").document(uid_str).set(user_profile_data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Register_Activity.this, "Your Profile Has Been Saveed", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register_Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
            );


            Log.i("Register_Activity"," on Intent");
            Intent homeIntent = new Intent(Register_Activity.this, Home.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(homeIntent);
            finish();
        }
    }
}