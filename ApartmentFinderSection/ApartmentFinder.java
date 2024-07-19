package HouseHunting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApartmentFinder extends JFrame {

    private JTextField apartmentNameField;
    private JTextField locationField;
    private JTextField whatsappField;
    private JPanel unitsContainer;
    private int unitCount = 1;
    private JLabel imageLabel;
    private String imagePath;

    public ApartmentFinder() {
        // Set the title of the JFrame
        setTitle("Apartment Finder - Add an Apartment Listing");
        // Set the size of the JFrame
        setSize(600, 600);
        // Close the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel panel = createMainPanel();
        // Add components to the main panel
        addComponentsToPanel(panel);

        // Add the main panel to the JFrame
        add(panel);
    }

    private JPanel createMainPanel() {
        // Create a new JPanel with a vertical BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    private void addComponentsToPanel(JPanel panel) {
        // Add title label to the panel
        panel.add(createTitleLabel());
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        // Add apartment name field
        panel.add(createLabelFieldPanel("Apartment Name:", apartmentNameField = createTextField("e.g South Street apartments")));
        // Add location field
        panel.add(createLabelFieldPanel("Text Location:", locationField = createTextField("e.g Nairobi West.")));
        // Add image upload button
        panel.add(createUploadButtonPanel());
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        // Add image preview label
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(100, 100)); // Set a preferred size for the image label
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the image label
        panel.add(imageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        // Add units label
        panel.add(createLabel("Units"));

        // Initialize units container
        unitsContainer = createUnitsContainer();
        panel.add(unitsContainer);

        // Add "Add Unit" button
        panel.add(createAddUnitButtonPanel());
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        // Add WhatsApp contact number field
        panel.add(createLabelFieldPanel("WhatsApp Contact Number:", whatsappField = createTextField("e.g 0712345678")));
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some space
        // Add Submit button
        panel.add(createSubmitButtonPanel());
    }

    private JLabel createTitleLabel() {
        // Create and return the title label
        JLabel titleLabel = new JLabel("Add an Apartment Listing");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the title label
        return titleLabel;
    }

    private JPanel createLabelFieldPanel(String labelText, JTextField textField) {
        // Create a new JPanel with GridBagLayout for label and field
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create and add label to the panel
        JLabel label = createLabel(labelText);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        // Add text field to the panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        textField.setPreferredSize(new Dimension(300, 30));
        panel.add(textField, gbc);

        return panel;
    }

    private JLabel createLabel(String text) {
        // Create and return a label with the specified text
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField createTextField(String placeholder) {
        // Create and return a text field with the specified placeholder
        JTextField textField = new JTextField(placeholder);
        textField.setBackground(Color.LIGHT_GRAY);
        return textField;
    }

    private JPanel createUnitsContainer() {
        // Create and return the units container panel
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.DARK_GRAY);
        return container;
    }

    private JPanel createAddUnitButtonPanel() {
        // Create a panel for the "Add Unit" button to center it
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create and add the "Add Unit" button to the panel
        JButton addUnitButton = new JButton("+ Add Unit");
        addUnitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a new unit field when the button is clicked
                addUnitFields();
            }
        });
        buttonPanel.add(addUnitButton);

        return buttonPanel;
    }

    private JPanel createUploadButtonPanel() {
        // Create a panel for the "Upload Image" button to center it
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create and add the "Upload Image" button to the panel
        JButton uploadButton = new JButton("Upload Image");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle image upload
                handleImageUpload();
            }
        });
        buttonPanel.add(uploadButton);

        return buttonPanel;
    }

    private void handleImageUpload() {
        // Open a file chooser dialog to select an image
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            imagePath = fileChooser.getSelectedFile().getPath();
            // Display the selected image in the JLabel
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Resize the image
            imageLabel.setIcon(new ImageIcon(image));
        }
    }

    private void handleSubmit() {
        // Open a confirmation dialog
        openConfirmationDialog();
        // Close the main window
        this.dispose();
    }

    private JPanel createSubmitButtonPanel() {
        // Create a panel for the "Submit" button to center it
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create and add the "Submit" button to the panel
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the handleSubmit method when the button is clicked
                handleSubmit();
            }
        });
        buttonPanel.add(submitButton);

        return buttonPanel;
    }

    private void addUnitFields() {
        // Add a new unit panel to the units container
        UnitPanel unitPanel = new UnitPanel(unitCount++);
        unitsContainer.add(unitPanel);
        unitsContainer.revalidate();
        unitsContainer.repaint();
    }

    private void openConfirmationDialog() {
        // Open a new JFrame to confirm the successful submission
        JFrame confirmationFrame = new JFrame("Submission Confirmation");
        confirmationFrame.setSize(300, 200);
        confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirmationFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel messageLabel = new JLabel("Submission Successful!");
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(messageLabel);
        confirmationFrame.add(panel);

        confirmationFrame.setVisible(true);
    }
}
