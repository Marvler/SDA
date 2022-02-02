import java.util.Scanner;

class PackageUserInterface {

    private static int choice;
    private static Scanner scanner = new Scanner(System.in);

    static void displayPackagesInterface() {

        System.out.println("============================================");
        System.out.print("Choose one of the options.\n1. Adding package.\n2. Removing package.\n3. Displaying packages by parcel locker.\n4. Updating package details.\n" +
                "9. Return to Main Menu.\n0. Exit Program\nWhat would you like to do? : ");
        choice = scanner.nextInt();
        System.out.println("============================================");

        switch (choice) {
            case 1:
                PackageManagement.addPackage();
                break;
            case 2:
                PackageManagement.removePackageFromParcelLocker();
                break;
            case 3:
                PackageManagement.displayAllPackagesInParcelLocker();
                break;
            case 4:
                PackageManagement.updatePackageDetails();
                break;
            case 9:
                StartUserInterface.displayStartInterface();
                break;
            case 0:
                System.out.println("BYE!");
        }

    }
}
