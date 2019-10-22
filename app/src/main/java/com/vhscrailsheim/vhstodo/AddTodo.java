package com.vhscrailsheim.vhstodo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddTodo extends AppCompatActivity {

    ImageView todoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        todoImage = findViewById(R.id.imageView3);
    }

    public void AddPhoto(View v)
    {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePicture.resolveActivity(getPackageManager()) != null )
        {
            startActivityForResult(takePicture,1);
        }
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
