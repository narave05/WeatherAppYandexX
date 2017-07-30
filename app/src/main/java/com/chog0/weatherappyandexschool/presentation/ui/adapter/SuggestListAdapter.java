package com.chog0.weatherappyandexschool.presentation.ui.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chog0.weatherappyandexschool.R;
import com.chog0.weatherappyandexschool.model.app_model.CitySuggest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuggestListAdapter extends RecyclerView.Adapter<SuggestListAdapter.SuggestViewHolder> {

    private List<CitySuggest> citySuggests;
    private OnItemClickListener onItemClickListener;
    private int selectedItemPosition = -1;
    private boolean isLocked;

    public SuggestListAdapter(List<CitySuggest> citySuggests,
                              OnItemClickListener onItemClickListener) {
        this.citySuggests = citySuggests;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public SuggestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.suggest_list_item, parent, false);

        SuggestViewHolder suggestViewHolder = new SuggestViewHolder(inflatedView);
        inflatedView.setOnClickListener(v -> {
            final int position = suggestViewHolder.getAdapterPosition();

            if (!isLocked && position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                isLocked = true;
                selectedItemPosition = position;
                notifyItemChanged(position);
                onItemClickListener.onItemClickListener(citySuggests.get(position));
            }
        });
        return suggestViewHolder;
    }

    @Override
    public void onBindViewHolder(final SuggestViewHolder holder, int position) {
        final CitySuggest suggest = citySuggests.get(holder.getAdapterPosition());
        final boolean isChecked = selectedItemPosition == holder.getAdapterPosition();
        holder.bind(suggest, isChecked);
    }

    @Override
    public int getItemCount() {
        return citySuggests.size();
    }

    public void newList(List<CitySuggest> citySuggests){
        this.citySuggests = citySuggests;
        notifyDataSetChanged();
    }

    static class SuggestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.language_text)
        TextView mLanguageText;

        @BindView(R.id.check_icon)
        ImageView checkImage;

        Context mContext;

        SuggestViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        void bind(CitySuggest citySuggest, boolean isChecked) {
            mLanguageText.setText(citySuggest.getDescription());
            int backgroundColor;
            if (isChecked) {
                checkImage.setVisibility(View.VISIBLE);
                backgroundColor = ContextCompat.getColor(mContext, R.color.suggest_list_item_color);
            } else {
                checkImage.setVisibility(View.GONE);
                backgroundColor = Color.WHITE;
            }
            itemView.setBackgroundColor(backgroundColor);
        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(CitySuggest citySuggest);
    }
}

