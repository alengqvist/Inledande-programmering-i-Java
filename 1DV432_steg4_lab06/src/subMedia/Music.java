package subMedia;

import baseMedia.Media;

public class Music extends Media {

	private static final long serialVersionUID = 1L;
	private int minutes;

	public int getMinutes() {
		return this.minutes;
	}

	public Music(String name, String type, int minutes) {
		super(name, type);
		this.minutes = minutes;
	}

	public String toString() {
		return getType() + " - " + getName() + "\n   LŠngd i minuter: " + getMinutes() + "\n\n";
	}
}
