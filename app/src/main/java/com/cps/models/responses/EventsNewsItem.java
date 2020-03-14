package com.cps.models.responses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import android.widget.RelativeLayout;

import androidx.databinding.BindingAdapter;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static com.cps.helpers.Constant.SERVER_MEDIA_EVENT_NEWS;

public class EventsNewsItem implements Serializable {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("e_n_type")
	private String eNType;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("title")
	private String title;

	@SerializedName("content")
	private String content;

	@SerializedName("status")
	private String status;

	public EventsNewsItem(String updatedAt, String eNType, String createdAt, int id, List<MediaItem> media, String title, String content, String status) {
		this.updatedAt = updatedAt;
		this.eNType = eNType;
		this.createdAt = createdAt;
		this.id = id;
		this.media = media;
		this.title = title;
		this.content = content;
		this.status = status;
	}

/*	@RequiresApi(api = Build.VERSION_CODES.Q)
	protected EventsNewsItem(Parcel in) {
		updatedAt = in.readString();
		eNType = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		title = in.readString();
		content = in.readString();
		status = in.readString();
		media = in.readParcelableList(media,MediaItem.class.getClassLoader());
	}

	public static final Creator<EventsNewsItem> CREATOR = new Creator<EventsNewsItem>() {
		@RequiresApi(api = Build.VERSION_CODES.Q)
		@Override
		public EventsNewsItem createFromParcel(Parcel in) {
			return new EventsNewsItem(in);
		}

		@Override
		public EventsNewsItem[] newArray(int size) {
			return new EventsNewsItem[size];
		}
	};*/

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setENType(String eNType){
		this.eNType = eNType;
	}

	public String getENType(){
		return eNType;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@BindingAdapter("eventNewsImage")
	public static void loadImage(RelativeLayout img , MediaItem mediaItem){
		String image;
		Context context = img.getContext();
		if (mediaItem != null) {
			image = mediaItem.getMedia();

			Picasso.get().load(SERVER_MEDIA_EVENT_NEWS + mediaItem.getMedia()).into(new Target(){

				@Override
				public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
					img.setBackground(new BitmapDrawable(context.getResources(), bitmap));
				}

				@Override
				public void onBitmapFailed(Exception e, Drawable errorDrawable) {
					Log.d("TAG", "FAILED");
				}

				@Override
				public void onPrepareLoad(Drawable placeHolderDrawable) {
					Log.d("TAG", "Prepare Load");
				}
			});

		}else {
			image = "null";
		}
	}

	@Override
 	public String toString(){
		return 
			"EventsNewsItem{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",e_n_type = '" + eNType + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",media = '" + media + '\'' + 
			",title = '" + title + '\'' + 
			",content = '" + content + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

/*	@Override
	public int describeContents() {
		return 0;
	}

	@RequiresApi(api = Build.VERSION_CODES.Q)
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(updatedAt);
		dest.writeString(eNType);
		dest.writeString(createdAt);
		dest.writeInt(id);
		dest.writeString(title);
		dest.writeString(content);
		dest.writeString(status);
		dest.writeParcelableList(media,flags);
	}*/
}