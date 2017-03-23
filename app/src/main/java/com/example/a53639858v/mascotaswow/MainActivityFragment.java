package com.example.a53639858v.mascotaswow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.databinding.DataBindingUtil;

import com.example.a53639858v.mascotaswow.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment implements AsyncResponse {

    private View view;
    ListView lvPets;
    private ArrayList<Pet> pets;
    private PetAdapter petAdapter;
    PetsAPI api = new PetsAPI();

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

        FragmentMainBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_main , container , false);
        view = binding.getRoot();

        //lvPets = (ListView) view.findViewById(R.id.lvPets);

        pets = new ArrayList<>();
        petAdapter = new PetAdapter(getContext() , R.layout.lv_pets_row , pets);
        binding.lvPets.setAdapter(petAdapter);

        binding.lvPets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pet pet = (Pet) parent.getItemAtPosition(position);
                Intent i = new Intent(getContext() , DetailActivity.class);
                i.putExtra("pet" , pet);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.refresh_action) {
            refresh();
            return true;
        } else if (id == R.id.action_settings) {
            Intent i = new Intent(getContext(), SettingsActivity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.search_action) {
            refreshPreferences();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    private void refreshPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String nombre = preferences.getString("buscador_nombre" , "nombre");
        Log.i("Nombre pet: " , nombre);
        ArrayList<Pet> petsFinded = new ArrayList<>();

        if (!nombre.equalsIgnoreCase("nombre")) {
            Log.i("Entra aqui -> " , "si");
            for (Pet p : pets) {
                if (p.getName().contains(nombre)) {
                    petsFinded.add(p);
                }
            }
            petAdapter.clear();
            for (Pet p : petsFinded) {
                petAdapter.add(p);
            }
            petAdapter.notifyDataSetChanged();
        }
    }

    private void refresh() {
        DownloadPetsTask task = new DownloadPetsTask();
        task.delegate = this;
        task.execute(getContext());
    }


    @Override
    public void processFinish(String jsonPets) {
        pets = api.pasarPets(jsonPets);
        for (Pet p : pets) {
            petAdapter.add(p);
        }
        petAdapter.notifyDataSetChanged();

    }
}
