import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Book Title:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField bookTitle = new JTextField(20);
        bookTitle.setBounds(100, 20, 165, 25);
        panel.add(bookTitle);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 50, 80, 25);
        panel.add(authorLabel);

        JTextField authorField = new JTextField(20);
        authorField.setBounds(100, 50, 165, 25);
        panel.add(authorField);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(10, 80, 150, 25);
        panel.add(addButton);

        JButton listButton = new JButton("List Books");
        listButton.setBounds(10, 110, 150, 25);
        panel.add(listButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookManager.addBook(bookTitle.getText(), authorField.getText());
                JOptionPane.showMessageDialog(null, "Book Added!");
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookManager.listBooks();
            }
        });
    }
}
