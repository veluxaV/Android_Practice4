package com.example.pr4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Services extends Fragment implements ServicesAdapter.OnItemClickListener {

    final String TAG = "ServicesLayout";
    Button backButton;
    RecyclerView services;
    public Services() {
        // Required empty public constructor
    }


    public static Services newInstance() {
        Services fragment = new Services();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_services, container, false);
        Toast.makeText(getActivity(), "onCreateViewAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView");

        backButton = (Button) v.findViewById(R.id.GoBackButton);

        final String[] servicesArray = getResources().getStringArray(R.array.services);

        // Первым делом необходимо найти список на верстке экрана
        services = (RecyclerView) v.findViewById(R.id.services);
        // Далее, создать адаптер и передать в него Context имассив элементов
        ServicesAdapter adapter = new ServicesAdapter(getContext(), servicesArray, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        services.setLayoutManager(layoutManager);
        // устанавливаем для списка адаптер
        services.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (savedInstanceState == null) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, FirstScreen.newInstance(null, null))
                            .commit();
                }
            }
        });
        return v;
    }

    @Override
    public void onItemClick(int position) {
        //String selection = ServicesAdapter.items;
        Toast.makeText(getContext(), "RecyclerView нажатие", Toast.LENGTH_SHORT).show();
    }
}