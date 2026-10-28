import com.calculator.controller.CalculatorController;
import com.calculator.model.BasicCalculatorModel;
import com.calculator.model.CalculatorModel;
import com.calculator.service.HistoryService;
import com.calculator.service.InMemoryHistoryService;
import com.calculator.view.calcform;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Δημιουργία των components
            CalculatorModel model = new BasicCalculatorModel();
            HistoryService historyService = new InMemoryHistoryService();
            calcform view = new calcform();

            // 2. Σύνδεση με τον Controller
            new CalculatorController(model, view, historyService);

            // 3. Δημιουργία και εμφάνιση παραθύρου
            JFrame frame = new JFrame("Calculator");
            frame.setContentPane(view.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(320, 440);
            frame.setMinimumSize(new Dimension(280, 380));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}