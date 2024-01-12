package datastructuresproject3;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Techno
 */
public class Utility {

    public static UserSimilarity cosineSimilarity(Map map, int id1, int id2) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        // Iterate over the columns (from 1 to 9018)
        for (int i = 1; i <= 9018; i++) {
            // Get the ratings for user1 and user2 for the current column
            int user1 = (int) map.getOrDefault(new Position(id1, i), 0);
            int user2 = (int) map.getOrDefault(new Position(id2, i), 0);

            // Calculate the dot product
            dotProduct += user1 * user2;

            // Calculate the norms
            normA += Math.pow(user1, 2);
            normB += Math.pow(user2, 2);
        }

        // Calculate the cosine similarity
        double result = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));

        // Create and return a UserSimilarity object
        return new UserSimilarity(id2, result);
    }

    public static File getFile(String message) {
        // Create a new file chooser dialog
        JFileChooser fileChooser = new JFileChooser();

        // Set the dialog title
        fileChooser.setDialogTitle(message);

        // Limit selectable file types to CSV files using a FileNameExtensionFilter
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(filter);

        // Show the file chooser dialog and get the return value
        int returnValue = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Return the selected file
            return fileChooser.getSelectedFile();
        } else {
            // Return null if no file was selected
            return null;
        }
    }

}
