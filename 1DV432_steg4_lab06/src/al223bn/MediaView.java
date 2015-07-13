package al223bn;

import java.util.ArrayList;
import java.util.Scanner;
import baseMedia.Media;
import subMedia.Book;
import subMedia.Journal;
import subMedia.Movie;
import subMedia.Music;
import subMedia.Photo;


/** 
 * This class work like an Console View and handles all the inputs and outputs the user makes.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:40, June 30, 2015.
 */
public class MediaView {

	// Define and initialize variables.
	private static final String BOOK = "Bok";
	private static final String MOVIE = "Film";
	private static final String PHOTO = "Foto";
	private static final String MUSIC = "Musik";
	private static final String JOURNAL = "Tidskrift";
	
	private static final String SORT_NAME = "name";
	private static final String SORT_TYPE = "type";
	
	private Scanner input = new Scanner(System.in);		// Instance of Scanner for input.
	
	
	/**
	 * Shows a message if the program has stopped.
	 */
	public void showExit() {
		System.out.println("Programmet har avslutats.");
	}
	
	/**
	 * Shows MainMenu selections.
	 */
	public void showMainMenu() {
			System.out.println("0. Avsluta    #    1. Lägg till media    #    2. Ta bort media    #    3. Sök    #    4. Sortera\n");
	}
	
