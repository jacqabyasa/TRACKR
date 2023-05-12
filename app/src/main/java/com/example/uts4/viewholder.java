package com.example.uts4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder {

    private TextView textViewTodo;

    public viewholder(@NonNull View itemView) {
        super(itemView);
        textViewTodo = itemView.findViewById(R.id.textViewTodo);
    }

    public void bind(String todo) {
        textViewTodo.setText(todo);
    }
}