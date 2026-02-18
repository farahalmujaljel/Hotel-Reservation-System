package hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelRatingGUI extends JFrame {

    private boolean msg = false;

    private JLabel thankYouMsg;
    private JLabel rateLabel;
    private JComboBox<String> ratingScale;
    private JLabel reviewLabel;
    private JTextArea reviewText;
    private JScrollPane reviewScroll;
    private JButton submitButton;

    public HotelRatingGUI() {
        setTitle("Hotel Rating");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        try {
            setContentPane(new JLabel(new ImageIcon(getClass().getResource("/hotelreservationsystem/marinahotel.jpeg"))));
        } catch (Exception e) {
            System.out.println("Error: Background image not found!");
        }
        
        thankYouMsg = new JLabel("Thank you for booking with our Hotel!");
        thankYouMsg.setFont(new Font("Serif", Font.ITALIC, 21));
        thankYouMsg.setBounds(50, 30, 400, 30);
        thankYouMsg.setForeground(Color.WHITE); 
        add(thankYouMsg);

        rateLabel = new JLabel("Rate your experience out of 1-5");
        rateLabel.setFont(new Font("Serif", Font.BOLD, 18));
        rateLabel.setBounds(100, 100, 300, 30);
        rateLabel.setForeground(Color.WHITE); 
        add(rateLabel);

        String[] ratings = {"1 - Bad", "2 - Poor", "3 - Okay", "4 - Good", "5 - Excellent"};
        ratingScale = new JComboBox<>(ratings);
        ratingScale.setFont(new Font("Serif", Font.PLAIN, 14));
        ratingScale.setBounds(140, 140, 150, 25);
        add(ratingScale);

        reviewLabel = new JLabel("Consider Leaving us a review");
        reviewLabel.setFont(new Font("Serif", Font.BOLD, 18));
        reviewLabel.setBounds(100, 180, 300, 30);
        reviewLabel.setForeground(Color.WHITE); 
        add(reviewLabel);

        reviewText = new JTextArea(5, 20);
        reviewText.setLineWrap(true);
        reviewText.setWrapStyleWord(true);
        reviewText.setToolTipText("A review is optional.");
        reviewScroll = new JScrollPane(reviewText);
        reviewScroll.setBounds(85, 220, 280, 100);
        add(reviewScroll);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.BOLD, 14));
        submitButton.setBounds(170, 340, 100, 30);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                handleSubmit();
            }
        });

        setLocationRelativeTo(null); // Center on screen
    }
    private void handleSubmit() {
        String selectedRating = (String) ratingScale.getSelectedItem();
        String review = reviewText.getText().trim();
        boolean reviewIsEmpty = review.isEmpty();

        if (selectedRating != null && (selectedRating.startsWith("1") || selectedRating.startsWith("2"))) {
            if (!msg) {
                JOptionPane.showMessageDialog(this,
                        "Review Summary:\nRating: " + selectedRating + "\nText: " +
                                (reviewIsEmpty ? "No review left." : review) +
                                "\n\nWe're sorry that you didn't enjoy your stay.",
                        "Apology Message", JOptionPane.PLAIN_MESSAGE);
                msg = true;
                rateLabel.setVisible(false);
                ratingScale.setVisible(false);
                reviewLabel.setText("How can we improve our services?");
                reviewLabel.setBounds(70, 180, 350, 30);
                reviewText.setText(""); // Clear previous review
            } else {
                System.out.println("Stored Feedback: " + (reviewIsEmpty ? "No feedback provided." : review));

                JOptionPane.showMessageDialog(this,
                        "Thank you for your feedback. We appreciate your time.",
                        "Feedback", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Review Summary:\nRating: " + selectedRating + "\nText: " +
                            (reviewIsEmpty ? "No review left." : review) +
                            "\n\nWe're glad you enjoyed your stay, we hope to see you again!",
                    "Gratitude Message", JOptionPane.PLAIN_MESSAGE);

            dispose();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HotelRatingGUI().setVisible(true);
        });
    }
}