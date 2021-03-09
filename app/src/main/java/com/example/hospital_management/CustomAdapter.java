package com.example.hospital_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int [] doctors;
    String[] doctorname;
    String[] specialist;
    private LayoutInflater inflater;
    CustomAdapter(Context context,int[]doctors,String[]doctorname,String[]specialist){
        this.context = context;
        this.doctors = doctors;
        this.doctorname = doctorname;
        this.specialist = specialist;
    }
    @Override
    public int getCount() {
        return doctors.length;
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
        if (convertView==null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.doctor_gridview, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageviewid);
        TextView textView = (TextView) convertView.findViewById(R.id.textviewid);
        TextView textView1 = (TextView) convertView.findViewById(R.id.specialviewid);
        imageView.setImageResource(doctors[position]);
        textView.setText(doctorname[position]);
        textView1.setText(specialist[position]);
        return convertView;
    }
}
