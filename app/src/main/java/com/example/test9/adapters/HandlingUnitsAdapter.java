package com.example.test9.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test9.R;
import com.example.test9.models.HandlingUnit;

import java.text.SimpleDateFormat;
import java.util.List;

public class HandlingUnitsAdapter extends RecyclerView.Adapter<HandlingUnitsAdapter.HandlingUnitsHolder>{

    private List<HandlingUnit> handlingUnits;
    private OnHandlingUnitClickListener onHandlingUnitClickListener;

    public HandlingUnitsAdapter(List<HandlingUnit> handlingUnits) {
        this.handlingUnits = handlingUnits;
    }

    public void setOnHandlingUnitClickListener(OnHandlingUnitClickListener onHandlingUnitClickListener) {
        this.onHandlingUnitClickListener = onHandlingUnitClickListener;
    }

    @NonNull
    @Override
    public HandlingUnitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.handling_unit_item, parent, false);
        return new HandlingUnitsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HandlingUnitsHolder holder, int position) {
        HandlingUnit handlingUnit = handlingUnits.get(position);
        holder.textViewHandlingUnit.setText(handlingUnit.getHandlingUnit());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        holder.textViewCreateDate.setText(simpleDateFormat.format(handlingUnit.getCreateCalendar().getTime()));
    }

    @Override
    public int getItemCount() {
        return handlingUnits.size();
    }

    class HandlingUnitsHolder extends RecyclerView.ViewHolder{

        private TextView textViewHandlingUnit;
        private TextView textViewCreateDate;

        public HandlingUnitsHolder(@NonNull View itemView) {
            super(itemView);
            textViewHandlingUnit = itemView.findViewById(R.id.textViewHandlingUnit);
            textViewCreateDate = itemView.findViewById(R.id.textViewCreateDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onHandlingUnitClickListener != null){
                        onHandlingUnitClickListener.onHandlingUnitClick(getAdapterPosition());
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(onHandlingUnitClickListener != null){
                        onHandlingUnitClickListener.onHandlingUnitLongClick(getAdapterPosition());
                    }
                    return true;
                }
            });
        }
    }

    public interface OnHandlingUnitClickListener{
        void onHandlingUnitClick(int position);
        void onHandlingUnitLongClick(int position);
    }

}
