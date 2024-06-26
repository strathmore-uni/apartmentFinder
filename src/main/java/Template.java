//import com.apartmentFinder.components.ShadowPanel;

import javax.swing.*;
import java.awt.*;

public class Template {
    private JPanel mainPanel;
    private JButton addApartmentButton;
    private JTextField searchALocation;
    private JLabel title;
    private JLabel subtitle;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton viewButton;

    private Container container;
    private CardLayout cardLayout;

    public Template(Container container, CardLayout cardLayout){
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
