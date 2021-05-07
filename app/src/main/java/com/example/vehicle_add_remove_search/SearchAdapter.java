package com.example.vehicle_add_remove_search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehicle_add_remove_search.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends  RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private List<Product> searchList;
    private Context context;

    public SearchAdapter(List<Product> searchList, Context context) {
        this.searchList = searchList;
        this.context = context;

        notifyDataSetChanged();
    }

    public void setSearchList(List<Product> searchList) {
        this.searchList = searchList;

    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_search,parent,false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        Product p=searchList.get(position);
        if(p!=null) {
            holder.img.setImageResource(p.getImage());
            holder.pub.setText(p.getPublisher());
            holder.name.setText(p.getName());
            holder.price.setText(p.getPrice() + "");
            holder.sub.setText(p.getSubscription());
        }else
            return;
    }


    @Override
    public int getItemCount() {
        if(searchList!=null)
            return searchList.size();
        else
            return 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name,pub,sub,price;
        public SearchViewHolder(@NonNull View v) {
            super(v);
            img= v.findViewById(R.id.hp_img);
            pub=v.findViewById(R.id.hp_pub);
            name=v.findViewById(R.id.hp_name);
;           price=v.findViewById(R.id.hp_price) ;
            sub=v.findViewById(R.id.hp_sub) ;
        }
    }

}
