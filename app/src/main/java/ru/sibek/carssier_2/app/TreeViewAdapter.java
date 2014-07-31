package ru.sibek.carssier_2.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Developer on 31.07.2014.
 */
public class TreeViewAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater inflater;
    String[] objects;


    public TreeViewAdapter(Context ctx, String[] p /*tree*/) {
        this.ctx = ctx;
        objects = p;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.length;
    }

    @Override
    public Object getItem(int i) {
        return objects[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }
        ((TextView) view.findViewById(R.id.item_text)).setText(objects[i]);
        return view;
    }


}
