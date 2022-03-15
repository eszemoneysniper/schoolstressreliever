package com.example.schoolstressreliever.justin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolstressreliever.R;
import com.example.schoolstressreliever.justin.Holder;

import java.util.ArrayList;
import java.util.List;

public class receiveReqAdapter extends RecyclerView.Adapter<Holder>
{

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ArrayList<String>capacityData;
    private ArrayList<String>makerData;
    private ArrayList<String>typeData;
    private Context context;


    // data is passed into the constructor



    receiveReqAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    public void updateInfo(ArrayList<String> statusData, ArrayList<String>lolData,ArrayList<String> lmaoData )
    {
        this.capacityData = statusData;
        this.makerData = lolData;
        this.typeData = lmaoData;
    }

    // inflates the row layout from xml when needed
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.receive_row_view, parent, false);
        return new Holder(view, mClickListener);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(Holder holder, int position)
    {
        holder.capacityText.setText(capacityData.get(position));
        holder.makerText.setText(makerData.get(position));
        holder.typeText.setText(typeData.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener)
    {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener
    {
        void onItemClick(View view, int position);
    }








}

