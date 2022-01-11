package com.spacECE.spaceceedu.LibForSmall;

import android.content.Intent;
import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.spacECE.spaceceedu.MainActivity;
import com.spacECE.spaceceedu.R;

import java.util.ArrayList;

public class Library_Main extends AppCompatActivity {
    public static ArrayList<Book> list = new ArrayList<>();

    Fragment fragment=new Fragment_LibForSmall_Books();
    public FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.book_framelayout, fragment).commit();

        floatingActionButton=findViewById(R.id.floatingActionBtnBottom);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Library_Main.this,AddBook.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomAppBar);
        bottomNavigationView.setSelectedItemId(R.id.menuBook);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuChat:
                        Intent i=new Intent(Library_Main.this,Chat_Us.class);
                        startActivity(i);

                    case R.id.menuHome:
                        Intent intent=new Intent(Library_Main.this, MainActivity.class);
                        startActivity(intent);
                }
                return  false;
            }
        });

    }
}



