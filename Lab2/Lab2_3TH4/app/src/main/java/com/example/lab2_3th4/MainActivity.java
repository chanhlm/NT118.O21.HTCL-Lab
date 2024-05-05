package com.example.lab2_3th4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editId,editName;
    Button btnNhap;
    RadioGroup radgroup;
    ListView lvNhanvien;
    ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
    ArrayAdapter<Employee> adapter=null;
    Employee employee=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText) findViewById(R.id.editMa);
        editName = (EditText) findViewById(R.id.editTen);
        btnNhap = (Button) findViewById(R.id.btnnhap);
        radgroup = (RadioGroup) findViewById(R.id.radiogroud1);
        lvNhanvien = (ListView) findViewById(R.id.lvnhanvien);
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvNhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (editId.getText().toString().equals("") || editName.getText().toString().equals("")) {
                    //Kiểm tra thông tin nhân viên đã nhập đầy đủ chưa
                    //Nếu chưa nhập đầy đủ thì thông báo
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    //Nếu đã nhập đầy đủ thông tin thì gọi hàm xử lý nhập thông tin
                    processNhap();
                }
            }
        });
    }
    public void processNhap()
    {
        //Lấy ra đúng id của Radio Button được checked
        int radId=radgroup.getCheckedRadioButtonId();
        String id=editId.getText()+"";
        String name=editName.getText()+"";
        if(radId==R.id.radChinhthuc) {
            //tạo instance là FullTime
            employee=new EmployeeFullTime();
        }
        else {
            //Tạo instance là Partime
            employee=new EmployeePartTime();
        }
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        arrEmployee.add(employee);
        adapter.notifyDataSetChanged();

        // Xoá dữ liệu từ EditText
        editId.setText("");
        editName.setText("");
    }
}