import java.util.List;

interface Reviewable {
    void addReview(Review review);
    List<Review> getAllReviews();
}

abstract class Place {
    protected String name;
    protected double latitude;
    protected double longitude;
    protected String description;

    public Place(String name, double latitude, double longitude, String description) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }
}
