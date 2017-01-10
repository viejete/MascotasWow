package com.example.a53639858v.mascotaswow;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment {

    private View view;
    ListView lvPets;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;



    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_pets_fragment,menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        lvPets = (ListView) view.findViewById(R.id.lvPets);

        items = new ArrayList<>();

        items.add("Petaza");
        items.add("SUPER PETAZAAA DE LA PARRA MADREEE MIAAA");
        items.add("Que esta pasando?");

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_pets_row,
                R.id.tvPet,
                items
        );
        lvPets.setAdapter(adapter);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.refresh_action) {
            refresh();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void refresh() {

    }
}
