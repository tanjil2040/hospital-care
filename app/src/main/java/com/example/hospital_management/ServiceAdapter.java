package com.example.hospital_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceAdapter extends BaseAdapter {
    Context context;
    int [] doctors;
    String[] doctorname;
    String[] specialist;
    private LayoutInflater inflater;

    public ServiceAdapter(Context context, int[] doctors, String[] doctorname, String[] specialist) {
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
            convertView = inflater.inflate(R.layout.service_listview, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.listimageid);
        TextView textView = (TextView) convertView.findViewById(R.id.listtextid);
        TextView textView1 = (TextView) convertView.findViewById(R.id.listpriceid);
        imageView.setImageResource(doctors[position]);
        textView.setText(doctorname[position]);
        textView1.setText(specialist[position]);
        return convertView;
    }
}
