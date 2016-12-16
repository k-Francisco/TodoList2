package com.example.johncarter.todolist2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johncarter.todolist2.R;
import com.example.johncarter.todolist2.TodoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john carter on 12/14/2016.
 */

public class TodoRecycler extends RecyclerView.Adapter<TodoRecycler.ViewHolder> {

    ArrayList<TodoModel> todoModelList = new ArrayList<>();


    public void add(TodoModel todoModel){
        if(todoModelList != null) {
            todoModelList.add(todoModel);
            notifyDataSetChanged();
        }
        else
            todoModelList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_layout,parent,false);
        TodoRecycler.ViewHolder viewHolder = new TodoRecycler.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.taskTitle.setText(todoModelList.get(position).getTitle());
        holder.taskDesc.setText(todoModelList.get(position).getDescription());
        holder.taskDate.setText(String.valueOf(todoModelList.get(position).getDay()) + "/" + String.valueOf(todoModelList.get(position).getMonth())
                + "/" + String.valueOf(todoModelList.get(position).getYear()));
        holder.taskTime.setText(String.valueOf(todoModelList.get(position).getHour()) + ":" + String.valueOf(todoModelList.get(position).getMinutes()));
//        holder.taskStatus.setImageResource(mStatus[position]);

    }

    @Override
    public int getItemCount() {
        return todoModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView taskTitle, taskDesc, taskDate, taskTime;
        private ImageView taskStatus;

        public ViewHolder(View itemView) {
            super(itemView);

            taskTitle = (TextView) itemView.findViewById(R.id.task_title);
            taskDesc = (TextView) itemView.findViewById(R.id.task_desc);
            taskDate = (TextView) itemView.findViewById(R.id.todo_date);
            taskTime = (TextView) itemView.findViewById(R.id.todo_time);
            taskStatus = (ImageView) itemView.findViewById(R.id.task_status);

        }
    }
}
