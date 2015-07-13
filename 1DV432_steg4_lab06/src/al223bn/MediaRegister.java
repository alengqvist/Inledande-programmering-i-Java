package al223bn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import baseMedia.Media;


/** 
 * This class works like an Model that handles a Register of Media and its methods.
 * (EXIT / CREATE / DELETE / SEARCH / SORT)
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:40, June 30, 2015.
 */
public class MediaRegister {

	// Define and initialize variables.
	private static final String SORT_NAME = "name";
	private static final String SORT_TYPE = "type";

	private ArrayList<Media> mediaReg;		// Register of Medias.

	
	/**
	 * Constructor.
	 */
	public MediaRegister() {
		mediaReg = new ArrayList<Media>();
	}
	
	/**
	 * Adds Media to ArrayList.
	 * 
	 * @param media
	 */
	public void addMedia(Media media) {
		mediaReg.add(media);
	}

	/**
	 * Removes Media from ArrayList.
	 * 
	 * @param pos
	 */
	public void removeMedia(int pos) {
		mediaReg.remove(pos);
	}
	
	/**
	 * Finds Media in ArrayList from search query.
	 * 
	 * @param query
	 * @return Media from position
	 */
	public Media findMedia(String query) {
		int i = 0;
		for (Media media : mediaReg) {
			if (media.getName().contains(query)) {
				return mediaReg.get(i);
			}
			i++;
		}
		return null;
	}

	/**
	 * Sorts Media in ArrayList.
	 * 
	 * @param sort
	 */
	public void sortMedia(String sort) {
		switch (sort) {
		case SORT_NAME:
			Collections.sort(mediaReg, Media.SortOnName);
			break;
		case SORT_TYPE:
			Collections.sort(mediaReg, Media.SortOnType);
			break;
		}
	}

	/**
	 * Saves ArrayList of Medias into file.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public void saveReg(String fileName) throws IOException {

		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);   

		oos.writeObject(mediaReg);
		oos.close(); 
	}

	/**
	 * Reads ArrayList of Medias from file.
	 * 
	 * @param fileName
	 * @throws IOException 
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadReg(String fileName) throws ClassNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);

		mediaReg = (ArrayList<Media>)ois.readObject();
		ois.close();
	}

	/**
	 * Gets the size of the ArrayList.
	 * 
	 * @return size of ArrayList
	 */
	public int getCount() {
		return mediaReg.size();
	}

	/**
	 * Gets the ArrayList of Medias.
	 * 
	 * @return
	 */
	public ArrayList<Media> getAllMedia() {
		return mediaReg;
	}
}