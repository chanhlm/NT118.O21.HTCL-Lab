package com.example.lab3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView view;
    private SinhVienAdapter adapter;
    private List<SinhVien> listSV;
    private Button btnNhap;
    private EditText editid, editname, editLop, editdiemtb;
    DatabaseHandler db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.rycleview);
        editid = findViewById(R.id.id);
        editLop = findViewById(R.id.lop);
        editname = findViewById(R.id.name);
        editdiemtb = findViewById(R.id.diemTB);
        btnNhap = findViewById(R.id.btnNhap);
        db = new DatabaseHandler(this);
        adapter = new SinhVienAdapter();

        // Cập nhật listSV từ cơ sở dữ liệu
        listSV = db.getAllSV();

        adapter.setData(listSV);
        view.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(linearLayoutManager);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                if (editid.getText().toString().isEmpty() || editname.getText().toString().isEmpty() || editLop.getText().toString().isEmpty() || editdiemtb.getText().toString().isEmpty()) {
                    return;
                }
                SinhVien sv = new SinhVien();
                sv.setId((Integer.parseInt(editid.getText().toString())));
                sv.setLopSV(editLop.getText().toString());
                sv.setNameSV(editname.getText().toString());
                sv.setDiemTB(Float.parseFloat(editdiemtb.getText().toString()));
                db.addSV(sv);

                // Thêm vào danh sách listSV và cập nhật RecyclerView
                listSV.add(sv);
                adapter.notifyDataSetChanged();

                // Xóa dữ liệu đã nhập từ EditText
                editid.setText("");
                editname.setText("");
                editLop.setText("");
                editdiemtb.setText("");
            }
        });

    }

}