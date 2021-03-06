package com.cps.views.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.EventsNewsItem;
import com.cps.views.admission.Admission;
import com.cps.views.Notification;
import com.cps.views.contact.ContactUs;
import com.cps.views.EventNewsDetails;
import com.cps.views.gallery.Gallery;

public class HomeViewModel extends ViewModel {


    final MutableLiveData<EventsNewsItem> newsLiveData = new MutableLiveData<>();
    final MutableLiveData<EventsNewsItem> eventLiveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();


    void request_news(/*data to api*/) {
        HomeFragmentRepository.requestNews(2, newsLiveData, errorLiveData);
    }

    void request_event(/*data to api*/) {
        HomeFragmentRepository.requestNews(1, eventLiveData, errorLiveData);
    }

    public void goToContact(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, ContactUs.class));
    }

    public void goToAdmission(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, Admission.class));
    }

    public void goToGallery(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, Gallery.class));
    }

    public void goToNotification(View v){
        Context context = v.getContext();
        context.startActivity(new Intent(context, Notification.class));
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