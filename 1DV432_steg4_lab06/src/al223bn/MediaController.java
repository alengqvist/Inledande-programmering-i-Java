package al223bn;

import java.io.IOException;

import baseMedia.Media;


/** 
 * This class works like an Controller that handles the selections which the user makes.
 * (EXIT / CREATE / DELETE / SEARCH / SORT)
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 12:40, June 30, 2015.
 */
public class MediaController {
	
	// Define and initialize variables.
	private static final String FILENAME = "mediaregister.txt";		// Filename you want to write to.
	
	private boolean stopped = false;								// Controls if the program has stopped.
	private MediaView mediaView;									// Instance of MediaView.
	private MediaRegister mediaRegister;							// Instance of MediaRegister.
	
	
	public void run() {
				
		// Initialize instances of View and Register (Model).
		mediaView = new MediaView();
    	mediaRegister = new MediaRegister();
    	
		// Try load the ArrayList from file.
		try {
			mediaRegister.loadReg(FILENAME);
		} catch (ClassNotFoundException | IOException e) {
			mediaView.showMessage("Fel inträffade vid läsning till filen.");
		}

		while (!stopped) {
			
			// Get the ArrayList and display it for the user.
    		mediaView.showAll(mediaRegister.getAllMedia());
    		
    		// Show MainMenu.
    		mediaView.showMainMenu();
    		    		
    		// Check which selection the user makes from the MainMenu.
	    	switch (mediaView.getMainMenuSelection()) {
	    	
		    	// EXIT.
		    	case 0:
		    		mediaView.showExit();
		    		stopped = true;
		    		System.exit(0);
		    		
		    	// CREATE.
		    	case 1:
		    		
		    		// Get Media from user inputs.
		    		Media media = mediaView.getMediaToCreate();
		    		
		    		if (media != null) {
		    			
			    		// Add a Media to the ArrayList.
		    			mediaRegister.addMedia(media);
		    		}
		    		
		    		// Save the ArrayList to the file.
					try {
						mediaRegister.saveReg(FILENAME);
					} catch (IOException e) {
						mediaView.showMessage("Fel inträffade vid skrivning till filen.");
					}
		    		break;
		    	
	    		// DELETE.
		    	case 2:
		    		
		    		// Get the size of the ArrayList.
		    		int size = mediaRegister.getCount();
		    		
		    		// If a Media exists in the ArrayList.
		    		if (size != 0) {
		    			
		    			// Get the index of the Media the user wants to delete.
			    		int mediaToDelete = mediaView.getMediaToDelete(size);
	
			    		// If user selected a Media to delete.
			    		if (mediaToDelete != -1) {
			    			
			    			// Remove that Media from the ArrayList.
			    			mediaRegister.removeMedia(mediaToDelete);
			    			
			    			// Save the updated ArrayList to the file.
							try {
								mediaRegister.saveReg(FILENAME);
							} catch (IOException e) {
								mediaView.showMessage("Fel inträffade vid skrivning till filen.");
							}
			    		}
		    		}
		    		break;
		    		
		    	// SEARCH.
		    	case 3:
		    		
		    		// Get search string to search on.
		    		String query = mediaView.getSearchQuery();
		    		
		    		// Find Media and display the search result.
		    		mediaView.showMedia(query, mediaRegister.findMedia(query));
		    		break;
		    		
		    	// SORT.
		    	case 4:
		    		
		    		// Get which sorting order the user want to use.
		    		String sort = mediaView.getSorting();

		    		if (sort != null) {		
		    			
		    			// Sort the ArrayList with the selected sorting order.
		    			mediaRegister.sortMedia(sort);
		    		}
		    		break;
	    	}
		}
	}
}