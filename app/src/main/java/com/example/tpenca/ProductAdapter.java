package com.example.tpenca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private List<Product> values = null;
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout, parent, false);
        ((TextView)rowView.findViewById(R.id.pricem0)).setText(
                values.get(position).getName()+"-->"+values.get(position).getPrice());
        ((TextView)rowView.findViewById(R.id.desc)).setText(
                values.get(position).getDesc());
        ImageView imageView = (ImageView) rowView.findViewById(R.id.iv0);

        if (values.get(position).getPrice()>50) {
            imageView.setImageResource(R.drawable.e);
        } else {
            imageView.setImageResource(R.drawable.et);
        }

        return rowView;
    }
}
