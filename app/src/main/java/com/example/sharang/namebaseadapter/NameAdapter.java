package com.example.sharang.namebaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sharang on 21/8/16.
 */

public class NameAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<String> mNames = new ArrayList<>();
    private Random mRandom = new Random();

    public NameAdapter(Context context) {
        mContext = context;
        for (int i = 0; i < 5; i++) {
            mNames.add(getRandomName());
        }
    }

    private String getRandomName() {
        String[] names = new String[]{
                "Hannah", "Emily", "Sarah", "Madison", "Brianna",
                "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
                "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
                "Joseph", "Zachary", "Joshua", "Andrew", "William"
        };
        return names[mRandom.nextInt(names.length)];
    }


    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(convertView==null){
            view=LayoutInflater.from(mContext).inflate(R.layout.name_view,parent,false);
        }
        else view=convertView;

        //customizing the view
        String name = mNames.get(position);
        TextView text_name = (TextView)view.findViewById(R.id.n_view);
        text_name.setText(name);
        TextView pos = (TextView)view.findViewById(R.id.position_view);
        pos.setText(String.format("I am #%d",(position+1)));

        return view;
    }

    public void addName(){
        mNames.add(getRandomName());
        notifyDataSetChanged();
    }
    public void remove(int pos){
        mNames.remove(pos);
        notifyDataSetChanged();
    }
}
