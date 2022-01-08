package com.spacECE.spaceceedu.ConsultUS;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.spacECE.spaceceedu.MainActivity;
import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.Utils.Notification;
import com.spacECE.spaceceedu.Utils.UsefulFunctions;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Consultant_AppointmentConfirmation extends AppCompatActivity {

    private TextView BookingId, BookedOn;
    private String bookingId, bookedOn, duration;
    private Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_appointment_confirmation);

        BookingId = findViewById(R.id.Order_ID);
        BookedOn = findViewById(R.id.BookedOn);
        Home = findViewById(R.id.BookingtoHome);

        Intent dataintent = getIntent();

        bookingId = dataintent.getStringExtra("bookingId");
        bookedOn = dataintent.getStringExtra("bookedOn");
        duration = String.valueOf(dataintent.getIntExtra("time", 0));

        Intent intent = new Intent(Consultant_AppointmentConfirmation.this, Notification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Consultant_AppointmentConfirmation.this,
                Integer.parseInt(bookingId), intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        try {
            date = UsefulFunctions.DateFunc.StringToDate(bookedOn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        Log.d("Notification", "sendNotification: "+calendar.getTime());
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis()-1000*60*10, pendingIntent);


        BookingId.setText("Order ID : "+bookingId);
        BookedOn.setText("Booked On "+bookedOn+" for "+duration+" minutes");



        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Consultant_AppointmentConfirmation.this, MainActivity.class));
                finishAffinity();
            }
        });



    }
}