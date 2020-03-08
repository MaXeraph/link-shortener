package com.example.linkshortener;


public class Link {
	private final String shortLink;

	public Link(String shortLink){
		this.shortLink = shortLink;
    }

    public String getShortLink(){
        return shortLink;
    }
}
