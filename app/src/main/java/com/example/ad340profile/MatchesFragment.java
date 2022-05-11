package com.example.ad340profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        List<Matches> matchesList = new ArrayList<>();
        matchesList.add(new Matches("Mark Palpatine", "Not a cool guy", false, "https://i.imgur.com/zvphlfb.jpeg"));
        matchesList.add(new Matches("Grumpy cat", "A happy cat", true, "https://i.imgur.com/T6T0H.jpeg"));
        matchesList.add(new Matches("Steve", "Fellow kid", false, "https://i.imgur.com/VAeA885.jpeg"));
        matchesList.add(new Matches("Random Duck", "Here to party", true, "https://i.imgur.com/riUVT6S.jpeg"));
        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        MatchesRecyclerViewAdapter adapter = new MatchesRecyclerViewAdapter(matchesList);
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.small_grid_spacing);
        recyclerView.addItemDecoration(new MatchesItemDecoration(largePadding, smallPadding));

        return view;
    }
}