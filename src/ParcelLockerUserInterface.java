import java.util.Scanner;

public class ParcelLockerUserInterface {

    static int choice;
    static Scanner scanner = new Scanner(System.in);

    public static void displayParcelLockerInterface() {
        System.out.println("============================================");
        System.out.print("Choose one of the options.\n1. Adding parcel locker.\n2. Removing parcel locker\n3. Displaying all parcel lockers" +
                "\n4. Displaying parcel lockers by city name.\n5. Updating parcel locker.\n9. Return to Main Menu.\n0. Exit Program\nWhat would you like to do? : ");
        choice = scanner.nextInt();
        System.out.println("============================================");

        switch (choice) {
            case 1:
                ParcelLockerManagement.addParcelLocker();
                break;
            case 2:
                ParcelLockerManagement.removeParcelLocker();
                break;
            case 3:
                ParcelLockerManagement.displayAllParcelLockers();
                break;
            case 4:
                ParcelLockerManagement.displayParcelsByCity();
                break;
            case 5:
                ParcelLockerManagement.updateParcelLocker();
                break;
            case 9:
                StartUserInterface.displayStartInterface();
                break;
            case 0:
                System.out.println("BYE!");
        }

    }
}
