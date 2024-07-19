package HouseHunting;

import javax.swing.*;
import java.awt.*;

public class UnitPanel extends JPanel {
    private JTextField bedroomsField;
    private JTextField bathroomsField;
    private JTextField rentField;

    public UnitPanel(int unitNumber) {
        // Set the layout and background color for the unit panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE), "Unit " + unitNumber,
                0, 0, new Font("Arial", Font.BOLD, 12), Color.WHITE));

        // Add bedrooms, bathrooms, and rent fields
        add(createLabelFieldPanel("Bedrooms:", bedroomsField = createTextField("e.g 3")));
        add(createLabelFieldPanel("Bathrooms:", bathroomsField = createTextField("e.g 1")));
        add(createLabelFieldPanel("Rent /month:", rentField = createTextField("e.g 15000")));
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
        textField.setPreferredSize(new Dimension(100, 30));
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
}
