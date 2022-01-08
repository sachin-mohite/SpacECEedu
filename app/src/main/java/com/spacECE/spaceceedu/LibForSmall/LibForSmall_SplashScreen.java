package com.spacECE.spaceceedu.LibForSmall;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.Utils.UsefulFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class LibForSmall_SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        LoadList();
    }

    void LoadList() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final JSONObject apiCall;
                try{
                    apiCall = UsefulFunctions.UsingGetAPI("http://spacefoundation.in/test/SpacECE-PHP/Khanstore/allproductlist.php");
                    JSONArray jsonArray = null;
                    try {
                        try {
                            assert apiCall != null;
                        } catch (AssertionError e) {

                            e.printStackTrace();

                            runOnUiThread(() -> {
                                new AlertDialog.Builder(LibForSmall_SplashScreen.this)
                                        .setTitle("Internet Not Working!")
                                        .setMessage("Do you want to retry ?")

                                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                LoadList();
                                            }
                                        })

                                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(LibForSmall_SplashScreen.this, Library_Main.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        })

                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                            });

                        }
                        jsonArray = apiCall.getJSONArray("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Library_Main.list = new ArrayList<>();
                    try {
                        Log.d("TAG", "run: "+jsonArray.length());
                        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
                            JSONObject response_element = new JSONObject(String.valueOf(jsonArray.getJSONObject(i)));
                             Book temp = new Book(response_element.getString("product_id"), response_element.getString("product_title"),
                                    response_element.getString("product_price"), response_element.getString("product_keywords"),
                                    response_element.getString("product_image"));
                             Library_Main.list.add(temp);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent(LibForSmall_SplashScreen.this, Library_Main.class);
                    startActivity(intent);
                    finish();

                } catch ( Exception e) {
                    Log.i("EXCEPTION", e.toString());
                }
            }
        });

        thread.start();
    }
}