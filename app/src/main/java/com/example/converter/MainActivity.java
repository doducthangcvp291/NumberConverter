package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_from , spinner_to ;
    EditText input ;
    TextView output ;
    ArrayList<String> arraylist_from ;
    ArrayList<String> arraylist_to ;
    ArrayAdapter<String> arrayAdapter_from ;
    ArrayAdapter<String> arrayAdapter_to ;
    int i2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_from = (Spinner) findViewById(R.id.spinner_from);
        spinner_to = (Spinner) findViewById(R.id.spinner_to);
        arraylist_from = new ArrayList<>() ;
        arraylist_from.add("Hệ 10");
        arraylist_from.add("Hệ 2");
        arraylist_from.add("Hệ 8");
        arraylist_from.add("Hệ 16");

        arrayAdapter_from = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arraylist_from);
        spinner_from.setAdapter(arrayAdapter_from);
        spinner_to.setAdapter(arrayAdapter_from);
        input = (EditText) findViewById(R.id.editTextInput);
        output = (TextView) findViewById(R.id.textView);

        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(input.getText().toString().isEmpty()){
                    input.setError("Bạn cần nhập số vào");
                    return ;
                } else
                    {
                    String i = input.getText().toString() ;

                    if (position == 0) {
                        i2 = Integer.parseInt(i);
                        //arrayAdapter_to = new ArrayAdapter<>(getApplicationContext(), R.layout.sp_item, arraylist_to);
                    }
                    if (position == 1) {
                        i2 = Integer.parseInt(i,2);
                        //arrayAdapter_to = new ArrayAdapter<>(getApplicationContext(), R.layout.sp_item, arraylist_to);

                    }
                    if (position == 2) {
                        i2 = Integer.parseInt(i,8);
                        //arrayAdapter_to = new ArrayAdapter<>(getApplicationContext(), R.layout.sp_item, arraylist_to);

                    }
                    if (position == 3) {
                        i2 = Integer.parseInt(i,16);
                        //arrayAdapter_to = new ArrayAdapter<>(getApplicationContext(), R.layout.sp_item, arraylist_to);

                    }
                    //output.setText(i2);
                    //System.out.println(i2);
                    return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String i = input.getText().toString() ;
                i2 = Integer.parseInt(i);
            }
        });

        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    output.setText(Integer.toString(i2));
                }
                String i3 ="" ;

                if (position == 1) {
                    i3 = Integer.toBinaryString(i2);
                }

                if (position == 2) {
                    i3 = Integer.toOctalString(i2);
                }

                if (position == 3) {
                    i3 = Integer.toHexString(i2);
                }

                output.setText(i3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                output.setText(Integer.toString(i2));
            }
        });
    }
}