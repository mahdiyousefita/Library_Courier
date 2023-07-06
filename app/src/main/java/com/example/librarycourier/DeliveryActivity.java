package com.example.librarycourier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.librarycourier.items.RequestedBook;
import com.google.android.material.button.MaterialButton;

public class DeliveryActivity extends AppCompatActivity {

    public static String INTENT_KEY = "requestedBook";

    private TextView tvStartLoc, tvGoalLoc, tvUser;
    private Button btnDeliver;
    private MaterialButton btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Bundle extras = getIntent().getExtras();
        RequestedBook requestedBook;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            requestedBook = extras.getParcelable(INTENT_KEY, RequestedBook.class);
        }else {
            requestedBook = extras.getParcelable(INTENT_KEY);
        }



        tvGoalLoc = findViewById(R.id.tv_delivery_goalLoc);
        tvStartLoc = findViewById(R.id.tv_delivery_startLoc);
        tvUser = findViewById(R.id.tv_delivery_user);
        btnDeliver = findViewById(R.id.btn_deliver);
        btnCancel = findViewById(R.id.btn_cancel);


        tvStartLoc.setText(requestedBook.getStartLoc());
        tvGoalLoc.setText(requestedBook.getGoalLoc());
        tvUser.setText("امیر محمد صانعی");

        btnDeliver.setOnClickListener(view -> {
            Toast.makeText(this, "Delivered", Toast.LENGTH_SHORT).show();
            finish();
        });

        btnCancel.setOnClickListener(view -> {
            finish();
        });


    }
}