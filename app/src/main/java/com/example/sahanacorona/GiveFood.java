package com.example.sahanacorona;

import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class GiveFood extends AppCompatActivity implements View.OnClickListener{

    EditText food_ADDRESS, food_DESC;
    Button food_SUBMIT;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_food);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = FirebaseFirestore.getInstance();

        food_ADDRESS = findViewById(R.id.food_Address);
        food_DESC = findViewById(R.id.food_FOOD_DESC);
        food_SUBMIT = findViewById(R.id.food_SUBMIT);

        food_SUBMIT.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(food_ADDRESS.getText().length()==0 ){
            showError(food_ADDRESS);
        }else if(food_DESC.getText().toString().equals("")){
            showError(food_DESC);
        }else {
//        String pickup_address = food_ADDRESS.getText().toString();
//        String food_desc = food_DESC.getText().toString();
//            CollectionReference db_Food_Providers = db.collection("Food_Providers");
//
//            ProvideFoodData provideFoodData = new ProvideFoodData(pickup_address,food_desc,null,"Food");
//
//            db_Food_Providers.add(provideFoodData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                @Override
//                public void onSuccess(DocumentReference documentReference) {
//                    Toast.makeText(GiveFood.this, "Thanks for Providing Info", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(GiveFood.this, "You will be Contacted on registered Phone number", Toast.LENGTH_LONG).show();
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(GiveFood.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });

        }

        }

    private void showError(EditText txt) {
        txt.setError("This feild can't be left empty");
    }
}
