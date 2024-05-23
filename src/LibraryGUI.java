import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    private Library library;
    private JTextField titleField;
    private JTextArea displayArea;

    public LibraryGUI() {
        library = new Library();
        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel titleLabel = new JLabel("Book Title:");
        titleField = new JTextField();

        JButton borrowButton = new JButton("Borrow Book");
        borrowButton.addActionListener(new BorrowButtonListener());

        JButton returnButton = new JButton("Return Book");
        returnButton.addActionListener(new ReturnButtonListener());

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(borrowButton);
        panel.add(returnButton);

        add(panel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    private class BorrowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            try {
                Book book = library.borrowBook(title);
                displayArea.append("Borrowed: " + book.getTitle() + "\n");
            } catch (BookNotAvailableException ex) {
                displayArea.append(ex.getMessage() + "\n");
            }
        }
    }

    private class ReturnButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            Book book = new Book(title, "Unknown"); // Simplified
            library.returnBook(book);
            displayArea.append("Returned: " + book.getTitle() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryGUI gui = new LibraryGUI();
            gui.setVisible(true);
        });
    }
}