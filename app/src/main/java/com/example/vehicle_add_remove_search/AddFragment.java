package com.example.vehicle_add_remove_search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.vehicle_add_remove_search.Model.Product;


public class AddFragment extends Fragment {
    private RecyclerView revCat;
    private Spinner spImg;
    private EditText ePub,eName, ePrice, eSubs;
    private Button btAdd;
    private CatAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView(view);
        adapter = new CatAdapter((MainActivity) getActivity());
        revCat.setAdapter(adapter);
        revCat.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = new Product();
                String i = spImg.getSelectedItem().toString();
                int img ;
                switch (i) {
                    case "1":
                        img = R.drawable.s1;
                        break;
                    case "2":
                        img = R.drawable.s2;
                        break;
                    case "3":
                        img = R.drawable.s3;
                        break;
                    case "4":
                        img = R.drawable.s4;
                        break;
                    case "5":
                        img = R.drawable.s5;
                        break;
                    case "6":
                        img = R.drawable.s6;
                        break;
                    default : img = 0 ;
                }
                p.setImage(img);
                p.setPublisher(ePub.getText().toString());
                p.setName(eName.getText().toString());
                p.setPrice(Integer.parseInt(ePrice.getText().toString()));
                p.setSubscription(eSubs.getText().toString());
                adapter.add(p);
                adapter.notifyDataSetChanged();
            }
        });
    }
//    public void add(){
//        adapter = new CatAdapter((MainActivity) getActivity());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
//        revCat.setLayoutManager(layoutManager);
//        adapter.add(new Product(R.drawable.s1,"Lamborghini","Veneno",5000000,"Excellent"));
//        adapter.add(new Product(R.drawable.s2,"Lamborghini","Aventador",300000,"Excellent"));
//        revCat.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }
    private void intView(View v) {
        revCat = v.findViewById(R.id.recyclerView);
        spImg = v.findViewById(R.id.img);
        eName = v.findViewById(R.id.name);
        ePrice = v.findViewById(R.id.price);
        eSubs = v.findViewById(R.id.subs);
        ePub=v.findViewById(R.id.pub) ;
        btAdd = v.findViewById(R.id.btAdd);
    }
}