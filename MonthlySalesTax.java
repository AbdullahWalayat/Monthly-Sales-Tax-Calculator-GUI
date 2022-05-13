package monthlysalestaxmain;

import javax.swing.*;       
import java.awt.event.*;           

public class MonthlySalesTax extends JFrame
{
   private JPanel panel;                               
   private JLabel messageLabel;                      
   private JTextField totalTextField;                   
   private JButton calcButton;                           
   private final int WINDOW_WIDTH = 360;               
   private final int WINDOW_HEIGHT = 130;     
                                                      
  
   public MonthlySalesTax()
   { 
       setTitle("Monthly Sales Tax Reporter");
       
       setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       buildPanel();
      
       add(panel);
      
       setVisible(true);
   }
  
   private void buildPanel()
   { 
       messageLabel = new JLabel("Enter the total sales:");
      
       totalTextField = new JTextField(10);
      
       calcButton = new JButton("Calculate Sales Tax");
      
       calcButton.addActionListener(new CalcButtonListener());
      
       panel = new JPanel();

       panel.add(messageLabel);
       
       panel.add(totalTextField);
       
       panel.add(calcButton);
   }
  
   private class CalcButtonListener implements ActionListener
   {
      
       public void actionPerformed(ActionEvent e)
       {
           String input;       
           final double COUNTY_TAX_PERCENT = 0.02;       
           final double STATE_TAX_PERCENT = 0.04;       
           double monthlySales;                       
           double countySalesTax;                       
           double stateSalesTax;                       
           double totalSalesTax;                       
          
           input = totalTextField.getText();
          
           monthlySales = Double.parseDouble(input);
         
           countySalesTax = monthlySales * COUNTY_TAX_PERCENT;
          
           stateSalesTax = monthlySales * STATE_TAX_PERCENT;
          
           totalSalesTax = countySalesTax + stateSalesTax;
         
           JOptionPane.showMessageDialog(null, String.format("County Sales Tax: $%, .2f\nState Sales Tax: $%, .2f\nTotal Sales Tax: $%, .2f",
                                          countySalesTax, stateSalesTax, totalSalesTax));
       }
   }
}


