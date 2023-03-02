package Assignment3;

import java.io.*;
import java.net.*;

/**
 * @author Nathan MacDiarmid 101098993
 * The Client class is the class that sends all of the messages
 * to the host and then echoed back
 */
public class Client {
   private DatagramPacket sendPacket, receivePacket;
   private DatagramSocket sendReceiveSocket;

   /**
    * @author Nathan MacDiarmid 101098993
    * Default constructor for Client
    */
   public Client() {
      // Initializes the send and receive socket for the Client
      try {
         sendReceiveSocket = new DatagramSocket();
      } catch (SocketException se) {
         se.printStackTrace();
         System.exit(1);
      }
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Send method for Client sends the message to the specified port
    * In this case, it is port 23 the destination
    * @param message the String message being sent
    * @param mode the way the message is coded
    * @param requestType either 1 for read request or 2 for write request
    */
   public void sendData(String message, String mode, int requestType) {
      // Prepares the message to be sent by forming a byte array
      byte[] msg = this.createBytes(message, mode, requestType);
      System.out.println("Client: sending a packet containing: " + message + "\nWith mode: " + mode);
      this.printByteArray(msg);

      // Creates the DatagramPacket to be sent to port 23
      try {
         sendPacket = new DatagramPacket(msg, msg.length, InetAddress.getLocalHost(), 23);
      } catch (UnknownHostException e) {
         e.printStackTrace();
         System.exit(1);
      }

      System.out.println("To host: " + sendPacket.getAddress());
      System.out.println("Destination host port: " + sendPacket.getPort());
      int len = sendPacket.getLength();
      System.out.println("Length: " + len);

      // Sends the DatagramPacket over port 23
      try {
         sendReceiveSocket.send(sendPacket);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      }

      System.out.println("Client: Packet sent.\n");
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Sends the request for the data that is held by the Host
    */
    public void sendRequest() {
      // TO DO
      // Prepares the message to be sent by forming a byte array
      String message = "Can I get the deats?";
      byte[] msg = message.getBytes();

      System.out.println("Client: sending a packet containing: " + message);

      // Creates the DatagramPacket to be sent to port 23
      try {
         sendPacket = new DatagramPacket(msg, msg.length, InetAddress.getLocalHost(), 23);
      } catch (UnknownHostException e) {
         e.printStackTrace();
         System.exit(1);
      }

      System.out.println("To host: " + sendPacket.getAddress());
      System.out.println("Destination host port: " + sendPacket.getPort());
      int len = sendPacket.getLength();
      System.out.println("Length: " + len);

      // Sends the DatagramPacket over port 23
      try {
         sendReceiveSocket.send(sendPacket);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      }

      System.out.println("Client: Request sent.\n");
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Receive method for Client receives a message from the specified port
    * In this case, it is port 23
    */
   public void receiveData() {
      // Prepares the byte array for arrival
      // It is only of length 4 because the server only sends a byte
      // array of 4 in return
      byte data[] = new byte[4];
      receivePacket = new DatagramPacket(data, data.length);

      // Receives the DatagramPacket on the send and receive socket
      try {
         sendReceiveSocket.receive(receivePacket);
      } catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }

      System.out.println("Client: Packet received:");
      System.out.println("From host: " + receivePacket.getAddress());
      System.out.println("Host port: " + receivePacket.getPort());
      int len = receivePacket.getLength();
      System.out.println("Length: " + len);
      System.out.print("Containing: ");

      String received = new String(data,0,len);   
      System.out.println(received);
      this.printByteArray(data);
      System.out.println();
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Receives the acknowledgement from the Host that it has received the message
    * and accepted the data.
    */
   public void receiveAcknowledgement() {
      // Prepares the byte array for arrival
      // It is only of length 40 because the host only sends a byte
      // array of 40 in return ("The host has accepted the message.")
      byte data[] = new byte[40];
      receivePacket = new DatagramPacket(data, data.length);

      // Receives the DatagramPacket on the send and receive socket
      try {
         sendReceiveSocket.receive(receivePacket);
      } catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      System.out.println("Client: Packet received:");
      System.out.println("From host: " + receivePacket.getAddress());
      System.out.println("Host port: " + receivePacket.getPort());
      int len = receivePacket.getLength();
      System.out.println("Length: " + len);
      System.out.print("Containing: ");
      String received = new String(data,0,len);   
      System.out.println(received);
      this.printByteArray(data);
      System.out.println();
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Prints a formatted array of bytes that it is passed
    * @param b an array of bytes that encode a message
    */
   private void printByteArray(byte[] b) {
      System.out.print("Byte array for this message is: ");
      for (int i = 0; i < b.length; i++) {
         System.out.format("%01X", b[i]);
      }
      System.out.println();
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Formats the array of bytes correctly for sending with our format
    * read format - 01 string of bytes 0 mode 0
    * write format - 02 string of bytes 0 mode 0
    * @param message the message that is being sent
    * @param mode the mode that is used to decode the message in the byte array
    * @param requestType whether the array is a read or write request
    * @return the formatted byte array prepared for sending
    */
   private byte[] createBytes(String message, String mode, int requestType) {
      byte[] msg = new byte[20];
      msg[0] = 0;
      msg[1] = (byte) requestType;
      byte[] filename = message.getBytes();
      System.arraycopy(filename, 0, msg, 2, filename.length);
      int currentIndex = filename.length + 2;
      msg[currentIndex] = 0;
      byte[] methodMode = mode.getBytes();
      System.arraycopy(methodMode, 0, msg, currentIndex + 1, methodMode.length);
      return msg;
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Closes the open sockets when program ends
    */
   public void closeSocket() {
      sendReceiveSocket.close();
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * The main method for Client runs the Client program
    * Must be started last after Host and Server
    * @param args
    */
   public static void main(String args[]) {
      Client client = new Client();

      int requestType = 0;
      for (int i = 1; i < 12; i++) {
         if (i % 2 == 0) {
            requestType = 1;
         } else if (i % 2 == 1) {
            requestType = 2;
         } else if (i == 11) {
            requestType = 42;
         }
         client.sendData("test.txt", "HEXascii", requestType);
         client.receiveAcknowledgement();
         client.sendRequest();
         client.receiveData();
      }
      client.sendData("test.txt", "HEXascii", 7);
      client.receiveAcknowledgement();
      client.sendRequest();
      client.receiveData();
      client.closeSocket();
   }
}
