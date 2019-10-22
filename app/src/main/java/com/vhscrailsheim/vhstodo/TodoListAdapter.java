package com.vhscrailsheim.vhstodo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoItemViewHolder> {

    private ArrayList<TodoItem> mTodoList;

    public static class TodoItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mtextView1;
        public TextView mtextView2;
        public Switch mIsDone;

        public TodoItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mtextView1 = itemView.findViewById(R.id.textView);
            mtextView2 = itemView.findViewById(R.id.textView2);
            mIsDone = itemView.findViewById(R.id.sIsDone);
        }
    }

    public TodoListAdapter(ArrayList<TodoItem> todoList)
    {
        mTodoList = todoList;
    }

    //STRG+i

    @NonNull
    @Override
    public TodoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todo_item, viewGroup, false);
        TodoItemViewHolder todoVh = new TodoItemViewHolder(v);
        return todoVh;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoItemViewHolder todoItemViewHolder, int position) {
        TodoItem currentItem = mTodoList.get(position);

        todoItemViewHolder.mImageView.setImageResource(currentItem.getImageResource());
        todoItemViewHolder.mtextView1.setText(currentItem.getText1());
        todoItemViewHolder.mtextView2.setText(currentItem.getText2());
        todoItemViewHolder.mIsDone.setChecked(currentItem.getIsDone());
    }

    @Override
    public int getItemCount() {
        //Wie viele Einträge sollen angezeigt werden?
        return mTodoList.size();
    }
}
