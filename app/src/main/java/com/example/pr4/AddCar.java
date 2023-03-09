package com.example.pr4;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCar extends Fragment {

    Button backButton;
    final String TAG = "AddCarLayout";
    private EditText car_name;
    private EditText car_brandname;
    final static String ARG_PARAM1 = "CAR_NAME";
    final static String ARG_PARAM2 = "CAR_BRAND";

    public static AddCar newInstance() {
        AddCar fragment = new AddCar();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        Toast.makeText(getActivity(), "onCreateAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getActivity(), "onAttachAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onAttach");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_car, container, false);
        Toast.makeText(getActivity(), "onCreateViewAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView");

        backButton = (Button) v.findViewById(R.id.GoBackButton);

        car_name = (EditText) v.findViewById(R.id.name_edit_text);
        car_brandname = (EditText) v.findViewById(R.id.brand_edit_text);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Button click in AddCar");
                String name = car_name.getText().toString();
                String brand = car_brandname.getText().toString();
                Log.d("Car name", name);
                Log.d("Car brand", brand);

                if (savedInstanceState == null) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, FirstScreen.newInstance(name, brand))
                            .commit();
                }
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResumeAddCar", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "onPauseAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "onDestroyViewAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "onDetachAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "onDestroyAddCar", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }
}