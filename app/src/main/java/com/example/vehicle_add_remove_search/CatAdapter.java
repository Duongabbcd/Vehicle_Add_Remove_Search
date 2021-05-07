package com.example.vehicle_add_remove_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehicle_add_remove_search.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends  RecyclerView.Adapter<CatAdapter.CatViewHolder>{

    private List<Product> mlist;
    private MainActivity mainActivity;
    public CatAdapter(MainActivity m) {
        mainActivity=m;
        mlist=new ArrayList<>();
    }
    @NonNull
    @Override
    public CatAdapter.CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_card,parent,false);
        return new CatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.CatViewHolder holder, int position) {

        Product p=mlist.get(position);
        if(p!=null) {
            holder.img.setImageResource(p.getImage());
            holder.publisher.setText(p.getPublisher());
            holder.name.setText(p.getName());
            holder.price.setText(p.getPrice() + "");
            holder.subscription.setText(p.getSubscription());
            holder.btRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mlist.remove(position);
                    notifyDataSetChanged();
                    mainActivity.list=mlist;
                }
            });
        }else
            return;
    }

    public void add(Product p){
        mlist.add(p);
        notifyDataSetChanged();
        mainActivity.list=mlist;
    }
    @Override
    public int getItemCount() {
        if(mlist!=null)
            return mlist.size();
        else
            return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView publisher ,name,price,subscription;
        private Button btRemove;

        public CatViewHolder(@NonNull View v) {
            super(v);
            img= v.findViewById(R.id.img1);
            publisher=v.findViewById(R.id.hp_pub);
            name=v.findViewById(R.id.hp_name);
            price=v.findViewById(R.id.hp_price);
            subscription=v.findViewById(R.id.hp_sub);
            btRemove=v.findViewById(R.id.hp_btn);
        }
    }
}
