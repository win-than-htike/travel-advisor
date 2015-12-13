package ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SlidingDrawer;

import com.myanmarplus.traveladvisor.R;

import java.util.ArrayList;
import java.util.List;

import model.NavigationItem;
import ui.adapter.NavRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private RecyclerView drawerRecycler;
    NavRecyclerAdapter navAdapter;

    public DrawerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drawer, container, false);
        drawerRecycler = (RecyclerView)v.findViewById(R.id.drawer_list);
        navAdapter = new NavRecyclerAdapter(getActivity(),getData());
        drawerRecycler.setAdapter(navAdapter);
        drawerRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    public List<NavigationItem> getData(){

        List<NavigationItem> list = new ArrayList<>();

        int[] icon = {R.drawable.pagoda,R.drawable.cinema,R.drawable.entertainment,R.drawable.restaurant};
        String[] title = {"Pagoda","Cinema","Entertainment","Resturant"};

        for (int i = 0; i < icon.length;i++){

            NavigationItem item = new NavigationItem();
            item.setIconId(icon[i]);
            item.setTitle(title[i]);
            list.add(item);

        }

        return list;

    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {

        mDrawerLayout = drawerLayout;
        mToggle = new ActionBarDrawerToggle(getActivity(),mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_closer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d("Winthan","Drawer Opened");
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d("Winthan","Drawer Closed");
                getActivity().invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mToggle.syncState();
            }
        });

    }
}
