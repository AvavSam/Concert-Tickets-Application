package com.example.ticketsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TicketsAdapter extends RecyclerView.Adapter<TicketsAdapter.TicketsViewHolder> {

    private List<Concert> concertList;

    public TicketsAdapter(List<Concert> concertList) {
        this.concertList = concertList;
    }

    @NonNull
    @Override
    public TicketsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ticket, parent, false);
        return new TicketsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsViewHolder holder, int position) {
        Concert concert = concertList.get(position);
        holder.concertName.setText(concert.getName());
        holder.concertLocation.setText(concert.getLocation());
        holder.concertDate.setText(concert.getDate());
        holder.ticketCount.setText(concert.getCount());
        holder.ticketStatus.setText(concert.getStatus());
        holder.concertImage.setImageResource(concert.getImageResource());

        // Set text color based on ticket status using if-else
        if ("Succeed".equals(concert.getStatus())) {
            holder.ticketStatus.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.success_green));
        } else if ("Cancelled".equals(concert.getStatus())) {
            holder.ticketStatus.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.cancelled_red));
        } else if ("On Progress".equals(concert.getStatus())) {
            holder.ticketStatus.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.on_progress_black));
        } else {
            holder.ticketStatus.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.on_progress_black));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConcertDetailDialogFragment dialogFragment = ConcertDetailDialogFragment.newInstance(concert);
                dialogFragment.show(((AppCompatActivity) v.getContext()).getSupportFragmentManager(), "concertDetail");
            }
        });
    }

    @Override
    public int getItemCount() {
        return concertList.size();
    }

    public static class TicketsViewHolder extends RecyclerView.ViewHolder {
        TextView concertName, concertLocation, concertDate, ticketCount, ticketStatus;
        ImageView concertImage;

        public TicketsViewHolder(@NonNull View itemView) {
            super(itemView);
            concertName = itemView.findViewById(R.id.concertName);
            concertLocation = itemView.findViewById(R.id.concertLocation);
            concertDate = itemView.findViewById(R.id.concertDate);
            ticketCount = itemView.findViewById(R.id.ticketCount);
            ticketStatus = itemView.findViewById(R.id.ticketStatus);
            concertImage = itemView.findViewById(R.id.concertImage);
        }
    }
}