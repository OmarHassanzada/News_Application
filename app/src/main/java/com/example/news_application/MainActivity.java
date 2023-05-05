package com.example.news_application;

import android.os.Bundle;
import java.util.ArrayList;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;




public class MainActivity extends AppCompatActivity implements NewsAdapter.NewsClickListener {

    // Declare RecyclerViews, adapters and lists for top stories, news, and related news
    private RecyclerView topStoriesRecyclerView;
    private RecyclerView newsRecyclerView;
    private NewsAdapter topStoriesAdapter;
    private NewsAdapter newsAdapter;
    private ArrayList<News> topStoriesList;
    private ArrayList<News> newsList;
    private ArrayList<RelatedNews> relatedNewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating RecyclerViews, adapters and lists for top stories, news, and related news
        topStoriesRecyclerView = findViewById(R.id.top_stories_recycler_view);
        newsRecyclerView = findViewById(R.id.news_recycler_view);
        topStoriesList = new ArrayList<>();
        newsList = new ArrayList<>();
        relatedNewsList = new ArrayList<>();

        // here we are adding dummy data to check if the top news story list is displaying correctly
        topStoriesList.add(new News(R.drawable.default_news_image, "Top Story 1", "Description 1"));
        topStoriesList.add(new News(R.drawable.default_news_image, "Top Story 2", "Description 2"));
        topStoriesList.add(new News(R.drawable.default_news_image, "Top Story 3","Description 3"));
        topStoriesList.add(new News(R.drawable.default_news_image, "Top Story 4" ,"Description 4"));

        // here we are adding dummy data to check if the news list is displaying correctly
        newsList.add(new News(R.drawable.default_news_image, "News 1","Description 1"));
        newsList.add(new News(R.drawable.default_news_image, "News 2" ,"Description 2"));
        newsList.add(new News(R.drawable.default_news_image, "News 3","Description 3"));
        newsList.add(new News(R.drawable.default_news_image, "News 4" ,"Description 4"));
        newsList.add(new News(R.drawable.default_news_image, "News 5","Description 5"));
        newsList.add(new News(R.drawable.default_news_image, "News 6" ,"Description 6"));
        newsList.add(new News(R.drawable.default_news_image, "News 7","Description 7"));
        newsList.add(new News(R.drawable.default_news_image, "News 8" ,"Description 8"));

        // here we are setting the recyclers for top stories and news
        topStoriesAdapter = new NewsAdapter(topStoriesList, this);
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topStoriesRecyclerView.setAdapter(topStoriesAdapter);

        newsAdapter = new NewsAdapter(newsList, this);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        newsRecyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void onNewsClick(int position) {
        // When a news item is clicked, show the news detail fragment with related news
        //newsdetail class instance created and then the images and related title and descriptions are then sent through bundle
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selected_news", newsList.get(position));
        bundle.putParcelableArrayList("related_news_list", relatedNewsList);
        newsDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newsDetailFragment).addToBackStack(null).commit();

    }
}
