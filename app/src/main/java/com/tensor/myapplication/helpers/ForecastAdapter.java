package com.tensor.myapplication.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tensor.myapplication.R;
import com.tensor.myapplication.model.Forecastday;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private List<Forecastday> list;
    private Context context;
    private OnItemClickedListener listener;

    public ForecastAdapter(List<Forecastday> list, Context context, OnItemClickedListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ForecastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapter.ViewHolder holder, int position) {
        Forecastday data = list.get(position);
        holder.date.setText(data.getDate());
        holder.temp.setText(data.getDay().getMaxtempC().toString() + " C");
        holder.condition.setText(data.getDay().getCondition().getText());

        holder.itemView.setOnClickListener(view -> {
            listener.onItemClicked(data);
        });
    }


    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView date, temp, condition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.tvDate);
            temp = itemView.findViewById(R.id.tvTemp);
            condition = itemView.findViewById(R.id.tvCondition);
        }
    }

    public interface OnItemClickedListener {
        void onItemClicked(Forecastday data);
    }
}
