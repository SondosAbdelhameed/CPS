package com.cps.views.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.GalleryItem;

import java.util.List;

public class GalleryViewModel extends ViewModel {

    GalleryRepository repository;

    public GalleryViewModel() {
        repository = new GalleryRepository();
    }

    public LiveData<List<GalleryItem>> request_news(/*data to api*/){
        return repository.requestdata();
    }
}
