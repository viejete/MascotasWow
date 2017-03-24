package com.example.a53639858v.mascotaswow;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a53639858v.mascotaswow.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        binding = DataBindingUtil.setContentView(this , R.layout.activity_detail);

        Intent i = getIntent();

        if (i != null) {
            Pet pet = (Pet) i.getSerializableExtra("pet");
            if (pet != null) {
                updapteUi(pet);
            }
        }
    }

    private void updapteUi (Pet pet) {

        Picasso.with(this)
                .load("http://media.blizzard.com/wow/icons/56/"+pet.getIcon()+".jpg")
                .resize(200 , 200)
                .centerCrop()
                .into(binding.imagePet);
        binding.namePet.setText(pet.getName());
        binding.strongPet.setText("Strong Against: " + pet.getStrongAgainst());
        binding.weakPet.setText("Weak Against: " + pet.getWeakAgainst());
        binding.familyPet.setText("Family: " + pet.getFamily());
        binding.healthPet.setText("Health: " + pet.getStats().getHealth());
        binding.powerPet.setText("Power: " + pet.getStats().getPower());
        binding.speedPet.setText("Speed: " + pet.getStats().getSpeed());
    }
}
