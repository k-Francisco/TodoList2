package com.example.johncarter.todolist2.activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.johncarter.todolist2.R;
import com.example.johncarter.todolist2.fragments.DetailsFragment;

/**
 * Created by dell on 12/16/2016.
 */

public class DetailsAct extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.details_pane);
            return;
        }
        else
            setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            DetailsFragment df = new DetailsFragment();
            df.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, df).commit();

        }

    }
}

