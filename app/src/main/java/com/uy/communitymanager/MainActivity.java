package com.uy.communitymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.uy.communitymanager.ui.basic.BasicFragment;
import com.uy.communitymanager.ui.home_ui.HomeFragment;
import com.uy.communitymanager.ui.interfaces.IComunicateFragments;
import com.uy.communitymanager.ui.premium.PremiumFragment;
import com.uy.communitymanager.ui.standar.StandarFragment;

public class MainActivity extends AppCompatActivity implements IComunicateFragments, HomeFragment.OnFragmentInteractionListener  {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.conteinerFragment, new HomeFragment()).commit();

        getSupportActionBar().hide();
    }


    @Override
    public void changeInterfaz(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.buttonBasic:
                fragmentTransaction.replace(R.id.conteinerFragment, new BasicFragment()).commit();
                break;
            case R.id.buttonMedium:
                fragmentTransaction.replace(R.id.conteinerFragment, new StandarFragment()).commit();
                break;
            case R.id.buttonPremium:
                fragmentTransaction.replace(R.id.conteinerFragment, new PremiumFragment()).commit();
                break;
        }
    }
}
