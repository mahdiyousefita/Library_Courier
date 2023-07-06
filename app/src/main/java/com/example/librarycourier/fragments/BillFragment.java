package com.example.librarycourier.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.librarycourier.R;
import com.example.librarycourier.adapters.GenericSimpleRecyclerAdapter;
import com.example.librarycourier.items.BillItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BillFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BillFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BillFragment newInstance() {
        BillFragment fragment = new BillFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // recyclerView:

        RecyclerView recyclerView = view.findViewById(R.id.rv_bill);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        List<BillItem> billItemList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            BillItem billItem = new BillItem();
            billItem.setRecordDate("1379-11-11");
            billItem.setPrice("140,000 تومان");
            billItem.setStatus("پرداخت شده");

            billItemList.add(billItem);
        }

        GenericSimpleRecyclerAdapter<BillItem> adapter = new GenericSimpleRecyclerAdapter<>(billItemList,
                R.layout.bill_item_layout, (item, view1) -> {

            TextView tvRecordDate = view1.findViewById(R.id.tv_setTime);
            TextView tvPrice = view1.findViewById(R.id.tv_setPrice);
            TextView tvStatus = view1.findViewById(R.id.tv_setStatus);

            tvRecordDate.setText(item.getRecordDate());
            tvPrice.setText(item.getPrice());
            tvStatus.setText(item.getStatus());

        });

        recyclerView.setAdapter(adapter);


        // CardView:


        TextView tvYourSalary = view.findViewById(R.id.tv_yourSalary);

        tvYourSalary.setText("110,000 تومان");
    }
}