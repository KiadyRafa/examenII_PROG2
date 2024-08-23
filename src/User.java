import java.time.LocalDate;
import java.util.List;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addReview(Reviewable reviewableItem, int score, String comment, LocalDate date) {
        Review review = new Review(this.name, this.email, score, comment, date);
        reviewableItem.addReview(review);
    }

    public Hotel requestBestHotel(Map map) {
        return map.findBestHotel();
    }

    public double requestCheapestHotelPrice(Map map, List<NaturalPark> parksToVisit) {
        return map.findCheapestHotelPrice(parksToVisit);
    }

    public List<Place> requestPlacesInside(Map map, double minLat, double maxLat, double minLong, double maxLong) {
        return map.getAllPlacesInside(minLat, maxLat, minLong, maxLong);
    }

    public List<Reviewable> requestAllReviewedItems(Map map) {
        return map.getAllReviewedItems();
    }
}
