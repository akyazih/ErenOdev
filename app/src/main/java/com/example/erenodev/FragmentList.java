package com.example.erenodev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class FragmentList extends ListFragment {

    String countries[]= {
            "","Elma", "Armut", "Muz", "Kiraz", "Üzüm", "Karpuz", "Erik", "Şeftali","Mandalina","Portakal","Çilek","Kiraz","Vişne","Ananas","Kivi","Avokado","Hindistan Cevizi"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String>adapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,countries);
        setListAdapter(adapter);
    }
}
