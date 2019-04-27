package com.sir.chat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isNetworkAvailable()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new chat_page()).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new internet_check()).commit();
        }

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void abc(View view) {
        if(!isNetworkAvailable())
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new internet_check()).commit();

    }


}
