package subMedia;

import baseMedia.Media;

public class Photo extends Media {

	private static final long serialVersionUID = 1L;

	public Photo(String name, String type) {
		super(name, type);
	}

	public String toString() {
		return getType() + " - " + getName() + "\n\n";
	}
}
