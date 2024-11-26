package com.example.ticketsapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView concertsRecyclerView;
    private ConcertAdapter concertAdapter;
    private List<Concert> concertList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        concertsRecyclerView = view.findViewById(R.id.concertsRecyclerView);
        concertsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Muat data dari strings.xml dan arrays.xml
        Resources res = getResources();
        String[] concertNames = res.getStringArray(R.array.concert_names);
        String[] concertLocations = res.getStringArray(R.array.concert_locations);
        String[] concertDates = res.getStringArray(R.array.concert_dates);
        String[] concertPrices = res.getStringArray(R.array.concert_prices);
        TypedArray concertImagesArray = res.obtainTypedArray(R.array.concert_photo);

        // Buat list konser
        concertList = new ArrayList<>();
        for (int i = 0; i < concertNames.length; i++) {
            Concert concert = new Concert();
            concert.setName(concertNames[i]);
            concert.setLocation(concertLocations[i]);
            concert.setDate(concertDates[i]);
            concert.setPrice(concertPrices[i]);
            concert.setImageResource(concertImagesArray.getResourceId(i, -1));
            concertList.add(concert);
        }

        concertImagesArray.recycle();

        // Set adapter untuk RecyclerView
        concertAdapter = new ConcertAdapter(concertList);
        concertsRecyclerView.setAdapter(concertAdapter);

        return view;
    }
}