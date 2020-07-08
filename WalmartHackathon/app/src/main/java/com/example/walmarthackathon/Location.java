package com.example.walmarthackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Location extends AppCompatActivity {

    Button loca, cont;

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    Button Search, Fence, timerBtn;
    EditText address;
  //  private GeofencingClient geofencingClient;
   // private com.example.internshiptaskapp.GeofenceHelper geofenceHelper;
    public static double latitudeCurrent,longitudeCurrent,la, lo;
    public static float radius = 100;///////////////////////////////////////////////////////////////////////
    private String Geofence_ID = "newlol";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        loca= findViewById((R.id.loc));
        cont= findViewById((R.id.cona));

        Search = findViewById(R.id.btn1);
      //  address = findViewById(R.id.enterAddress);
      //  Fence = findViewById(R.id.btn2);
      //  timerBtn = findViewById(R.id.btn3);

       // geofencingClient = LocationServices.getGeofencingClient(this);
       // geofenceHelper = new com.example.internshiptaskapp.GeofenceHelper(this);
      //  la = com.example.internshiptaskapp.GeocodingLocation.latUser;
      //  lo = com.example.internshiptaskapp.GeocodingLocation.lonUser;


        loca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(getApplicationContext(),Description.class));
                Toast.makeText(getApplicationContext(),"Location Obtained!",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Geofence added to nearest store!",Toast.LENGTH_SHORT).show();




            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }


    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;

            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    //  Log.d("latttt",locationAddress);
                    break;
                default:
                    locationAddress = null;
            }
            //  textView.setText(locationAddress);
        }
    }

    //For address
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
               // getCurrentLocation();
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }




   /* private void addGeofence( double la,double lo, float radius){
        Geofence geofence = geofenceHelper.getGeofence(Geofence_ID, la,lo, radius,Geofence.GEOFENCE_TRANSITION_DWELL  | Geofence.GEOFENCE_TRANSITION_ENTER );
        GeofencingRequest geofencingRequest = geofenceHelper.getGeofencingRequest(geofence);
        AlarmManager alarmManager;
        alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = geofenceHelper.getPendingIntent();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),10000, pendingIntent);
        geofencingClient.addGeofences(geofencingRequest,pendingIntent)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("Geofence " + com.example.internshiptaskapp.GeocodingLocation.latUser);
                        System.out.println("Geofence " + com.example.internshiptaskapp.GeocodingLocation.lonUser);
                        Log.d(TAG, "onSuccess: Geofence Added...");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String errorMessage = geofenceHelper.getErrorString(e);
                        Log.d(TAG, "onFailure: " +errorMessage);

                    }
                });
    }*/
}
