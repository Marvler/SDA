import java.util.Scanner;

public class StartUserInterface {
    private static int choice;
    private static Scanner scanner = new Scanner(System.in);

    public static void displayStartInterface() {
        do {
            System.out.println("Parcel locker section please enter '1'\nPackages section please enter '2'\nCreate sender user '3'\nIf you would like to leave please enter '0'");
            System.out.println();
            System.out.print("What would you like to do? : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ParcelLockerUserInterface.displayParcelLockerInterface();
                    break;
                case 2:
                    PackageUserInterface.displayPackagesInterface();
                    break;
                case 3:
                    Sender sender = new Sender();
                    SenderMangement.listOfSenders.add(sender);
                    break;
                case 0:
                    System.out.println("BYE");
                    break;
                default:
                    System.out.println("Wrong value. Try again");

            }
        } while (choice != 0);
    }
}
