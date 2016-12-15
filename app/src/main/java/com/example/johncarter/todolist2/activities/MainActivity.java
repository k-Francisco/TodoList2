package com.example.johncarter.todolist2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;

import com.example.johncarter.todolist2.R;
import com.example.johncarter.todolist2.TodoModel;
import com.example.johncarter.todolist2.fragments.TodoFragment;


public class MainActivity extends AppCompatActivity {


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TabLayout taskTypeTab;
    TodoFragment todoFragment = new TodoFragment();
    private ArrayList<TodoModel> todos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CreateTask.class);
                startActivityForResult(intent, 1);
            }
        });



        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, todoFragment);
        fragmentTransaction.commit();

        taskTypeTab = (TabLayout) findViewById(R.id.tasktype_tab);
        taskTypeTab.addTab(taskTypeTab.newTab().setText("To Do"));
        taskTypeTab.addTab(taskTypeTab.newTab().setText("Finished"));
        taskTypeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String title = data.getStringExtra("title");
                String desc = data.getStringExtra("desc");
                String mDay = data.getStringExtra("day");
                String mMonth = data.getStringExtra("month");
                String mYear = data.getStringExtra("year");
                String mHour = data.getStringExtra("hour");
                String mMinute = data.getStringExtra("minute");

                TodoModel todoModel = new TodoModel(title, desc, Integer.parseInt(mDay), Integer.parseInt(mMonth),
                        Integer.parseInt(mYear), Integer.parseInt(mHour), Integer.parseInt(mMinute));
                todos.add(todoModel);
                todoFragment.setTodos(todos);
                todoFragment.getRecycler().add(todoModel);
            }
        }
    }
}
