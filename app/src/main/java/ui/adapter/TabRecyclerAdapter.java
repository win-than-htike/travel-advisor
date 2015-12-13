package ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myanmarplus.traveladvisor.R;

import java.util.Collections;
import java.util.List;

import model.TabItem;

/**
 * Created by winthanhtike on 12/13/15.
 */
public class TabRecyclerAdapter extends RecyclerView.Adapter<TabRecyclerAdapter.TabViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<TabItem> items = Collections.emptyList();

    public TabRecyclerAdapter(Context context, List<TabItem> items){

        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);

    }


    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_view,parent,false);
        TabViewHolder viewHolder = new TabViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {

        TabItem item = items.get(position);
        holder.imageView.setImageResource(item.getImageId());
        holder.tvTitle.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TabViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView tvTitle;

        public TabViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.card_image);
            tvTitle = (TextView)itemView.findViewById(R.id.card_title);

        }

    }
}
