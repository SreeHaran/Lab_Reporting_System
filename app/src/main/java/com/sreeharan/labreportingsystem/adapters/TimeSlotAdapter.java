package com.sreeharan.labreportingsystem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeharan.labreportingsystem.R;
import com.sreeharan.labreportingsystem.pojo.TimeSlot;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.MyViewHolder> {

    Context mContext;
    TimeSlot mTimeSlotList[];

    public TimeSlotAdapter(Context context, TimeSlot[] timeSlotList) {
        mContext = context;
        mTimeSlotList = timeSlotList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_time_slot, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.timeSlotText.setText(new StringBuilder(TimeSlot.convertTimeToString(position)));
        if(mTimeSlotList[position].getSlot() == 0)
            holder.timeSlotDescription.setText("Available");
        else
            holder.timeSlotDescription.setText("Booked");
        holder.timeSlotDescription.setTextColor(mContext.getResources().getColor(android.R.color.black));
        holder.timeSlotText.setTextColor(mContext.getResources().getColor(android.R.color.black));

    }

    @Override
    public int getItemCount() {
        return mTimeSlotList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView timeSlotText, timeSlotDescription;
        LinearLayout timeSlotLayout;
        
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            timeSlotLayout = itemView.findViewById(R.id.time_slot_layout);
            timeSlotText = itemView.findViewById(R.id.time_slot_text);
            timeSlotDescription = itemView.findViewById(R.id.time_slot_description);
        }
    }
}
