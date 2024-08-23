import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User yangus = new User("Yangus", "yangus@example.com");

        NaturalPark park1 = new NaturalPark("Parc National de Zahamena", -17.75, 48.75, "Un parc célèbre pour sa biodiversité.");
        NaturalPark park2 = new NaturalPark("Parc National d'Analamazaotra", -18.93, 48.42, "Un parc avec une grande population de lémuriens.");
        NaturalPark park3 = new NaturalPark("Parc National de Masoala", -15.72, 50.18, "Le plus grand parc national de Madagascar.");
        NaturalPark park4 = new NaturalPark("Parc National de Betampona", -17.93, 49.20, "Un parc naturel riche en faune et flore endémiques.");


        Hotel hotel1 = new Hotel("Hotel Toamasina", -17.65, 48.72, "Un hôtel moderne en plein centre de Tamatave.", "0341122334", "contact@toamasina.mg");
        Hotel hotel2 = new Hotel("Hotel Foulpointe", -17.67, 49.02, "Un hôtel proche de la plage de Foulpointe.", "0342233445", "contact@foulpointe.mg");
        Hotel hotel3 = new Hotel("Hotel Ambila", -18.00, 48.83, "Un hôtel au bord du lac Ambila.", "0343344556", "contact@ambila.mg");
        Hotel hotel4 = new Hotel("Hotel Manambato", -17.82, 49.15, "Un hôtel à proximité du lac Rasoabe.", "0344455667", "contact@manambato.mg");


        hotel1.addRoom(new Room(101, 100.000));
        hotel2.addRoom(new Room(102, 200.000));
        hotel3.addRoom(new Room(103, 300.000));
        hotel4.addRoom(new Room(104, 400.000));

        // Association des hotels aux parcs nationals
        park1.addHotel(hotel1);
        park2.addHotel(hotel2);
        park3.addHotel(hotel3);
        park4.addHotel(hotel4);


        Review review1 = new Review("Rakoto Jean", "rakoto@gmail.com", 2, "Le service n'est pas de qualité", LocalDate.of(2024, 8, 18));
        hotel1.addReview(review1);

        Review review2 = new Review("Mimi", "mimi@gmail.com", 4, "Magnifique hôtel!", LocalDate.of(2024, 8, 19));
        hotel2.addReview(review2);



        Map map = new Map();
        map.addPark(park1);
        map.addPark(park2);
        map.addPark(park3);
        map.addPark(park4);



        System.out.println("=== Tous les avis ===");
        for (Review review : map.getAllReviews()) {
            System.out.println(review.getComment());
        }


        System.out.println("\n=== Yangus demande le meilleur hôtel ===");
        Hotel bestHotel = yangus.requestBestHotel(map);
        if (bestHotel != null) {
            System.out.println("Le meilleur hôtel est : " + bestHotel.getName());
        }


        System.out.println("\n=== Yangus demande tous les endroits dans une région spécifique ===");
        List<Place> placesInside = yangus.requestPlacesInside(map, -18.0, -17.0, 48.0, 50.0);
        for (Place place : placesInside) {
            System.out.println(place.getName() + " se trouve à l'intérieur de la région spécifiée.");
        }


        System.out.println("\n=== Yangus demande le prix minimum total pour les hôtels ===");
        List<NaturalPark> parksToVisit = new ArrayList<>();
        parksToVisit.add(park1);
        parksToVisit.add(park2);
        double totalCost = yangus.requestCheapestHotelPrice(map, parksToVisit);
        System.out.println("Le montant minimum total pour les frais d'hôtel est : " + totalCost);


        System.out.println("\n=== Yangus demande tous les items ayant reçu des avis ===");
        List<Reviewable> reviewedItems = yangus.requestAllReviewedItems(map);
        for (Reviewable item : reviewedItems) {
            if (item instanceof Place) {
                System.out.println(((Place) item).getName() + " a reçu un avis.");
            }
        }
    }
}
