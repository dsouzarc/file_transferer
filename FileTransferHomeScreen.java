import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.net.*;

public class FileTransferHomeScreen extends JFrame {
  private static final int SIZE = 500;
  private static final String IPADDRESS = getIPAddress();
  
  private final JPanel mainPanel = new JPanel();
  
  private final JLabel ipAddressLabel = new JLabel();
  
  private final JButton chooseFileButton = new JButton();
  private final JButton sendFileButton = new JButton();
  private final JButton receiveFileButton = new JButton();
  
  public FileTransferHomeScreen() {
    super("File Transferer");
    
    ipAddressLabel.setText("IP Address: " + IPADDRESS);
    
    addComponents();
    setLayout();
  }
  
  /** Adds all variables to panel and panel to frame*/
  private void addComponents() {
    mainPanel.add(ipAddressLabel);
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