package ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarplus.traveladvisor.R;

import java.util.ArrayList;
import java.util.List;

import model.TabItem;
import ui.adapter.TabRecyclerAdapter;

/**
 * Created by winthanhtike on 12/9/15.
 */
public class CinemaFragment extends Fragment {

    private RecyclerView rv_cinema;
    private TabRecyclerAdapter tabRvAdapter;

    public CinemaFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cinema,container,false);
        rv_cinema = (RecyclerView)v.findViewById(R.id.rv_cinema);
        tabRvAdapter = new TabRecyclerAdapter(getActivity(),getData());
        rv_cinema.setAdapter(tabRvAdapter);
        rv_cinema.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    public List<TabItem> getData(){

        List<TabItem> itemList = new ArrayList<>();

        int[] imageId = {R.drawable.google,R.drawable.google,R.drawable.google,R.drawable.google};
        String[] title = {"Google","Facebook","Youtube","Bing"};

        for (int i = 0; i < imageId.length; i++){

            TabItem item = new TabItem();
            item.setTitle(title[i]);
            item.setImageId(imageId[i]);
            itemList.add(item);
        }

        return itemList;

    }

}
