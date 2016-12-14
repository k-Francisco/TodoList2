package com.example.johncarter.todolist2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.todolist2.R;

/**
 * Created by john carter on 12/14/2016.
 */

public class TodoRecycler extends RecyclerView.Adapter<TodoRecycler.ViewHolder> {


    private String[] mTaskTitle = {
            "I am the great",
            "100kg Challenge",
            "#RoadToHealthyLiving",
            "#RoadToHealthyLiving"
    };

    private String[] mTaskDesc = {
            "Will be going to gym for a fit body and soul",
            "I dont know what im doing with this body",
            "For the love of my life, will do everything without a doubt",
            "For the love of my life, will do everything without a doubt"
    };

    private int mStatus[] = {
            R.drawable.ic_bookmark_upcoming,
            R.drawable.ic_bookmark_upcoming,
            R.drawable.ic_bookmark_24dp,
            R.drawable.ic_bookmark_24dp
    };

    private String[] mTaskDate = {
            "11/23/2016",
            "11/19/2016",
            "11/18/2016",
            "11/18/2016"
    };

    private String[] mTaskTime = {
            "11:13 PM",
            "11:15 AM",
            "12:12 AM",
            "12:12 AM"
    };



// MY FUNCTIONS



// END OF MY FUNCTIONS



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_layout,parent,false);
        TodoRecycler.ViewHolder viewHolder = new TodoRecycler.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.taskTitle.setText(mTaskTitle[position]);
        holder.taskDesc.setText(mTaskDesc[position]);
        holder.taskDate.setText(mTaskDate[position]);
        holder.taskTime.setText(mTaskTime[position]);
        holder.taskStatus.setImageResource(mStatus[position]);

    }

    @Override
    public int getItemCount() {
        return 0;
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
