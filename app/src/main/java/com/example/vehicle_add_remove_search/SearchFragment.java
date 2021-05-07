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

import com.example.vehicle_add_remove_search.Model.Product;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    private RecyclerView revView;
    private SearchAdapter adapter;
    private EditText eName;
    private Button btSearch;
    private List<Product> list ;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView(view);
        revView.setAdapter(adapter);
        revView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List<Product> tList=new ArrayList<>();
                String name=eName.getText().toString();
                for(Product p:list){
                    if(p.getName().indexOf(name)>=0)
                        tList.add(p);
                }
                adapter =new SearchAdapter(tList, getContext());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                revView.setLayoutManager(layoutManager);
                revView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
    private void intView(View v) {
        revView=v.findViewById(R.id.recyclerView);
        eName=v.findViewById(R.id.name);
        btSearch=v.findViewById(R.id.btSearch);
    }
    @Override
    public void onResume() {
        super.onResume();
        list = ((MainActivity)getActivity()).list;
    }
}