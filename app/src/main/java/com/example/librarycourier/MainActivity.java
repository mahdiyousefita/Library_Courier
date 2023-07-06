package com.example.librarycourier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.librarycourier.fragments.BillFragment;
import com.example.librarycourier.fragments.HistoryFragment;
import com.example.librarycourier.fragments.RequestsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewBind();



        bottomNavigationViewMain.setOnItemSelectedListener(item -> {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()){
                case R.id.item_bill:
//                    Toast.makeText(MainActivity.this, "bill", Toast.LENGTH_SHORT).show();

                    transaction.replace(R.id.frameLayout, BillFragment.newInstance());
                    transaction.commit();

                    return true;
                case R.id.item_history:
//                    Toast.makeText(MainActivity.this, "history", Toast.LENGTH_SHORT).show();

                    transaction.replace(R.id.frameLayout, HistoryFragment.newInstance());
                    transaction.commit();


                    return true;
                case R.id.item_request:
//                    Toast.makeText(MainActivity.this, "request", Toast.LENGTH_SHORT).show();

                    transaction.replace(R.id.frameLayout, RequestsFragment.newInstance());
                    transaction.commit();
                    return true;
            }
            return false;
        });

        bottomNavigationViewMain.setSelectedItemId(R.id.item_request);


        bottomNavigationViewMain.setOnItemReselectedListener(item -> { // do nothing
             });

    }

    private void viewBind(){
        bottomNavigationViewMain = findViewById(R.id.bottomNavigationView);

    }
}