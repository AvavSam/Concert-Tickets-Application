package com.example.ticketsapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ConcertDetailDialogFragment extends DialogFragment {

    private static final String ARG_CONCERT = "concert";

    public static ConcertDetailDialogFragment newInstance(Concert concert) {
        ConcertDetailDialogFragment fragment = new ConcertDetailDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONCERT, concert);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_concert_detail, container, false);

        Concert concert = (Concert) getArguments().getSerializable(ARG_CONCERT);

        ImageView concertImage = view.findViewById(R.id.concertImage);
        TextView concertName = view.findViewById(R.id.concertName);
        TextView concertLocation = view.findViewById(R.id.concertLocation);
        TextView concertDate = view.findViewById(R.id.concertDate);
        TextView concertPrice = view.findViewById(R.id.concertPrice);
        TextView ticketCount = view.findViewById(R.id.ticketCount);
        TextView ticketStatus = view.findViewById(R.id.ticketStatus);

        concertImage.setImageResource(concert.getImageResource());
        concertName.setText(concert.getName());
        concertLocation.setText(concert.getLocation());
        concertDate.setText(concert.getDate());
        concertPrice.setText(concert.getPrice());
        ticketCount.setText(concert.getCount());
        ticketStatus.setText(concert.getStatus());

        return view;
    }
}