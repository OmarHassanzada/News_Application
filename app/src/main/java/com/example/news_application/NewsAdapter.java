package com.example.news_application;

import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private ArrayList<News> newsList;
    private NewsClickListener newsClickListener;

    public NewsAdapter(ArrayList<News> newsList, NewsClickListener newsClickListener) {
        this.newsList = newsList;
        this.newsClickListener = newsClickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view, newsClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsImageView.setImageResource(news.getImageResource());
        holder.newsTitleTextView.setText(news.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                newsClickListener.onNewsClick(clickedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public interface NewsClickListener {
        void onNewsClick(int position);
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private ImageView newsImageView;
        private TextView newsTitleTextView;
        private NewsClickListener newsClickListener;

        public NewsViewHolder(@NonNull View itemView, NewsClickListener newsClickListener) {
            super(itemView);
            this.newsClickListener = newsClickListener;
            newsImageView = itemView.findViewById(R.id.news_image_view);
            newsTitleTextView = itemView.findViewById(R.id.news_title_text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            newsClickListener.onNewsClick(getAdapterPosition());
        }
    }
}

