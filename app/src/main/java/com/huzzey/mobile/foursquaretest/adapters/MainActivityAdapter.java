package com.huzzey.mobile.foursquaretest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huzzey.mobile.foursquaretest.R;
import com.huzzey.mobile.foursquaretest.datatypes.Venue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    private List<Venue> list;
    private LayoutInflater inflater;

    public MainActivityAdapter(Context context) {
        list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void updateData(List<Venue> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView venueName;
        ImageView venueImage;

        public ViewHolder(View itemView) {
            super(itemView);
            venueName = (TextView) itemView.findViewById(R.id.venueName);
            venueImage = (ImageView) itemView.findViewById(R.id.venueImage);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.activity_main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Venue venue = list.get(position);
        holder.venueName.setText(venue.getName());
    }
}
