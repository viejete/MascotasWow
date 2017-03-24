package com.example.a53639858v.mascotaswow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.a53639858v.mascotaswow.databinding.LvPetsRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class PetAdapter extends ArrayAdapter<Pet> {

    public PetAdapter (Context context , int resource , ArrayList<Pet> pets) {
        super(context , resource , pets);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Pet pet = getItem(position);

        LvPetsRowBinding binding;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            //convertView = inflater.inflate(R.layout.lv_pets_row, parent, false);
            binding = DataBindingUtil.inflate(inflater , R.layout.lv_pets_row , parent , false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        try {
            binding.tvPet.setText(pet.getName());
            Picasso.with(getContext())
                    .load("http://media.blizzard.com/wow/icons/56/"+pet.getIcon()+".jpg")
                    .resize(130 , 130)
                    .centerCrop()
                    .into(binding.imageRow);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return binding.getRoot();

    }
}
