import java.util.ArrayList;
import java.util.Scanner;

class PackageManagement {

    private static Scanner scanner = new Scanner(System.in);

    static void addPackage() {
        System.out.println("Type name of the package: ");
        String name = errorCommunicate("Name cannot be empty. Try again.");

        System.out.println("Type name of the recipient");
        String recipientName = errorCommunicate("Recipient name cannot be empty. Try again.");

        System.out.println("Type Sender name: ");
        String senderName = errorCommunicate("Recipient name cannot be empty. Try again.");

        System.out.println("Type recipient Parcel Locker ID: ");
        ParcelLocker recipientParcerlLocker = getParcelLocker();

        System.out.println("Type sender Parcel Locker ID: ");
        ParcelLocker senderParcelLocker = getParcelLocker();

        Status status = getPackageStatus();
        Package pack = new Package(name, recipientName, senderName, senderParcelLocker, recipientParcerlLocker, status);
        assignToLocker(recipientParcerlLocker, senderParcelLocker, pack);

    }

    private static ParcelLocker getParcelLocker() {
        String recipientParcelLockerID = scanner.next();
        ParcelLocker recipientParcerlLocker = ParcelLockerManagement.getParcelLocker(recipientParcelLockerID);
        while (recipientParcerlLocker == null) {
            System.out.println("Such Parcel Locker doesn't extist. Please try again");
            recipientParcerlLocker = ParcelLockerManagement.getParcelLocker(scanner.next());
        }
        return recipientParcerlLocker;
    }

    private static void assignToLocker(ParcelLocker recipientParcerlLocker, ParcelLocker senderParcelLocker, Package pack) {
        if (pack.getStatus().equals(Status.NOT_SENT)) {
            senderParcelLocker.addPackageToList(pack);
        } else if (pack.getStatus().equals(Status.DELIVERED)) {
            recipientParcerlLocker.addPackageToList(pack);
        }
    }

    private static Status getPackageStatus() {
        System.out.println("Choose staus of package: \n1: Not Sent\n2. Sent\n3. Delivered");
        int choice = scanner.nextInt();
        Status status = null;
        switch (choice) {
            case 1:
                status = Status.NOT_SENT;
                break;
            case 2:
                status = Status.SENT;
                break;
            case 3:
                status = Status.DELIVERED;
                break;
        }
        return status;
    }

    static void removePackageFromParcelLocker() {
        System.out.println("Type ID of Parcel Locker from which package should be removed");
        String id = errorCommunicate("ID cannot be empty! Try again.");
        ParcelLocker parcelLocker = ParcelLockerManagement.getParcelLocker(id);
        while (parcelLocker == null) {
            System.out.println("There is no such Parcel Locker. Please Try again.");
            parcelLocker = ParcelLockerManagement.getParcelLocker(scanner.next());
        }

        System.out.println("Type ID of Package that you would like to remove");
        String packageId = scanner.next();
        ArrayList<Package> listOfPackages = parcelLocker.getListOfPackages();
        Package toRemove = null;
        for (Package pack : listOfPackages
        ) {
            if (pack.id.toString().equals(packageId)) {
                toRemove = pack;
            }
        }

        if (toRemove != null) {
            listOfPackages.remove(toRemove);
            System.out.println("Package with id " + toRemove.id.toString() + " was successfully removed");
        }
    }


    static void displayAllPackagesInParcelLocker() {
        System.out.println("Type ID of Parcel Locker to display packages");
        ParcelLocker parcelLocker = ParcelLockerManagement.getParcelLocker(scanner.next());
        while (parcelLocker == null) {
            System.out.println("There is no Parcel Locker with such ID. Try Again");
            parcelLocker = ParcelLockerManagement.getParcelLocker(scanner.next());
        }
        if (parcelLocker.getListOfPackages().size() == 0) {
            System.out.println("There is no packages in parcel locker with id " + parcelLocker.getId());
        } else {
            int i = 1;

            for (Package pack : parcelLocker.getListOfPackages()) {
                System.out.println(i + ": " + pack.toString());
                i++;
            }
        }
        PackageUserInterface.displayPackagesInterface();
    }

