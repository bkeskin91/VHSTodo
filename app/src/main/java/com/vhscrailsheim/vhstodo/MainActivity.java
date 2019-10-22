package com.vhscrailsheim.vhstodo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    //Dieser Adapter stellt die "Brücke" zwischen Layout und Daten dar.
   // private RecyclerView.Adapter mAdapter;
    private TodoListAdapter mAdapter;
    //Dieses Objekt ist verantwortlich für die Darstellung
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<TodoItem> TodoList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TodoList = new ArrayList<>();





        mRecyclerView = findViewById(R.id.todosList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TodoListAdapter(TodoList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new TodoListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onIsDoneClick(int position) {
                TodoList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });


    }

    public void onAddClick(View view)
    {
        Intent intent = new Intent(MainActivity.this,AddTodo.class);

        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String jsonItem = (String) extras.get("NewTodo");
            Gson gson = new Gson();
            TodoItem newTodo = gson.fromJson(jsonItem,TodoItem.class);
            this.TodoList.add(newTodo);
            this.mAdapter.notifyDataSetChanged();
            //Change
        }
    }





}
