package com.afollestad.mvpanddaggerexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.afollestad.mvpanddaggerexample.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Aidan Follestad (afollestad)
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainVH> {

    public interface ClickListener {
        void onClick(int index);
    }

    private ClickListener listener;
    private List<String> items;

    public MainAdapter(ClickListener listener) {
        this.listener = listener;
    }

    public void setItems(List<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public MainVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_main, parent, false);
        return new MainVH(view, this);
    }

    @Override
    public void onBindViewHolder(MainVH holder, int position) {
        String item = items.get(position);
        Glide.with(holder.itemView.getContext())
                .load(item)
                .crossFade()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    static class MainVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        final MainAdapter adapter;
        @BindView(R.id.image)
        ImageView image;

        MainVH(View itemView, MainAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (adapter != null && adapter.listener != null) {
                adapter.listener.onClick(getAdapterPosition());
            }
        }
    }
}