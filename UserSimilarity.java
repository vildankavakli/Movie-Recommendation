package datastructuresproject3;

/**
 *
 * @author Techno
 */
public class UserSimilarity implements Comparable<UserSimilarity> {

    int userId;
    double cosineSimilarity;

    public UserSimilarity(int userId, double cosineSimilarity) {
        this.userId = userId;
        this.cosineSimilarity = cosineSimilarity;
    }

    @Override
    public int compareTo(UserSimilarity t) {
        return (this.cosineSimilarity > t.cosineSimilarity) ? 1 : 0;
        /* Compares two UserSimilarity objects based on their cosineSimilarity values
        Returns a positive value if this.cosineSimilarity > t.cosineSimilarity,
         zero if they are equal, and a negative value if this.cosineSimilarity < t.cosineSimilarity
         */
    }

    @Override
    public String toString() {
        // Converts the cosineSimilarity value to a string representation

        return "" + cosineSimilarity;
    }
}
