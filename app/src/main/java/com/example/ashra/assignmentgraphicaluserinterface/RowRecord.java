package com.example.ashra.assignmentgraphicaluserinterface;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class RowRecord extends AppCompatActivity {//implements DatePickerDialog.OnDateSetListener {
    private int id = 0;
    private Calendar selectedDate = Calendar.getInstance();
    public ImageButton countdownButtons;
    private int countDown;
    Calendar myCalendar = Calendar.getInstance();

    public TextView idTextView;
    public TextView choosenDateTextView;
    public TextView countDownTextView;

    DatePickerDialog.OnDateSetListener date;


    RowRecord(final Context c) {

        countdownButtons = new ImageButton(c);
        countDown = 0;
        idTextView = new TextView(c);
        choosenDateTextView = new TextView(c);
        countDownTextView = new TextView(c);

        countdownButtons.setImageResource(R.drawable.calendaricon);

        idTextView.setText(Integer.toString(id));
        choosenDateTextView.setText("Select Date");
        countDownTextView.setText(Integer.toString(countDown));
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel( year,  monthOfYear,  dayOfMonth);
            }
        };
        countdownButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogFragment datePicker = new DatePickerFragment();
//                datePicker.
//                datePicker.show(getSupportFragmentManager(), "date picker");
                new DatePickerDialog(c, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
    }

    private void updateLabel(int year, int month, int dayOfMonth) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        choosenDateTextView.setText(sdf.format(myCalendar.getTime()));

        //String date = (month + 1)+ "/" + dayOfMonth + "/" + year;
        //myDate.setText(date);
        selectedDate.set(year,month,dayOfMonth);
        //start.setTime(start.getTime());
        Calendar start = Calendar.getInstance();
        Date startDate = start.getTime();
        Date endDate = selectedDate.getTime();

        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);

        start.add(Calendar.DAY_OF_MONTH, (int)diffDays);
        while (start.before(selectedDate)) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            diffDays++;
        }
        while (start.after(selectedDate)) {
            start.add(Calendar.DAY_OF_MONTH, -1);
            diffDays--;
        }
        diffDays++;
        countDownTextView.setText(Long.toString(diffDays) );
    }


    public void setId(int _id) {
        id = _id;
        idTextView.setText(Integer.toString(id));
    }

}
