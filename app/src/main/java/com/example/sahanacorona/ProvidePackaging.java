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

import com.google.firebase.firestore.FirebaseFirestore;

public class ProvidePackaging extends AppCompatActivity implements View.OnClickListener{
    EditText packaging_material, packaging_address;
    Button packaging_submit;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_packaging);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = FirebaseFirestore.getInstance();

        packaging_material = findViewById(R.id.packaging_details);

        packaging_address =findViewById(R.id.packaging_address);

        packaging_submit = findViewById(R.id.packaging_SUBMIT);

        packaging_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(packaging_material.getText().length()==0){
            packaging_material.setError("This Field Can't be Left Empty");
        }else if(packaging_address.getText().length()==0){
            packaging_address.setError("This field Can't be Left Empty");
        }else{
//            String packaging_detail = packaging_material.getText().toString();
//            String package_address = packaging_address.getText().toString();
//
//            CollectionReference db_Food_Providers = db.collection("Food_Providers");
//
//            ProvideFoodData packageData = new ProvideFoodData(packaging_detail,package_address,null,"Packing Material");
//
//            db_Food_Providers.add(packageData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                @Override
//                public void onSuccess(DocumentReference documentReference) {
//                    Toast.makeText(ProvidePackaging.this, "Thanks for Providing Info", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(ProvidePackaging.this, "You will be Contacted on registered Phone number", Toast.LENGTH_LONG).show();
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(ProvidePackaging.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
        }
    }
}
