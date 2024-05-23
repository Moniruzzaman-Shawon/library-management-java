public class Member extends Person {
    public Member(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Member Name: " + getName() + ", Member ID: " + getId());
    }
}
