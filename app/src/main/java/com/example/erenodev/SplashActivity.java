package com.example.erenodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    public boolean internet(final Context context){
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (internet(this)) {
            Thread splashThread;
            splashThread = new Thread(){
                @Override public void run() {
                    try {
                        synchronized (this){
                            wait(1000);
                        }
                    }
                    catch (InterruptedException ex){

                    }
                    finally {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                    }
                }
            };
            splashThread.start();
        }
        else {
            Toast.makeText(this, "Error: Lütfen İnternet Bağlantınızı Kontrol Ediniz...", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}