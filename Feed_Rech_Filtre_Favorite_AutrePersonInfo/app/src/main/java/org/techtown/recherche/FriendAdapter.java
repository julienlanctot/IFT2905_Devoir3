package org.techtown.recherche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication2.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    ArrayList<Friend> items = new ArrayList<Friend>();
    public OnBindCallback3 onBind;

    @NonNull
    @Override
    public FriendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.friend_item, viewGroup, false);
        return new FriendAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.ViewHolder viewHolder, int position) {
        Friend item = items.get(position);
        viewHolder.setItem(item);
        if(onBind != null){
            onBind.onViewBound3(viewHolder, position);
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
            textView2 = itemView.findViewById(R.id.textView2);
        }

        public void setItem(Friend item){
            textView.setText(item.getName());
            textView2.setText(item.getDescription());
        }
    }

    public void addItem(Friend item){
        items.add(item);
    }

    public void setItems(ArrayList<Friend> items){
        this.items = items;
    }

    public Friend getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Friend item){
        items.set(position, item);
    }


}
