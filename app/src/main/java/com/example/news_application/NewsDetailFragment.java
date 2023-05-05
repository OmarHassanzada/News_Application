package com.example.news_application;

import java.util.Arrays;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


public class NewsDetailFragment extends Fragment {

    private ImageView newsImage;
    private TextView newsTitle;
    private TextView newsDescription;
    private RecyclerView relatedNewsRecyclerView;

    //dummy information loaded into the the list to check if the images are displaying correctly
    private News relatedNews1 = new News(R.drawable.default_news_image, "Related News 1", "Description of related news 1");
    private News relatedNews2 = new News(R.drawable.default_news_image, "Related News 2", "Description of related news 2");
    private News relatedNews3 = new News(R.drawable.default_news_image, "Related News 3", "Description of related news 3");
    private News relatedNews4 = new News(R.drawable.default_news_image, "Related News 4", "Description of related news 4");
    private News relatedNews5 = new News(R.drawable.default_news_image, "Related News 5", "Description of related news 5");
    private News relatedNews6 = new News(R.drawable.default_news_image, "Related News 6", "Description of related news 6");
    private ArrayList<News> relatedNewsList = new ArrayList<>(Arrays.asList(relatedNews1, relatedNews2, relatedNews3, relatedNews4, relatedNews5, relatedNews6));

    public NewsDetailFragment() {
        // empty contructor is required from main
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // here we use inflater to inflate layout
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        // receiving news info from main through bundle
        Bundle bundle = getArguments();
        News selectedNews = bundle.getParcelable("selected_news");

        // creating the (recycler) views
        newsImage = view.findViewById(R.id.news_detail_image_view);
        newsTitle = view.findViewById(R.id.news_detail_title_text_view);
        newsDescription = view.findViewById(R.id.news_detail_description_text_view);
        relatedNewsRecyclerView = view.findViewById(R.id.related_news_recycler_view);

        // data from bundle is set into the views
        newsImage.setImageResource(selectedNews.getImageResource());
        newsTitle.setText(selectedNews.getTitle());
        newsDescription.setText(selectedNews.getDescription());

        // and the related news into the recycler
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        relatedNewsRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(relatedNewsList, position -> {
            // Handle related news click events
        });
        relatedNewsRecyclerView.setAdapter(newsAdapter);

        return view;
    }

}

