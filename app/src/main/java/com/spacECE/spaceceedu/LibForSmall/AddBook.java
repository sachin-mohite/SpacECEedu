package com.spacECE.spaceceedu.LibForSmall;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.spacECE.spaceceedu.R;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class AddBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
    }

    public void addBook(String name, String author,String edition,String description,String category,String price){
        String addbook="";

        new Thread(new Runnable() {

            JSONObject jsonObject;
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                RequestBody fromBody = new FormBody.Builder()
                        .add("name",name)
                        .add("author",author)
                        .add("edition",edition)
                        .add("description",description)
                        .add("category",category)
                        .add("price",price)
                        .add("isAPI","true")
                        .build();

                Request request = new Request.Builder()
                        .url(addbook)
                        .post(fromBody)
                        .build();

                Call call = client.newCall(request);
            }
        });
    }
}