package com.example.ashra.assignmentgraphicaluserinterface;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

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
    // the  save and load
    private static final String FILE_NAME = "database.txt";

/*    public void save1(View v) {

    }*/

    public void save (Context c){
        FileOutputStream fos = null;

        try {
            //InputStreamReader isr = new InputStreamReader(c.getAssets().open(FILE_NAME), "UTF-8");
            //OutputStreamWriter osw = new OutputStreamWriter(,"UTF-8");
            fos = c.openFileOutput(FILE_NAME, MODE_PRIVATE);
            //ObjectOutputStream oos = new ObjectOutputStream(fos);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (RowRecord row:
                 recordCollection) {
                if (row.isSet)
                {
                    bw.write(Integer.toString(row.id));
                    String myFormat = " MM dd yyyy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

                    bw.write(sdf.format(row.selectedDate.getTime()));
                    Log.d("DEBUG", "save: "+row.id+sdf.format(row.selectedDate.getTime()));
                    bw.write("\n");
                    // oos.write(date.day, month, year)
                }
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void load(Context c) {
         FileInputStream fis = null;

        try {
             fis = c.openFileInput(FILE_NAME);
           InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String text;

            while ((text = br.readLine()) != null) {
                //sb.append(text).append("\n");
                Log.d("Debug", "load: " + text);
                String[] testSpilt = text.split(" ");

                int id = Integer.parseInt(testSpilt[0]);
                int month = Integer.parseInt(testSpilt[1]);
                int day = Integer.parseInt(testSpilt[2]);
                int year = Integer.parseInt(testSpilt[3]);

                recordCollection[id-1].updateLabel(year,month-1,day);
            }

            // choosenDate1.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
