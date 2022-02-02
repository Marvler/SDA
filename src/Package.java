import java.util.UUID;

public class Package {

    UUID id;
    private String name;
    private String size;
    private double weight;
    private String recipient;
    private String sender;
    private String senderParcelLocker;
    private String recipientParcelLocker;
    private Status status;
    private Sender registeredSender;

    public Package(String name, String size, double weight, String recipient, String sender, ParcelLocker senderParcelLocker, ParcelLocker recipientParcelLocker, Status status) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderParcelLocker = senderParcelLocker.getId();
        this.recipientParcelLocker = recipientParcelLocker.getId();
        this.status = status;
    }

    public Package(String name, String recipient, String sender, ParcelLocker senderParcelLocker, ParcelLocker recipientParcelLocker, Status status) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.recipient = recipient;
        this.sender = sender;
        this.senderParcelLocker = senderParcelLocker.getId();
        this.recipientParcelLocker = recipientParcelLocker.getId();
        this.status = status;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                ", recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", status=" + status +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderParcelLocker() {
        return senderParcelLocker;
    }

    public void setSenderParcelLocker(ParcelLocker senderParcelLocker) {
        this.senderParcelLocker = senderParcelLocker.getId();
    }

    public String getRecipientParcelLocker() {
        return recipientParcelLocker;
    }

    public void setRecipientParcelLocker(ParcelLocker recipientParcelLocker) {
        this.recipientParcelLocker = recipientParcelLocker.getId();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Sender getRegisteredSender() {
        return registeredSender;
    }

    public void setRegisteredSender(Sender registeredSender) {
        this.registeredSender = registeredSender;
    }
}
