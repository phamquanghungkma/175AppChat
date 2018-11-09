package com.example.imac.appchat;

import android.util.Log;
import android.view.View;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class ChatClient  {

    private static ChatClient instance;

    public static ChatClient getInstance(){
        if(instance == null)
            instance = new ChatClient();
        return instance;
    }


    public Socket mSocket;

    private ChatClient(){

        try {
            mSocket = IO.socket("http://192.168.2.3:3001");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mSocket.connect();
    }
    public void register(String name){

        mSocket.emit("client-register-user",name);
    }



}
