package org.techtown.recherche;

//Filtre



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication2.R;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>{

    ArrayList<Feed> items = new ArrayList<Feed>();
    public FeedAdapterOnBindCallback onBind;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.feed_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position) {
        Feed item = items.get(position);
        viewHolder.setItem(item);
        if(onBind != null){
            onBind.onViewBound(viewHolder, position);
        }
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textMessage1);
        }

        public void setItem(Feed item){
            textView.setText(item.getName());
            textView2.setText(item.getMessage());
        }
    }

    public void addItem(Feed item){
        items.add(item);
    }

    public void setItems(ArrayList<Feed> items){
        this.items = items;
    }

    public Feed getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Feed item){
        items.set(position, item);
    }


}

