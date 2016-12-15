package com.example.johncarter.todolist2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.todolist2.R;
import com.example.johncarter.todolist2.adapters.TodoRecycler;

/**
 * Created by dell on 12/16/2016.
 */

public class DetailsFragment extends Fragment{

    public DetailsFragment(){

    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TodoRecycler();
        recyclerView.setAdapter(adapter);
        return view;
    }
}
