package com.example.sahanacorona;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MarkPeoples extends AppCompatActivity implements View.OnClickListener{

    Button mark_people_SUBMIT;
    EditText mark_people_AREADESC, mark_people_AREAMARK, mark_people_NOPEOPLE ;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_peoples);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = FirebaseFirestore.getInstance();

        mark_people_SUBMIT = findViewById(R.id.mark_people_SUBMIT);

        mark_people_AREADESC =findViewById(R.id.mark_people_AREADESC);

        mark_people_AREAMARK = findViewById(R.id.mark_people_AREAMARK);

        mark_people_NOPEOPLE = findViewById(R.id.mark_people_NOPEOPLE);

        mark_people_SUBMIT.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            //SUBMIT BUTTON
            case R.id.mark_people_SUBMIT:
                    String area_dsc = mark_people_AREADESC.getText().toString();
                    String  area_mark = mark_people_AREAMARK.getText().toString();
                    String no_of_people = mark_people_NOPEOPLE.getText().toString();

                CollectionReference db_mark_people = db.collection("MarkPeople");

                MarkPeopleData markPeopleData = new MarkPeopleData(area_dsc,area_mark,no_of_people,null);

                db_mark_people.add(markPeopleData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MarkPeoples.this, "Thanks for Providing Info", Toast.LENGTH_LONG).show();
                        Toast.makeText(MarkPeoples.this, "You will be Contacted on registered Phone number", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MarkPeoples.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

                break;
        }
    }
}