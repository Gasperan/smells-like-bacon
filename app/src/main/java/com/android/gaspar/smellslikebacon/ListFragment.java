package com.android.gaspar.smellslikebacon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment{

    public interface OnRecipeSelectedInterface {
        void onListRecipesSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_list, container,false);

        /*creamos nuestro recycler view*/
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);

        /*creamos el adapter*/
        ListAdapter listAdapter = new ListAdapter(listener);

        /*seteamos el adapter*/
        recyclerView.setAdapter(listAdapter);

        /*creamos un layoutmanager para manejar la forma en la que vamos a desplegar el list*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        /*seteamos el manager al recycler view */
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
