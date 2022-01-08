package com.spacECE.spaceceedu.LibForSmall;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.spacECE.spaceceedu.R;

import java.util.ArrayList;

public class Library_Main extends AppCompatActivity {
    public static ArrayList<Book> list = new ArrayList<>();

    Fragment fragment=new Fragment_LibForSmall_Books();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.book_framelayout, fragment).commit();
    }
}



