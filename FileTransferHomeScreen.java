import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.net.*;

public class FileTransferHomeScreen extends JFrame {
  private static final int SIZE = 500;
  private static final String IPADDRESS = getIPAddress();
  
  private final JPanel mainPanel = new JPanel();
  private final JLabel ipAddressLabel = new JLabel();
  
  public FileTransferHomeScreen() {
    super("File Transferer");
    
    ipAddressLabel.setText("IP Address: " + IPADDRESS);
    
    //Add
    mainPanel.add(ipAddressLabel);
    add(mainPanel);
    
    //Layout stuff
    setVisible(true);
    setSize(500, 500);
  }
  
  public static void main(String[] ryan) {
    new FileTransferHomeScreen();
  }
  
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