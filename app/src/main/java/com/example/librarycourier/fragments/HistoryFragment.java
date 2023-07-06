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

import com.example.librarycourier.adapters.GenericSimpleRecyclerAdapter;
import com.example.librarycourier.R;
import com.example.librarycourier.items.HistoryItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    private boolean btnClicked = true;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
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
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // fake items
        List<HistoryItem> items = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            HistoryItem item = new HistoryItem();
            item.setItemID("مرسولهNVSO1236");
            item.setItemPrice("20000 تومان");
            item.setItemUserName("اشکان مهدوی");

            items.add(item);

        }

        RecyclerView recyclerView = view.findViewById(R.id.rv_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        GenericSimpleRecyclerAdapter adapter =new GenericSimpleRecyclerAdapter<>(
                items,
                R.layout.history_item_layout,
                (item, view1) -> {
                    TextView tvID = view1.findViewById(R.id.tv_history_ID);
                    TextView tvPrice = view1.findViewById(R.id.tv_history_price);
                    TextView tvName = view1.findViewById(R.id.tv_history_name);
                    MaterialButton btnMain = view1.findViewById(R.id.btn_history_request);

                    tvID.setText(item.getItemID());
                    tvPrice.setText(item.getItemPrice());
                    tvName.setText(item.getItemUserName());

                    btnMain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (btnClicked == true){
                                btnClicked = false;
                                btnMain.setText("لغو درخواست");
                                btnMain.setTextColor(getResources().getColor(R.color.my_red, getActivity().getTheme()));
                            } else {
                                btnClicked = true;
                                btnMain.setText("دریافت مشتری");
                                btnMain.setTextColor(getResources().getColor(R.color.my_green, getActivity().getTheme()));
                            }
                        }
                    });

                });

        recyclerView.setAdapter(adapter);
    }
}