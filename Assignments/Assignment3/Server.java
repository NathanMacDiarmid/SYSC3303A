package Assignment3;

import java.io.*;
import java.net.*;

/**
 * @author Nathan MacDiarmid 101098993
 * The Server class is the class that receives the messages
 * and returns an emoji based on whether its a read or write request
 */
public class Server {
    private DatagramPacket sendPacket, receivePacket;
    private DatagramSocket sendSocket, receiveSocket;
    private byte[] data = new byte[100];

    /**
     * @author Nathan MacDiarmid 101098993
     * Default constructor for Server
     */
    public Server() {
        // Initializes the send and receive sockets
        // The receive socket is linked to port 69 so the
        // Host can send directly to the Server
        try {
            sendSocket = new DatagramSocket();
            receiveSocket = new DatagramSocket(69);
        } catch (SocketException se) {
            se.printStackTrace();
            System.exit(1);
        } 
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Send method for the Server sends the emoji message
    * back to wherever the message received came from
    */
    public void send() {
        // Initializes byte array with only for bits
        byte[] msg = new byte[4];

        // Sets the byte array to a heart and smiley emoji
        if (data[1] == 1) {
            msg[0] = 0;
            msg[1] = 3;
            msg[2] = 0;
            msg[3] = 1;
        }
        // Sets the byte array to a diamond emoji
        if (data[1] == 2) {
            msg[0] = 0;
            msg[1] = 4;
            msg[2] = 0;
            msg[3] = 0;
        }

        // Initializes the DatagramPacket to be sent
        sendPacket = new DatagramPacket(msg, msg.length, receivePacket.getAddress(), receivePacket.getPort());

        System.out.println( "Server: Sending packet:");
        System.out.println("To host: " + sendPacket.getAddress());
        System.out.println("Destination host port: " + sendPacket.getPort());
        int len = sendPacket.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: ");
        System.out.println(new String(sendPacket.getData(),0,len));
        this.printByteArray(data);
        System.out.println();

        // Sends the DatagramPacket to the specified port
        // In this case, it sends it to where the initial message was sent from
        try {
            sendSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server: packet sent");
   }

   /**
    * @author Nathan MacDiarmid 101098993
    * Receive method for Server receives the message
    * from wherever the message was sent from
    */
   public void receive() {
        // Initializes the receive DatagramPacket
        receivePacket = new DatagramPacket(data, data.length);
        System.out.println("Server: Waiting for Packet.\n");

        // Receives the DatagramPacket
        try {        
            System.out.println("Waiting...");
            receiveSocket.receive(receivePacket);
        } catch (IOException e) {
            System.out.print("IO Exception: likely:");
            System.out.println("Receive Socket Timed Out.\n" + e);
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Server: Packet received:");
        System.out.println("From host: " + receivePacket.getAddress());
        System.out.println("Host port: " + receivePacket.getPort());
        int len = receivePacket.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: " );

        String received = new String(data,2,len);   
        System.out.println(received);
        this.printByteArray(data);

        // Determines whether the message was a read, write or invalid request
        // In the case of an invalid request, the returns the message to
        // sender, closes the open sockets and ends the program for the Server
        if (data[1] == 1) {
            System.out.println("This was a valid read request");
        } else if (data[1] == 2) {
            System.out.println("This was a valid write request");
        } else {
            System.out.println("This is an invalid request!");
            try {
                sendSocket.send(receivePacket);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            this.closeSocket();
            System.exit(1);
        }
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
    * Closes the open sockets when program ends
    */
    public void closeSocket() {
        sendSocket.close();
        receiveSocket.close();
    }

    /**
    * @author Nathan MacDiarmid 101098993
    * The main method for Server runs the Server program
    * Must be started first out of Host and Client
    * @param args
    */
    public static void main(String args[]) {
        Server server = new Server();

        for (int i = 1; i < 13; i++) {
            server.receive();
            server.send();
        }
        server.closeSocket();
    }
}
