public class Student extends User {
    private boolean isFeePaid;

    public Student(String name, boolean isFeePaid) {
        super(name);
        this.isFeePaid = isFeePaid;
    }

    public boolean isFeePaid() {
        return isFeePaid;
    }

    public void setFeePaid(boolean feePaid) {
        isFeePaid = feePaid;
    }
}
