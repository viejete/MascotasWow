package com.example.a53639858v.mascotaswow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a53639858v.mascotaswow.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imagePet;
    private TextView namePet;
    private TextView strongPet;
    private TextView weakPet;
    private TextView familyPet;
    private TextView healthPet;
    private TextView powerPet;
    private TextView speedPet;
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        imagePet = (ImageView) findViewById(R.id.imagePet);
        namePet = (TextView) findViewById(R.id.namePet);
        strongPet = (TextView) findViewById(R.id.strongPet);
        weakPet = (TextView) findViewById(R.id.weakPet);
        familyPet = (TextView) findViewById(R.id.familyPet);
        healthPet = (TextView) findViewById(R.id.healthPet);
        powerPet = (TextView) findViewById(R.id.powerPet);
        speedPet = (TextView) findViewById(R.id.speedPet);

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
                .into(imagePet);
        namePet.setText(pet.getName());
        strongPet.setText("Strong Against: " + pet.getStrongAgainst());
        weakPet.setText("Weak Against: " + pet.getWeakAgainst());
        familyPet.setText("Family: " + pet.getFamily());
        healthPet.setText("Health: " + pet.getStats().getHealth());
        powerPet.setText("Power: " + pet.getStats().getPower());
        speedPet.setText("Speed: " + pet.getStats().getSpeed());
    }
}
