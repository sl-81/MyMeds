package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Represents a bar chart that shows the patients in the system and how many drugs they take
public class BarChart extends JPanel {
    private static final int SCALEFACTOR = 50;
    private static final int BORDER = 30;
    private static final int GAP = 10;
    private List<Integer> drugCount;
    private List<String> patientNames;
    private String title;
    private JButton back;
    private MyMedsUI ui;

    // EFFECTS: CREATES A NEW BARCHART TO BE ADDED TO THE UI
    public BarChart(MyMedsUI ui, List<Integer> drugCount, List<String> patientNames, String title) {
        this.ui = ui;
        this.drugCount = drugCount;
        this.patientNames = patientNames;
        this.title = title;
        this.back = new JButton("Back to Main");
        placeLabel();
        initializeBackButton();
    }

    // EFFECTS: DRAWS THE BAR CHART'S VERTICAL AND HORIZONTAL AXIS THEN THE INDIVIDUAL BARS FOLLOWED BY NAME
    // AND NUMBER OF DRUGS
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        g1.drawLine(BORDER, BORDER, BORDER, height - BORDER);
        g1.drawLine(width - BORDER, height - BORDER, BORDER, height - BORDER);
        if (patientNames.size() > 0) {
            int barSize = (width - BORDER * 2 - GAP * 2) / patientNames.size();
            for (int i = 0; i < drugCount.size(); i++) {
                g1.setPaint(Color.RED);
                g1.drawRect(i * barSize + BORDER + i * GAP, (height - drugCount.get(i) * SCALEFACTOR - BORDER),
                        barSize, drugCount.get(i) * SCALEFACTOR);
                g1.fillRect(i * barSize + BORDER + i * GAP, (height - drugCount.get(i) * SCALEFACTOR - BORDER),
                        barSize, drugCount.get(i) * SCALEFACTOR);
                g1.setPaint(Color.BLACK);
                g1.drawString(patientNames.get(i), i * barSize + BORDER + i * GAP, height - BORDER / 2);
                g1.drawString(drugCount.get(i).toString(), i * barSize + BORDER + i * GAP,
                        (height - drugCount.get(i) * SCALEFACTOR - BORDER));
            }
        }

    }

    // EFFECTS: ADDS THE PROVIDED TITLE TO THE BAR CHART
    public void placeLabel() {
        JLabel graphTitle = new JLabel(title);
        add(graphTitle);
    }

    // EFFECTS: INITIATES BUTTON TO GO BACK TO MAIN ON CLICK
    private void initializeBackButton() {
        back.addActionListener(new GoBackToMain(this));
        add(back);
    }

    // ACTION LISTENER TO THE BACK BUTTON
    private class GoBackToMain implements ActionListener {
        private BarChart bc;

        // EFFECTS: CONSTRUCTS ACTION LISTENER
        public GoBackToMain(BarChart bc) {
            this.bc = bc;
        }

        // MODIFIES: UI
        // EFFECTS: RESET UI TO FRONTPAGE AND SET BAR CHART INVISIBLE
        @Override
        public void actionPerformed(ActionEvent e) {
            ui.runMyMeds();
            bc.setVisible(false);
        }
    }
}
