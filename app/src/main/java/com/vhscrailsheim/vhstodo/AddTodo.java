package com.vhscrailsheim.vhstodo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;

public class AddTodo extends AppCompatActivity {

    ImageView todoImage;
    EditText title;
    EditText desciption;
    Button speichern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        todoImage = findViewById(R.id.imageView3);
        title = findViewById(R.id.txtTitle);
        desciption = findViewById(R.id.txtDescription);
        speichern = findViewById(R.id.btnSave);

        speichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap image = ((BitmapDrawable)todoImage.getDrawable()).getBitmap();
                String textTitle = title.getText().toString();
                String textDescription = desciption.getText().toString();
                TodoItem newItem = new TodoItem(image,textTitle,textDescription,false);
                //TodoService.Service.addNoteToList(newItem);
                Gson gson = new Gson();
                String transferierbaresObjekt = gson.toJson(newItem);

                Intent resultIntent = new Intent();

                resultIntent.putExtra("NewTodo",transferierbaresObjekt);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }

    public void AddPhoto(View v)
    {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePicture.resolveActivity(getPackageManager()) != null )
        {
            startActivityForResult(takePicture,1);
        }
    }

    public void saveTodo(View v)
    {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
       // super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            todoImage.setImageBitmap(imageBitmap);
        }
    }


}
