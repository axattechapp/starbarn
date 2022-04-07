package com.axat.starbarn.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.starbarn.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.searViewHolder> {
    List<String> moviesListAll;

    public SearchAdapter() {
    }

    public SearchAdapter(List<String> moviesListAll) {
        this.moviesListAll = moviesListAll;
    }

    @NonNull
    @Override
    public SearchAdapter.searViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_item, parent, false);
        searViewHolder viewHolder = new searViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.searViewHolder holder, int position) {
        holder.textView.setText(moviesListAll.get(position));
        holder.textView1.setText(moviesListAll.get(position));
        holder.textView2.setText(moviesListAll.get(position));
        holder.textView3.setText(moviesListAll.get(position));
        holder.textView4.setText(moviesListAll.get(position));
        Log.e("list","list"+moviesListAll.get(position));

    }

    @Override
    public int getItemCount() {
        return moviesListAll.size();
    }

    public class searViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        public searViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.searchfilterText);
            textView1=itemView.findViewById(R.id.searchfilterText1);
            textView2=itemView.findViewById(R.id.searchfilterText2);
            textView3=itemView.findViewById(R.id.searchfilterText3);
            textView4=itemView.findViewById(R.id.searchfilterText4);
        }
    }
}
