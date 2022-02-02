import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ParcelLocker {

    private String id;
    private String name;
    private String[] address;
    private ArrayList<Package> listOfPackages;

    public ParcelLocker(String id, String name, String[] address) {
        if (Pattern.matches("[a-zA-Z]{3}[0-9]{2}", id)) {
            this.id = id;
        } else {
            System.out.println("Wrong ID format");
        }
        this.name = name;
        this.address = address;
        this.listOfPackages = new ArrayList<Package>();
    }

    @Override
    public String toString() {
        return "ParcelLocker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + Arrays.toString(address) +
                (listOfPackages.size() > 0 ? ", listOfPackages=" + listOfPackages : "") +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public ArrayList<Package> getListOfPackages() {
        return listOfPackages;
    }

    public void setListOfPackages(ArrayList<Package> listOfPackages) {
        this.listOfPackages = listOfPackages;
    }

    public void addPackageToList(Package pack){
        this.listOfPackages.add(pack);
    }
}
