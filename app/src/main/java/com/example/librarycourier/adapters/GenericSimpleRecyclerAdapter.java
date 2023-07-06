package com.example.librarycourier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GenericSimpleRecyclerAdapter<T> extends RecyclerView.Adapter<GenericSimpleRecyclerAdapter.ViewHolder>{

    private ArrayList<T> dataSet;

    private List<T> dataSet2 = new ArrayList<>();
    private int layoutID;

    private GenericSimpleRecyclerBindingInterface<T> bindingInterface;

    public GenericSimpleRecyclerAdapter(List<T> dataSet2, @LayoutRes int layoutID, GenericSimpleRecyclerBindingInterface<T> bindingInterface) {
        this.dataSet2 = dataSet2;
        this.layoutID = layoutID;
        this.bindingInterface = bindingInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layoutID, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericSimpleRecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(dataSet2.get(position), bindingInterface);
    }


    @Override
    public int getItemCount() {
        return dataSet2.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        private void bind(T item, GenericSimpleRecyclerBindingInterface<T> bindingInterface){
            bindingInterface.bindData(item, itemView);
        }
    }


    public interface GenericSimpleRecyclerBindingInterface<T> {
        void bindData(T item, View view);
    }
}
