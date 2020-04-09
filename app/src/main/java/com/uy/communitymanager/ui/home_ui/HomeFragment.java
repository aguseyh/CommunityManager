package com.uy.communitymanager.ui.home_ui;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.uy.communitymanager.R;
import com.uy.communitymanager.ui.basic.BasicFragment;
import com.uy.communitymanager.ui.interfaces.IComunicateFragments;
import com.uy.communitymanager.ui.premium.PremiumFragment;
import com.uy.communitymanager.ui.standar.StandarFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    private BasicFragment basicFragment;
    private StandarFragment standarFragment;
    private PremiumFragment premiumFragment;

    private OnFragmentInteractionListener mListener;

    private Button basic;
    private Button standar;
    private Button premium;

    IComunicateFragments interfaceComunicaFragments;

    View view;
    Activity activity;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        basic = view.findViewById(R.id.buttonBasic);
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.changeInterfaz(v);
            }
        });

        standar = view.findViewById(R.id.buttonMedium);
        standar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.changeInterfaz(v);
            }
        });

        premium = view.findViewById(R.id.buttonPremium);
        premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.changeInterfaz(v);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            activity = (Activity) context;
            interfaceComunicaFragments = (IComunicateFragments) activity;

        }

    }

    public interface OnFragmentInteractionListener {
    }
}
