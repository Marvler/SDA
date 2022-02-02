public class TestData {

    public static void addTestDate(){
        ParcelLocker parcelLocker = new ParcelLocker("asd34", "Michal", new String[]{"NewStreet", "Warsawa", "342423"});
        ParcelLocker parcelLocker1 = new ParcelLocker("afd64", "Kamil", new String[]{"NewStreet", "Warsawa", "342423"});
        ParcelLocker parcelLocker2 = new ParcelLocker("afd95", "Maciek", new String[]{"NewStreet", "Krakow", "342423"});
        ParcelLocker parcelLocker3 = new ParcelLocker("afd93", "Maciek", new String[]{"NewStreet", "Krakow", "342423"});
        ParcelLocker parcelLocker4 = new ParcelLocker("afd91", "Maciek", new String[]{"NewStreet", "Krakow", "342423"});
        parcelLocker.addPackageToList(new Package("Minnesota","Kamil","Michał", parcelLocker, parcelLocker3,Status.NOT_SENT));
//        parcelLocker3.addPackageToList(new Package("Tennsese","Kamil","Michał", parcelLocker, parcelLocker3,Status.DELIVERED));
//        parcelLocker3.addPackageToList(new Package("Ohio","Kamil","Michał", parcelLocker, parcelLocker3,Status.DELIVERED));
        ParcelLockerManagement.listOfParcelLockers.add(parcelLocker);
        ParcelLockerManagement.listOfParcelLockers.add(parcelLocker1);
        ParcelLockerManagement.listOfParcelLockers.add(parcelLocker2);
        ParcelLockerManagement.listOfParcelLockers.add(parcelLocker3);
        ParcelLockerManagement.listOfParcelLockers.add(parcelLocker4);
    }
}
