package com.example.lab2_2th3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName;

    TextView txtSelected;
    Button btnSubmit;
    ListView lvPerson;
    ArrayList<String> arrNames;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        btnSubmit = findViewById(R.id.btnAdd);
        txtSelected = findViewById(R.id.txtselection);

        lvPerson = findViewById(R.id.lvperson);
        arrNames = new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrNames);

        lvPerson.setAdapter(adapter);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText()+"";
                if (!name.equals("")){
                    arrNames.add(name);
                    edtName.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtSelected.setText("Position: "+position+" - Value: " + arrNames.get(position));
                for (int i = 0; i < parent.getChildCount(); i++) {
                    if(position == i ){
                        parent.getChildAt(i).setBackgroundColor(Color.BLUE);
                    }else{
                        parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        });

        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrNames.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}