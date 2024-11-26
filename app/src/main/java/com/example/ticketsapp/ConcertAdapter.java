package com.example.ticketsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ConcertAdapter extends RecyclerView.Adapter<ConcertAdapter.ConcertViewHolder> {

    private List<Concert> concertList;

    public ConcertAdapter(List<Concert> concertList) {
        this.concertList = concertList;
    }

    @NonNull
    @Override
    public ConcertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_concert, parent, false);
        return new ConcertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConcertViewHolder holder, int position) {
        Concert concert = concertList.get(position);
        holder.concertName.setText(concert.getName());
        holder.concertLocation.setText(concert.getLocation());
        holder.concertDate.setText(concert.getDate());
        holder.concertPrice.setText(concert.getPrice());
        holder.concertImage.setImageResource(concert.getImageResource());
    }

    @Override
    public int getItemCount() {
        return concertList.size();
    }

    public static class ConcertViewHolder extends RecyclerView.ViewHolder {
        ImageView concertImage;
        TextView concertName, concertLocation, concertDate, concertPrice;

        public ConcertViewHolder(@NonNull View itemView) {
            super(itemView);
            concertImage = itemView.findViewById(R.id.concertImage);
            concertName = itemView.findViewById(R.id.concertName);
            concertLocation = itemView.findViewById(R.id.concertLocation);
            concertDate = itemView.findViewById(R.id.concertDate);
            concertPrice = itemView.findViewById(R.id.concertPrice);
        }
    }
}