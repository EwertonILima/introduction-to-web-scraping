package com.ewertonilima.webscraping.entity;

public class News {
	private String url;
	private String title;
	private String subtitle;
	private String author;
	private String date;
	private String text;

	public News() {
	}

	public News(String url, String title, String subtitle, String author, String date, String text) {
		super();
		this.url = url;
		this.title = title;
		this.subtitle = subtitle;
		this.author = author;
		this.date = date;
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Url = ");
		builder.append(url);
		builder.append(", Title = ");
		builder.append(title);
		builder.append(", Subtitle = ");
		builder.append(subtitle);
		builder.append(", Author = ");
		builder.append(author);
		builder.append(", Date = ");
		builder.append(date);
		builder.append(", Text = ");
		builder.append(text);
		return builder.toString();
	}

}
