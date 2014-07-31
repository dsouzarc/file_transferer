import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

public class FileTransferHomeScreen extends JFrame {
  private static final int SIZE = 500;
  private static final String IPADDRESS = getIPAddress();
  
  private final JPanel mainPanel = new JPanel();
  
  private final JLabel ipAddressLabel = new JLabel();
  
  private final JButton chooseFileButton = new JButton();
  private final JButton sendFileButton = new JButton();
  private final JButton receiveFileButton = new JButton();
  
  private final JFileChooser fileChooser = new JFileChooser();
  
  private final LinkedList<File> chosenFiles = new LinkedList<File>();
  
  public FileTransferHomeScreen() {
    super("File Transferer");
    
    
    setData();
    addComponents();
    setLayout();
  }
  
  /** Action listener for choose file */
  private class ChooseFileActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent theAction) {
      fileChooser.showDialog(mainPanel, "Add file to send list");
      fileChooser.setMultiSelectionEnabled(true);
    }
  };
  
  /** Sets the data for the variables */
  private void setData() {
    ipAddressLabel.setText("IP Address: " + IPADDRESS);
    chooseFileButton.setText("Choose file to send");
    chooseFileButton.addActionListener(new ChooseFileActionListener());
  }
  
  /** Adds all variables to panel and panel to frame*/
  private void addComponents() {
    mainPanel.add(ipAddressLabel);
    mainPanel.add(Box.createRigidArea(new Dimension(5,10)));
    mainPanel.add(chooseFileButton);
    
    add(mainPanel);
  }
  
  /** Sets the layout of everything */
  private void setLayout() {
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    setVisible(true);
    setSize(500, 500);
  }
  
  public static void main(String[] ryan) {
    new FileTransferHomeScreen();
  }
  
  /** Returns machine's IP Address */
  private static String getIPAddress() {
    try { 
      return InetAddress.getLocalHost().getHostAddress();
    }
    catch(Exception e) { 
      e.printStackTrace();
      return "Error";
    }
  }
}