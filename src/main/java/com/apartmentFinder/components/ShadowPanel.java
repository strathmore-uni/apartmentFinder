//package com.apartmentFinder.components;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImageFilter;
//
//public class ShadowPanel extends JPanel {
//
//    private int shadowSize = 5; // Size of the box shadow
//    private Color shadowColor = Color.GRAY; // Color of the box shadow
//    private float blurRadius = 0.2f; // Blur radius for the background
//
//    public ShadowPanel(){
//        super();
//        setOpaque(false); // Required for background blur effect
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//
//        // Draw box shadow
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setColor(shadowColor);
//        for (int i = 0; i < shadowSize; i++) {
//            g2d.fillRoundRect(i, i, getWidth() - 2 * i, getHeight() - 2 * i, 10, 10);
//        }
//
//        // Apply background blur
////        g2d.setRenderingHint(RenderingHints.KEY_, RenderingHints.VALUE_RENDER_QUALITY);
////        BufferedImage blurredImage = createBlurredImage(this);
////        g2d.drawImage(blurredImage, 0, 0, null);
//    }
//
//    private BufferedImage createBlurredImage(Component component) {
//        int width = component.getWidth();
//        int height = component.getHeight();
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D offGraphics = image.createGraphics();
//
//        // Paint the component and its children to the image
//        component.paint(offGraphics);
//        offGraphics.dispose();
//
//        // Apply Gaussian blur filter
//        BufferedImageFilter filter = new GaussianFilter(blurRadius);
//        BufferedImage filteredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        filter.filter(image, filteredImage);
//        return filteredImage;
//    }
//
//    // Getters and Setters for property binding in Swing Designer
//
//    public int getShadowSize() {
//        return shadowSize;
//    }
//
//    public void setShadowSize(int shadowSize) {
//        this.shadowSize = shadowSize;
//        repaint();
//    }
//
//    public Color getShadowColor() {
//        return shadowColor;
//    }
//
//    public void setShadowColor(Color shadowColor) {
//        this.shadowColor = shadowColor;
//        repaint();
//    }
//
//    public float getBlurRadius() {
//        return blurRadius;
//    }
//
//    public void setBlurRadius(float blurRadius) {
//        this.blurRadius = blurRadius;
//        repaint();
//    }
//}
