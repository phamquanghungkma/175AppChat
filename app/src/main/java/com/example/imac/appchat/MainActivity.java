package com.example.imac.appchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.engineio.client.Socket;
import com.github.nkzawa.socketio.client.IO;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {


    ListView lvUser , lvChat;
    EditText edtContent;
    ImageButton btnAdd, btnSend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();


//        mSocket.on("server-send-data",onRetrieveData);
//
//        mSocket.emit("client-send-data","Lap tring Android");
        // trong do "client-send-data" la ten cua su kien,
        // Lap trinh Android la noi dung se gui len Server
//

    }

    private void AnhXa() {
        edtContent = (EditText) findViewById(R.id.editTextContent);
        lvChat = (ListView)findViewById(R.id.listviewChat);
        lvUser =(ListView)findViewById(R.id.lisviewUser);
        btnAdd = (ImageButton) findViewById(R.id.imageBtnAdd);
        btnSend = (ImageButton) findViewById(R.id.imageBtnSend);

        //ChatClient.getInstance().regist("ten cua nguoi dung";
    }

    private Emitter.Listener onRetrieveData = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String ten = object.getString("noidung");
                        Toast.makeText(MainActivity.this,ten,Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
}
