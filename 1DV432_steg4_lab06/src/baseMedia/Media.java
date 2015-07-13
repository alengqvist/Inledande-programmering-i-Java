package baseMedia;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Media implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	
	
	public Media(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
    /**
     * Sort Name ascending.
     */
    public static Comparator<Media> SortOnName = new Comparator<Media>() {

        public int compare(Media s1, Media s2) {
            return s1.getName().toUpperCase().compareTo(s2.getName().toUpperCase());
        }
    };
    
    /**
     * Sort Type ascending.
     */
    public static Comparator<Media> SortOnType = new Comparator<Media>() {

        public int compare(Media s1, Media s2) {
            return s1.getType().toUpperCase().compareTo(s2.getType().toUpperCase());
        }
    };
}
