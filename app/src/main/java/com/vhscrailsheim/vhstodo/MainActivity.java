package com.vhscrailsheim.vhstodo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    //Dieser Adapter stellt die "Brücke" zwischen Layout und Daten dar.
    private RecyclerView.Adapter mAdapter;
    //Dieses Objekt ist verantwortlich für die Darstellung
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Integer> jahresZahlen = new ArrayList<>();

        ArrayList<TodoItem> unerledigt = new ArrayList<>();

        unerledigt.add(new TodoItem(R.drawable.ic_android_black, "VHS Kurs", "Kurs um 18:30 Uhr besuchen.", false));
        unerledigt.add(new TodoItem(R.drawable.ic_call_black, "Business Call", "Geschäftspartner anrufen.", false));

        ArrayList<TodoItem> erledigt = new ArrayList<>();
        erledigt.add(new TodoItem(R.drawable.ic_cake_black, "Kuchen backen", "Kuchen für Familienbesuch backen.", true));


        mRecyclerView = findViewById(R.id.todosList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TodoListAdapter(unerledigt);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

    public void onAddClick(View view)
    {
        Intent intent = new Intent(MainActivity.this,AddTodo.class);

        startActivity(intent);
    }



}