	/**
	 * Shows the Media the user searched for or an No Found-message if no Media was found.
	 * 
	 * @param query - the searched string
	 * @param media - the found media
	 */
	public void showMedia(String query, Media media) {
		
		if (media == null) {
			System.out.printf("Kunde inte hitta något Media med sökordet: %s.\n", query);
		} else {
			System.out.println("Media hittad!");
			System.out.println(media.toString());
		}
		System.out.println("Tryck valfri tangent och Enter för att återgå till huvudmenyn.");
		input.next();
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * Shows all Medias in the ArrayList.
	 * 
	 * @param medias - ArrayList of Media
	 */
	public void showAll(ArrayList<Media> medias) {
		
		if ( medias.isEmpty()) {
			System.out.println("Det finns inga medier att visa.\n");
			return;
		}
		
		int i = 0;
		
		// For each Media in the ArrayList.
		for (Media media : medias) {
			i++;
			System.out.printf(i + ". " + media.toString());
		}
	}
	
	/**
	 * Checks which selection user makes from the MainMenu.
	 * 
	 * @return number - the selected id
	 */
	public int getMainMenuSelection() {
		while (true) {
			if (isValid()) {
				
		        int number = input.nextInt();
		    	if (number >= 0 && number <= 5) {
		    		return number;
		    	} else {
		            System.out.println("Du måste ange ett alternativ mellan 0 - 5!");
		    	}
			}
		}
	}
	
	/**
	 * Gets the search input from the user.
	 * 
	 * @return query - string to search for
	 */
	public String getSearchQuery() {
		System.out.println("Sök på ett media genom att ange dess namn:\n");		
		return input.next();
	}
	
	/**
	 * Shows sort selections.
	 * 
	 * @return sort - the sorting order
	 */
	public String getSorting() {
		System.out.println("0. Tillbaka    #    1. Sortera på Namn    #    2. Sortera på Typ\n");
		
		String sort = null;

		while (true) {
			
			if (isValid()) {
				
		        int number = input.nextInt();
		    	if (number >= 0 && number <= 3) {
		    		
					switch (number) {
				        case 0:
				        	sort = null;
				        	break;
				        case 1:
				        	sort = SORT_NAME;
				        	break;       
				        case 2:
				        	sort = SORT_TYPE;
				        	break;
					}					
					return sort;
				} else {
		            System.out.println("Du måste ange ett alternativ mellan 0 - 2!");
		    	}
			}
		}
	}
	
	/**
	 * Method which creates a Media-object from one of the known types.
	 * 
	 * @param count - to keep track of which id the newly created Media should get
	 * @return media - the created Media-object
	 */
	public Media getMediaToCreate() {

		System.out.println("Välj vilken typ av media du vill lägga till:");
		System.out.println("0 - Avbryt");
		System.out.println("1 - Bok");
		System.out.println("2 - Film");
		System.out.println("3 - Foto");
		System.out.println("4 - Musik");
		System.out.println("5 - Tidsskrift");
				
		String type = null;		// Which type of Media.
		Media media = null;		// The created Media.
		
		while (true) {
			
			if (isValid()) {
				
		        int number = input.nextInt();
		    	if (number >= 0 && number <= 5) {
		    		
					switch (number) {
				        case 0:
				        	return null;
				        case 1:
				        	type = BOOK;
							media = new Book(getMediaName(type), type, getMediaSize(type));
				        	break;
				        case 2: 
				        	type = MOVIE;
							media = new Movie(getMediaName(type), type, getMediaSize(type));
				        	break;
				        case 3:
				        	type = PHOTO;
							media = new Photo(getMediaName(type), type);
				        	break;	       
				        case 4:
				        	type = MUSIC;
							media = new Music(getMediaName(type), type, getMediaSize(type));
				        	break;
				        case 5:
				        	type = JOURNAL;
							media = new Journal(getMediaName(type), type, getMediaSize(type));
				        	break;
					}					
					return media;
				} else {
		            System.out.println("Du måste ange ett alternativ mellan 0 - 5!");
		    	}
			}
		}
	}
	
	/**
	 * Method which gets the index of a created Media-object shown in the ArrayList.
	 * 
	 * @param size - the size of the ArrayList
	 * @return index - the index of the position in the ArrayList
	 */
	public int getMediaToDelete(int size) {

		System.out.println("Ange ID:t för det media du vill ta bort (Ange 0 för att avbryta):");

		while (true) {
			if (input.hasNextInt()) {

				int index = input.nextInt();
				
				if (index == 0) {
					return -1;
				}
				
				if (index > 0 && index <= size) {
					return index - 1;	
				} else {
					System.out.printf("Den angivna siffran måste vara inom den valbara gränsen 1 - %d.\n", size);
				}
			} else {
				input.next();
				return -1;
			}
		}
	}
	
	/**
	 * Gets the name of the Media from user input.
	 * 
	 * @param type - the type of Media
	 * @return name - the name of the Media
	 */
	public String getMediaName(String type) {
		
		switch (type) {
	        case BOOK:
	    		System.out.println("Ange bokens namn:");
	        	break;
	        case MOVIE: 
	    		System.out.println("Ange filmens namn:");
	        	break;      
	        case PHOTO: 
	    		System.out.println("Ange fotografiets namn:");
	        	break;      
	        case MUSIC:
	    		System.out.println("Ange låtens namn:");
	        	break;
	        case JOURNAL:
	    		System.out.println("Ange tidskriftens namn:");
	        	break;
		}
		return input.next();		
	}
	
	/**
	 * Gets the size of the Media from user input.
	 * 
	 * @param type - the type of Media
	 * @return name - the size of the Media
	 */
	public int getMediaSize(String type) {
		
		switch (type) {
	        case BOOK:
	    		System.out.println("Ange hur många sidor boken har:");
	        	break;
	        case MOVIE: 
	    		System.out.println("Ange hur lång filmen är i minuter:");
	        	break;      
	        case MUSIC:
	    		System.out.println("Ange hur lång låten är i minuter:");
	        	break;
	        case JOURNAL:
	    		System.out.println("Ange hur många sidor tidskriften har:");
	        	break;
		}
		
		while (true) {
			if (isValid()) {
				return input.nextInt();		
			}
		}
	}
	
	/**
	 * Method which checks if the entered input is valid.
	 * 
	 * @return boolean - if its valid or not
	 */
	private boolean isValid() {
		
		// If user entered a invalid input.
        if (!input.hasNextInt()) {
            System.out.println("Du kan endast skriva in siffror!");
        	input.next();
        	return false;
        }
        return true;
	}
}