    private static Package packExists(String id) {
        for (ParcelLocker parcel : ParcelLockerManagement.listOfParcelLockers
        ) {
            for (Package pack : parcel.getListOfPackages()
            ) {
                if (pack.id.toString().equals(id)) {
                    return pack;
                }
            }
        }
        return null;
    }

    static void updatePackageDetails() {
        System.out.println("Type ID of Package you would like to update: ");
        String id = scanner.next();
        Package pack = packExists(id);
        while (pack == null) {
            System.out.println("There is no package with such ID. Try again.");
            pack = packExists(scanner.next());
        }
        Status currentStatus = pack.getStatus();
        System.out.println("Update package name: ");
        pack.setName(errorCommunicate("Name cannot be empty"));

        System.out.println("Update package size: ");
        pack.setSize(scanner.next());

        System.out.println("Update package weight: ");
        pack.setWeight(scanner.nextDouble());

        System.out.println("Update package recipient: ");
        pack.setRecipient(errorCommunicate("Recipient cannot be empty!"));

        System.out.println("Update package sender: ");
        pack.setSender(errorCommunicate("Sender cannot be empty!"));

        System.out.println("Update sender parcel locker ID:");
        String parcelSenderID = scanner.next();
        ParcelLocker senderParcel = updateParcel(parcelSenderID, pack);

        System.out.println("Update recipient parcel locker ID:");
        String parcelRecipientID = scanner.next();
        ParcelLocker recipientParcel = updateParcel(parcelRecipientID, pack);

        System.out.println("Update package status");
        pack.setStatus(getPackageStatus());
        Status newStatus = pack.getStatus();
         updateStateOfPackage(pack, currentStatus, senderParcel, recipientParcel, newStatus);

        PackageUserInterface.displayPackagesInterface();
    }

    private static void updateStateOfPackage(Package pack, Status currentStatus, ParcelLocker senderParcel, ParcelLocker recipientParcel, Status newStatus) {
        if(currentStatus.equals(Status.NOT_SENT) && newStatus.equals(Status.SENT)){
            senderParcel.getListOfPackages().remove(pack);
        }else if(currentStatus.equals(Status.SENT) && newStatus.equals(Status.DELIVERED)){
            recipientParcel.getListOfPackages().add(pack);
        }else if(currentStatus.equals(Status.DELIVERED) && newStatus.equals(Status.NOT_SENT)){
            recipientParcel.getListOfPackages().remove(pack);
            senderParcel.getListOfPackages().add(pack);
        }else if(currentStatus.equals(Status.SENT) && newStatus.equals(Status.NOT_SENT)){
            senderParcel.getListOfPackages().add(pack);
        }else if(currentStatus.equals(Status.NOT_SENT) && newStatus.equals(Status.DELIVERED)){
            senderParcel.getListOfPackages().remove(pack);
            recipientParcel.getListOfPackages().add(pack);}
    }

    static String errorCommunicate(String error) {
        String value = scanner.next();
        while (value.length() == 0 || value.isBlank()) {
            System.out.println(error);
            value = scanner.next();
        }
        return value;
    }

    private static ParcelLocker updateParcel(String id, Package pack) {
        ParcelLocker parcelLocker = null;
        boolean found = false;
        while (!found) {
            for (ParcelLocker parcel : ParcelLockerManagement.listOfParcelLockers
            ) {
                if (parcel.getId().equals(id)) {
                    pack.setSenderParcelLocker(parcel);
                    parcelLocker = parcel;
                    System.out.println("Parcel Locker updated");
                }
            }
            if (parcelLocker != null) {
                found = true;
            } else {
                System.out.println("Cannot find parcel locker with id " + id + ". Try again");
                id = scanner.next();
            }
        }
        return parcelLocker;
    }

}
