package com.example.ashra.assignmentgraphicaluserinterface;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {//implements DatePickerDialog.OnDateSetListener {

    private static final String FILE_NAME = "database.txt";


    CalendarView calendarView;
    TextView choosenDate1;
    String date;
    Button loadButt;
    DatePickerDialog.OnDateSetListener dateListener1,dateListener2;

    RowRecordCollections rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendarDateNow = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendarDateNow.getTime());

        TextView text_view_date = findViewById(R.id.text_view_date);
        text_view_date.setText(currentDate);

        rc = new RowRecordCollections((TableLayout) findViewById(R.id.TableCount), this);
        rc.load(this);
        Button saveDate = findViewById(R.id.saveDate);
        saveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rc.save(v.getContext());
            }
        });

//        calendarView = (CalendarView) findViewById(R.id.markDate1);
//        choosenDate1 = (TextView) findViewById(R.id.choosenDate1);
//        loadButt = (Button) findViewById(R.id.load);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                date = (month + 1) + "/" + dayOfMonth + "/" + year;
//                choosenDate1.setText(date);
//            }
//        });
//
//        loadButt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                load(v);
//            }
//        });

    }


    public void save1(View v) {


    }

/*

    public void load(View v) {
        // FileInputStream fis = null;

        try {
            // fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(getAssets().open(FILE_NAME), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

           // choosenDate1.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
