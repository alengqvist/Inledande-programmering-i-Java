package subMedia;

import baseMedia.Media;

public class Journal extends Media {

	private static final long serialVersionUID = 1L;
	private int pages;

	public int getPages() {
		return this.pages;
	}
	
	public Journal(String name, String type, int pages) {
		super(name, type);
		this.pages = pages;
	}

	public String toString() {
		return getType() + " - " + getName() + "\n   Antal sidor: " + pages + "\n\n";
	}
}
