package com.example.ashra.assignmentgraphicaluserinterface;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Date;

public class RowRecordCollections {
    public RowRecord [] recordCollection;
    private int SIZE = 10;
    RowRecordCollections(TableLayout tl, Context c)
    {
        recordCollection = new RowRecord[SIZE];

        for (int i = 0; i < recordCollection.length; i++) {
            recordCollection[i] = new RowRecord(c);
            recordCollection[i].setId(i + 1);
        }

        for (int i = 2; i < SIZE+2; i++) {
            TableRow row= new TableRow(c);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            row.addView(recordCollection[i-2].idTextView,0);
            row.addView(recordCollection[i-2].choosenDateTextView,1);
            row.addView(recordCollection[i-2].countdownButtons, 2);
            row.addView(recordCollection[i-2].countDownTextView,3);
            tl.addView(row,i);
        }

    }

}
