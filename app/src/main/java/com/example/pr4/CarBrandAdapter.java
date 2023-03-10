package com.example.pr4;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CarBrandAdapter  extends ArrayAdapter<String> {
    private LayoutInflater inflater;
    private int layout;
    private String[] items;
    public CarBrandAdapter(Context context, int resource, String[] items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.car_brand);
        textView.setText(items[position]);
        //ClipData.Item item = items.get(position);
        //textView.setText(item.getText());
        return view;
    }

}
