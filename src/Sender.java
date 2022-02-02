import java.util.Scanner;

public class Sender {
    private static int id = 1;
    private int senderId;
    private String name;
    private String surnname;
    private String phoneNumber;
    static Scanner scanner = new Scanner(System.in);


    public Sender() {
        System.out.println("Type name o sender: ");
        this.name = scanner.next();
        System.out.println("Type surname o sender: ");
        this.surnname = scanner.next();
        System.out.println("Type phone number in format xxx-xxx-xxx");
        this.phoneNumber = scanner.next();
        while (!this.phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{3}")){
            System.out.println("Wrong format of phone number. Try again");
            this.phoneNumber = scanner.next();
        }
        this.senderId = id;
        id++;

    }

    @Override
    public String toString() {
        return "Sender{" +
                "senderId=" + senderId +
                ", name='" + name + '\'' +
                ", surnname='" + surnname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
