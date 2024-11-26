package com.example.ticketsapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class TicketsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TicketsAdapter adapter;
    private List<Concert> concertList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_tickets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load data from strings.xml and arrays.xml
        Resources res = getResources();
        String[] concertNames = res.getStringArray(R.array.concert_names);
        String[] concertLocations = res.getStringArray(R.array.concert_locations);
        String[] concertDates = res.getStringArray(R.array.concert_dates);
        String[] concertPrices = res.getStringArray(R.array.concert_prices);
        String[] concertCount = res.getStringArray(R.array.tickets_amount);
        String[] concertStatus = res.getStringArray(R.array.tickets_status);
        TypedArray concertImagesArray = res.obtainTypedArray(R.array.concert_photo);

        // Create concert list
        concertList = new ArrayList<>();
        for (int i = 0; i < concertNames.length; i++) {
            Concert concert = new Concert();
            concert.setName(concertNames[i]);
            concert.setLocation(concertLocations[i]);
            concert.setDate(concertDates[i]);
            concert.setPrice(concertPrices[i]);
            concert.setCount(concertCount[i]);
            concert.setStatus(concertStatus[i]);
            concert.setImageResource(concertImagesArray.getResourceId(i, -1));
            concertList.add(concert);
        }

        concertImagesArray.recycle();

        // Set adapter for RecyclerView
        adapter = new TicketsAdapter(concertList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}