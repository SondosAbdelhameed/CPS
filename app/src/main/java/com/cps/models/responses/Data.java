package com.cps.models.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("events_news")
	private List<EventsNewsItem> eventsNews;

	@SerializedName("gallery")
	private List<GalleryItem> gallery;

	public void setGallery(List<GalleryItem> gallery){
		this.gallery = gallery;
	}

	public List<GalleryItem> getGallery(){
		return gallery;
	}

	public void setEventsNews(List<EventsNewsItem> eventsNews){
		this.eventsNews = eventsNews;
	}

	public List<EventsNewsItem> getEventsNews(){
		return eventsNews;
	}

	@Override
	public String toString() {
		return "Data{" +
				"eventsNews=" + eventsNews +
				", gallery=" + gallery +
				'}';
	}
}