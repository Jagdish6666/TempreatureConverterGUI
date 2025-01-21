import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(10, 20, 150, 25);
        panel.add(inputLabel);
        
        JTextField inputText = new JTextField(20);
        inputText.setBounds(160, 20, 165, 25);
        panel.add(inputText);
        
        JLabel comboBoxLabel = new JLabel("Select Conversion:");
        comboBoxLabel.setBounds(10, 50, 150, 25);
        panel.add(comboBoxLabel);
        
        String[] conversions = { "Celsius to Fahrenheit", "Celsius to Kelvin", "Fahrenheit to Celsius", "Fahrenheit to Kelvin", "Kelvin to Celsius", "Kelvin to Fahrenheit" };
        JComboBox<String> conversionBox = new JComboBox<>(conversions);
        conversionBox.setBounds(160, 50, 165, 25);
        panel.add(conversionBox);
        
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 80, 150, 25);
        panel.add(convertButton);
        
        JLabel resultLabel = new JLabel("Converted Temperature: ");
        resultLabel.setBounds(10, 110, 200, 25);
        panel.add(resultLabel);
        
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputValue = Double.parseDouble(inputText.getText());
                    String conversionType = (String) conversionBox.getSelectedItem();
                    double result = 0.0;

                    switch (conversionType) {
                        case "Celsius to Fahrenheit":
                            result = celsiusToFahrenheit(inputValue);
                            break;
                        case "Celsius to Kelvin":
                            result = celsiusToKelvin(inputValue);
                            break;
                        case "Fahrenheit to Celsius":
                            result = fahrenheitToCelsius(inputValue);
                            break;
                        case "Fahrenheit to Kelvin":
                            result = fahrenheitToKelvin(inputValue);
                            break;
                        case "Kelvin to Celsius":
                            result = kelvinToCelsius(inputValue);
                            break;
                        case "Kelvin to Fahrenheit":
                            result = kelvinToFahrenheit(inputValue);
                            break;
                    }

                    resultLabel.setText("Converted Temperature: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }
    
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }
}
