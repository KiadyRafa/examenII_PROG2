import java.util.List;
import  java.util.ArrayList;

class Map {
    private List<NaturalPark> parks;

    public Map() {
        this.parks = new ArrayList<>();
    }

    public void addPark(NaturalPark park) {
        parks.add(park);
    }

    public List<Review> getAllReviews() {
        List<Review> allReviews = new ArrayList<>();
        for (NaturalPark park : parks) {
            allReviews.addAll(park.getAllReviews());
            for (Hotel hotel : park.getNearbyHotels()) {
                allReviews.addAll(hotel.getAllReviews());
                for (Room room : hotel.getRooms()) {
                    allReviews.addAll(room.getAllReviews());
                }
            }
        }
        return allReviews;
    }

    public Hotel findBestHotel() {
        Hotel bestHotel = null;
        int maxNearbyParks = 0;
        for (NaturalPark park : parks) {
            for (Hotel hotel : park.getNearbyHotels()) {
                int count = 0;
                for (NaturalPark p : parks) {
                    if (p.getNearbyHotels().contains(hotel)) {
                        count++;
                    }
                }
                if (count > maxNearbyParks) {
                    maxNearbyParks = count;
                    bestHotel = hotel;
                } else if (count == maxNearbyParks) {
                    if (Math.random() > 0.5) {
                        bestHotel = hotel;
                    }
                }
            }
        }
        return bestHotel;
    }

    public List<Place> getAllPlacesInside(double minLat, double maxLat, double minLong, double maxLong) {
        List<Place> placesInside = new ArrayList<>();
        for (NaturalPark park : parks) {
            if (park.getLatitude() >= minLat && park.getLatitude() <= maxLat && park.getLongitude() >= minLong && park.getLongitude() <= maxLong) {
                placesInside.add(park);
            }
            for (Hotel hotel : park.getNearbyHotels()) {
                if (hotel.getLatitude() >= minLat && hotel.getLatitude() <= maxLat && hotel.getLongitude() >= minLong && hotel.getLongitude() <= maxLong) {
                    placesInside.add(hotel);
                }
            }
        }
        return placesInside;
    }

    public double findCheapestHotelPrice(List<NaturalPark> selectedParks) {
        double totalPrice = 0;
        for (NaturalPark park : selectedParks) {
            double cheapestPrice = Double.MAX_VALUE;
            for (Hotel hotel : park.getNearbyHotels()) {
                for (Room room : hotel.getRooms()) {
                    if (room.getPricePerNight() < cheapestPrice) {
                        cheapestPrice = room.getPricePerNight();
                    }
                }
            }
            totalPrice += cheapestPrice;
        }
        return totalPrice;
    }

    public List<Reviewable> getAllReviewedItems() {
        List<Reviewable> reviewedItems = new ArrayList<>();
        for (NaturalPark park : parks) {
            if (!park.getAllReviews().isEmpty()) {
                reviewedItems.add(park);
            }
            for (Hotel hotel : park.getNearbyHotels()) {
                if (!hotel.getAllReviews().isEmpty()) {
                    reviewedItems.add(hotel);
                }
                for (Room room : hotel.getRooms()) {
                    if (!room.getAllReviews().isEmpty()) {
                        reviewedItems.add(room);
                    }
                }
            }
        }
        return reviewedItems;
    }
}