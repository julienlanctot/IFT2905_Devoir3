//Filtre

package org.techtown.recherche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication2.R;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder>{

    ArrayList<Filter> items = new ArrayList<Filter>();
    OnBindCallback4 onBind;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.filter_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Filter item = items.get(position);
        viewHolder.setItem(item);
        if(onBind != null){
            onBind.onViewBound4(viewHolder, position);
        }
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox checkBox;


        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }

        public void setItem(Filter item){
            textView.setText(item.getFilterName());
        }
        public void togCheckBox(){ checkBox.toggle();}
    }

    public void addItem(Filter item){
        items.add(item);
    }

    public void setItems(ArrayList<Filter> items){
        this.items = items;
    }

    public Filter getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Filter item){
        items.set(position, item);
    }



}
