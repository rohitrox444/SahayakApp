package com.example.sahanacorona;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowDataAdapter extends RecyclerView.Adapter<ShowDataAdapter.MyViewHolder> {

    ArrayList<ProvideFoodData> list;

    public ShowDataAdapter(ArrayList<ProvideFoodData> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.show_data_layout,viewGroup,false);

        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(list.get(i).getItemtype());
        myViewHolder.desc.setText(list.get(i).getDescription());
        myViewHolder.address.setText(list.get(i).getAddress());
        myViewHolder.report_date.setText(list.get(i).getReport_date());
       // myViewHolder.contact_person.setText(list.get(i).getReport_person_UUID());
        myViewHolder.gps_loc.setText(list.get(i).getGps_loc_URL());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, address, contact_person, gps_loc, report_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_TITLE);

            desc = itemView.findViewById(R.id.item_DESC);

            address = itemView.findViewById(R.id.item_ADDRESS);

            contact_person = itemView.findViewById(R.id.item_contact_person_profile);
            gps_loc = itemView.findViewById(R.id.item_GPS_location);

            report_date = itemView.findViewById(R.id.item_DATE);
        }
    }
}
