package com.example.sahanacorona;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ShowData extends AppCompatActivity {
    //SearchView searchView;
    RecyclerView recyclerView;

    ArrayList<ProvideFoodData> data_list  =new ArrayList<>();

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = FirebaseFirestore.getInstance();

        data_list.add(new ProvideFoodData("Food","abc block 123 shastri nagar","1Kg Rice, 1 Kg Lentis",null,"","",""," http://maps.google.com/maps?q=28.58959281,77.04838944","26-02-2020"));
        data_list.add(new ProvideFoodData("Food","abc block 123 Pratap nagar","1Kg Rice, 1 Kg Spices",null,"","",""," http://maps.google.com/maps?q=28.58959281,77.04838944","26-02-2020"));
        data_list.add(new ProvideFoodData("Food","abc block 123 shastri nagar","1Kg Rice, 1 Kg Salt",null,"","",""," http://maps.google.com/maps?q=28.58959281,77.04838944","26-02-2020"));
        //searchView = findViewById(R.id.show_data_SEARCHVIEW);

        recyclerView = findViewById(R.id.show_data_recyclr);

        //data_list.add(new ProvideFoodData("yjjvj","vchchjcjhcj",null,"fyucyfv"));

        final ShowDataAdapter showDataAdapter = new ShowDataAdapter(data_list);

        recyclerView.setAdapter(showDataAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });

//        db.collection("Food_Providers").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if(!queryDocumentSnapshots.isEmpty()){
//                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//
//                    for(DocumentSnapshot d : list){
//                        ProvideFoodData data = d.toObject(ProvideFoodData.class);
//
//                        data_list.add(data);
//                    }
//
//                    showDataAdapter.notifyDataSetChanged();
//                }
//            }
//        });
    }

}
