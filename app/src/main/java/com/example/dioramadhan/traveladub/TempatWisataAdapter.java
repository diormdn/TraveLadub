package com.example.dioramadhan.traveladub;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TempatWisataAdapter extends RecyclerView.Adapter<TempatWisataAdapter.TempatWisataViewHolder>{
    LayoutInflater mInflater;
    ArrayList<TempatWisata> tw;
    Context _context;

    public TempatWisataAdapter(ArrayList<TempatWisata> tw, Context _context) {
        this.mInflater = LayoutInflater.from(_context);
        this.tw = tw;
        this._context = _context;
    }

    @NonNull
    @Override
    public TempatWisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_wisata, parent, false);
        return new TempatWisataViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TempatWisataViewHolder holder, int position) {
        TempatWisata current = tw.get(position);
        holder.namaTempat.setText(current.namaTempat);
        holder.valWeekdays.setText(current.jamBukaWeekdays);
        holder.valWeekend.setText(current.jamBukaWeekends);
        holder.gambarTempat.setImageResource(current.urlGambar[0]);
    }

    @Override
    public int getItemCount() {
        return tw.size();
    }

    class TempatWisataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView namaTempat, valWeekdays, valWeekend, weekdaysTxt, weekendTxt;
        ImageView gambarTempat;


        public TempatWisataViewHolder(View itemView, TempatWisataAdapter adapter) {
            super(itemView);
            namaTempat = (TextView) itemView.findViewById(R.id.namaTempat);
            valWeekdays = (TextView) itemView.findViewById(R.id.valWeekdays);
            valWeekend = (TextView) itemView.findViewById(R.id.valWeekend);
            weekdaysTxt = (TextView) itemView.findViewById(R.id.weekdaysTxt);
            weekendTxt = (TextView) itemView.findViewById(R.id.weekendTxt);
            gambarTempat = (ImageView) itemView.findViewById(R.id.gambarTempat);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
