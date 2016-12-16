package com.example.johncarter.todolist2.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.johncarter.todolist2.R;
import com.example.johncarter.todolist2.TodoModel;
import com.example.johncarter.todolist2.adapters.TodoRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class TodoFragment extends Fragment {

    boolean dualPane;
    int checkPos;
    private ArrayAdapter<TodoModel> listAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<TodoModel>(getActivity(), android.R.layout.simple_dropdown_item_1line, todos));

        View details = getActivity().findViewById(R.id.tits);
        dualPane = details != null && details.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null){
            checkPos = savedInstanceState.getInt("my", 0);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("my", checkPos);
    }

    void showDetails(int index){
        checkPos = index;

        if(dualPane){


        }
//        DetailsFragment d = (DetailsFragment) getFragmentManager().findFragmentById(R.id.tit)
    }

    public TodoFragment() {
    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private static final String TAG = "hello";

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


    public TodoRecycler getRecycler(){
        return (TodoRecycler) adapter;
    }

    public void setListAdapter(ArrayAdapter<TodoModel> listAdapter) {
        this.listAdapter = listAdapter;
    }
}
