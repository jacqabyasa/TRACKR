package com.example.uts4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {

    private List<String> todoList;

    public adapter(List<String> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        String todo = todoList.get(position);
        holder.bind(todo);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

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
}