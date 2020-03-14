package com.cps.views.events_news;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.EventsNewsItem;
import com.cps.views.EventNewsDetails;

import java.util.List;

public class EventNewsViewModel extends ViewModel {

    EventNewsFragmentRepository repository;

    public EventNewsViewModel() {
        repository = new EventNewsFragmentRepository();
    }

    public LiveData<List<EventsNewsItem>> request_news(/*data to api*/){
        return repository.requestdata(2);
    }

    public LiveData<List<EventsNewsItem>> request_event(/*data to api*/){
        return repository.requestdata(1);
    }


    public void goToEventDetails(View v , EventsNewsItem item){
        Context context = v.getContext();
        if(item != null) {
            Intent intent = new Intent(context, EventNewsDetails.class);
            intent.putExtra("data", item);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}