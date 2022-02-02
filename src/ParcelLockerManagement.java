import java.util.ArrayList;
import java.util.Scanner;

class ParcelLockerManagement {
    static ArrayList<ParcelLocker> listOfParcelLockers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static void addParcelLocker() {
        String id = validateTypedID();
        String name = validateTypedLockerName();
        String[] address = getAddressFromConsole();
        listOfParcelLockers.add(new ParcelLocker(id, name, address));
        ParcelLockerUserInterface.displayParcelLockerInterface();
    }

    private static String validateTypedLockerName() {
        System.out.println("Type locker name: ");
        String name = scanner.next();
        while (name.length() == 0 || name.isBlank()) {
            System.out.println("Locker name cannot be empty! Try again: ");
            name = scanner.next();
        }
        return name;
    }

    private static String validateTypedID() {
        System.out.println("Type locker ID according to format ( 5 digits -> first 3 letter, last 2 -> digits) : ");
        String id = scanner.next();
        while (!id.matches("[a-zA-Z]{3}[0-9]{2}")) {
            System.out.println("Wrong ID format. Try again");
            id = scanner.next();
        }
        return id;
    }

    private static String[] getAddressFromConsole() {
        System.out.println("Type address using format: [street, city, postal code]");
        System.out.println("Type Street: ");
        String street = scanner.next();
        System.out.println("Type City: ");
        String city = scanner.next();
        System.out.println("Type Postal Code: ");
        String postalCode = scanner.next();

        return new String[]{street, city, postalCode};
    }

    static void removeParcelLocker() {
        System.out.println("Please type ID of locker that you would like to remove");
        String id = PackageManagement.errorCommunicate("ID cannot be empty!. Try again");
        ParcelLocker parcel = getParcelLocker(id);
        if (parcel != null) {
            listOfParcelLockers.remove(parcel);
            System.out.println("Parcel locker with id " + id + " was succesfully removed");
        } else {
            System.out.println("Parcel locker with id " + id + " cannot be found");
        }
        ParcelLockerUserInterface.displayParcelLockerInterface();
    }

    static ParcelLocker getParcelLocker(String id) {
        ParcelLocker parcel = null;
        for (ParcelLocker parcelLocker : listOfParcelLockers
        ) {
            if (parcelLocker.getId().equals(id)) {
                parcel = parcelLocker;
            }
        }
        return parcel;
    }

    static void displayAllParcelLockers() {
        for (ParcelLocker parcelLocker : listOfParcelLockers) {
            System.out.println(parcelLocker.toString());
        }
        ParcelLockerUserInterface.displayParcelLockerInterface();
    }

    static void displayParcelsByCity() {
        System.out.println("Type from which city the parcel lockers should be displayed: ");
        String city = scanner.next();
        for (ParcelLocker parcelLocker : listOfParcelLockers
        ) {
            if (parcelLocker.getAddress()[1].toLowerCase().equals(city.toLowerCase())) {
                System.out.println(parcelLocker.toString());
            }
        }
        ParcelLockerUserInterface.displayParcelLockerInterface();

    }

    static void updateParcelLocker() {
        System.out.println("Please type ID of locker that you would like to update");
        String id = scanner.next();
        ParcelLocker parcelLocker = getParcelLocker(id);
        if (parcelLocker != null) {
            String name = validateTypedLockerName();
            String[] address = getAddressFromConsole();
            parcelLocker.setName(name);
            parcelLocker.setAddress(address);
            System.out.println("Parcel locker with id " + id + "was succesfully updated");

        } else {
            System.out.println("Parcel locker with id " + id + "cannot be found");
        }
        ParcelLockerUserInterface.displayParcelLockerInterface();
    }
}
