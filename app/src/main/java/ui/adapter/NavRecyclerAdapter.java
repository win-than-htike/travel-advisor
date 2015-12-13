package ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myanmarplus.traveladvisor.R;

import java.util.Collections;
import java.util.List;

import model.NavigationItem;
import ui.activity.PagodaActivity;

/**
 * Created by winthanhtike on 12/10/15.
 */
public class NavRecyclerAdapter extends RecyclerView.Adapter<NavRecyclerAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<NavigationItem> data = Collections.emptyList();

    public NavRecyclerAdapter(Context context,List<NavigationItem> data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.nav_list,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        NavigationItem item = data.get(position);
        holder.icon.setImageResource(item.getIconId());
        holder.title.setText(item.getTitle());
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){

                    case 0:
                        Intent intent = new Intent(context, PagodaActivity.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            icon = (ImageView)itemView.findViewById(R.id.icon);
            title = (TextView)itemView.findViewById(R.id.title);

        }

    }

}
