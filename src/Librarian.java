public class Librarian extends Person {
    public Librarian(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Librarian Name: " + getName() + ", Librarian ID: " + getId());
    }
}
