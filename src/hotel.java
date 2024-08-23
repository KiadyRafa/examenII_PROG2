import java.util.List;
import java.util.ArrayList;

class Hotel extends Place implements Reviewable {
    private String contactPhone;
    private String contactEmail;
    private List<Room> rooms;
    private List<Review> reviews;

    public Hotel(String name, double latitude, double longitude, String description, String contactPhone, String contactEmail) {
        super(name, latitude, longitude, description);
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.rooms = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }
}

class NaturalPark extends Place implements Reviewable {
    private List<Hotel> nearbyHotels;
    private List<Review> reviews;

    public NaturalPark(String name, double latitude, double longitude, String description) {
        super(name, latitude, longitude, description);
        this.nearbyHotels = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        nearbyHotels.add(hotel);
    }

    public List<Hotel> getNearbyHotels() {
        return nearbyHotels;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }
}

class Room implements Reviewable {
    private int number;
    private double pricePerNight;
    private List<Review> reviews;

    public Room(int number, double pricePerNight) {
        this.number = number;
        this.pricePerNight = pricePerNight;
        this.reviews = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }
}
