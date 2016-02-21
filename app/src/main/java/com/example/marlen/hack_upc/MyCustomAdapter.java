package com.example.marlen.hack_upc;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by marlen on 20/02/2016.
 */
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.AdapterViewHolder> {

    ArrayList<Service> myawesomelistofservices;
    

    MyCustomAdapter() {
        myawesomelistofservices = new ArrayList<>();
    }

    @Override
    public MyCustomAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rows, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomAdapter.AdapterViewHolder holder, int position) {

        holder.name.setText(myawesomelistofservices.get(position).getName());
        holder.phone.setText(myawesomelistofservices.get(position).getTelNum().toString());
        /*pic = Uri.parse(myawesomelistofservices.get(position).getImage().toString());
        try{
            holder.foto.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getContentResolver, pic));
        }catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    @Override
    public int getItemCount() {
        if (myawesomelistofservices != null) return myawesomelistofservices.size();
        else return 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone;
        //public ImageView foto;
        public View v;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.v = itemView;
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.phone = (TextView) itemView.findViewById(R.id.phone);
            //  this.foto = (ImageView)itemView.findViewById(R.id.fotoPerfil);
        }
    }

    public void setData(ArrayList<Service> myawesomelistofservices) {
        this.myawesomelistofservices = myawesomelistofservices;
        notifyDataSetChanged();
    }
}

