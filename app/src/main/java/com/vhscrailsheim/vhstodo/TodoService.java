package com.vhscrailsheim.vhstodo;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class TodoService {

     public static class  Service {
         public static ArrayList<TodoItem> TodoList = new ArrayList<>();

         public static void deleteNoteFromList(TodoItem toDelete) {
             TodoList.remove(toDelete);
         }

         public static void addNoteToList(TodoItem toAdd) {
             TodoList.add(toAdd);
         }

         public static void populateList()
         {/*
             TodoList.add(new TodoItem(R.drawable.ic_android_black, "VHS Kurs", "Kurs um 18:30 Uhr besuchen.", false));
             TodoList.add(new TodoItem(R.drawable.ic_call_black, "Business Call", "Geschäftspartner anrufen.", false));
             TodoList.add(new TodoItem(R.drawable.ic_cake_black, "Kuchen backen", "Kuchen für Familienbesuch backen.", true));
             */
         }

     }
}
