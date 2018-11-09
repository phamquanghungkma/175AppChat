package com.example.imac.appchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DangNhap extends AppCompatActivity {
    Button btnDK,btnDN;
    EditText edtDK,edtDN;
//    Bundle bundle;
    String DN, DK;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);



        btnDK = (Button)findViewById(R.id.btnDK);
        btnDN = (Button)findViewById(R.id.btnDN);
        edtDK = (EditText) findViewById(R.id.edtDangky);
        edtDN =(EditText)findViewById(R.id.edtDangNhap);
        //anh xa
        //get text
        //new 1 bundle truyen vao 2 goi la 2 text dn,dk
        //bat su kien 2 nut
        //day bundle
        //done




        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gui text DN
                Intent intent = new Intent(DangNhap.this,MainActivity.class);
                Bundle bundle = new Bundle();
                DN = edtDN.getText().toString();


                startActivity(intent);
            }
        });
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gui text DK
                Intent intent2 = new Intent(DangNhap.this,MainActivity.class);
                Bundle bundle2 = new Bundle();
                DK = edtDK.getText().toString();
                bundle2.putString("DangKy",DK);

                ChatClient.getInstance().register(DK);
                edtDK.setText("");

                startActivity(intent2);
            }
        });












    }
}
