package com.example.johncarter.todolist2.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.johncarter.todolist2.R;
import com.example.johncarter.todolist2.TodoModel;

import java.util.Calendar;

public class CreateTask extends AppCompatActivity implements View.OnClickListener{

    private EditText mTitle, mDesc, mDate, mTime;
    private String title, desc;
    private Button mSetDate, mSetTime, mAddToDoList;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private DatePicker datepicker;
    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = month;
            mDay = dayOfMonth;

            mDate.setText(new StringBuilder().append(mDay).append("/")
                    .append(mMonth+1).append("/").append(mYear));

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        init();

    }

    private void init() {
        mTitle = (EditText) findViewById(R.id.create_title);
        mDesc = (EditText) findViewById(R.id.create_desc);
        mDate = (EditText) findViewById(R.id.create_date);
        mTime = (EditText) findViewById(R.id.create_time);

        mSetDate = (Button) findViewById(R.id.set_date);
        mSetTime = (Button) findViewById(R.id.set_time);
        mAddToDoList = (Button) findViewById(R.id.submit);


            calendar = Calendar.getInstance();
            mYear = calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);
            mHour = calendar.get(Calendar.HOUR_OF_DAY);
            mMinute = calendar.get(Calendar.MINUTE);

        mDate.setText(new StringBuilder().append(mDay).append("/")
                .append(mMonth+1).append("/").append(mYear));

        mTime.setText(mHour + " : " + mMinute);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.set_date:
                showDialog(999);
                break;

            case R.id.set_time:
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mHour = hourOfDay;
                        mMinute = minute;
                        mTime.setText(mHour + " : " + mMinute);
                    }
                }, mHour, mMinute, false);
                timePickerDialog.show();
                break;

            case R.id.submit:
                title = mTitle.getText().toString();
                desc = mDesc.getText().toString();
                TodoModel todoModel = new TodoModel(title, desc, mDay, mMonth, mYear, mHour, mMinute);
                break;

        }
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, mYear, mMonth, mDay);
        }
        return null;
    }

}
