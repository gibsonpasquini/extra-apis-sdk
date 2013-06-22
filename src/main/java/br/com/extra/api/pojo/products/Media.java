package br.com.extra.api.pojo.products;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Media implements Serializable {

	private static final long serialVersionUID = -6489154153784093554L;

	private List<Image> images;

	private List<Video> videos;

	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
