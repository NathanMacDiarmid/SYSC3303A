package Assignment2;

import java.io.*;
import java.net.*;

/**
 * @author Nathan MacDiarmid 101098993
 * The Host class is the middle man between the Server and the Client
 * It receives and sends to both the Server and Client
 */
public class Host {
    private DatagramPacket sendPacket, receivePacket23, receivePacket69;
    private DatagramSocket sendAndReceiveSocket, receiveSocket23;
    private byte[] data = new byte[100];

    /**
     * @author Nathan MacDiarmid 101098993
     * Default constructor for Host class
     */
    public Host() {
        // Initializes the send and receive socket for Host
        // Intializes the receive socket that is linked to port 23
        // This is so the Client can send directly to the Host
        try {
            sendAndReceiveSocket = new DatagramSocket();
            receiveSocket23 = new DatagramSocket(23);
        } catch (SocketException se) {
            se.printStackTrace();
            System.exit(1);
        } 
    }

    /**
     * @author Nathan MacDiarmid 101098993
     * Send method that sends the message to the server to the specified port
     * In this case, the specified port is port 69
     */
    public void sendToServer() {
        // Initializes the DatagramPacket to be sent to the server
        sendPacket = new DatagramPacket(data, receivePacket23.getLength(), receivePacket23.getAddress(), 69);

        System.out.println( "Host: Sending packet:");
        System.out.println("To host: " + sendPacket.getAddress());
        System.out.println("Destination host port: " + sendPacket.getPort());
        int len = sendPacket.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: ");
        System.out.println(new String(sendPacket.getData(),2,len));
        this.printByteArray(data);
        System.out.println();

        // Sends the DatagramPacket to the Server
        try {
            sendAndReceiveSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Host: packet sent to Server");
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }

    /**
     * @author Nathan MacDiarmid 101098993
     * Receive method for Host that receives from the Server
     */
    public void receiveFromServer() {
        // Initializes the receive DatagramPacket to be able to receive the message
        receivePacket69 = new DatagramPacket(data, data.length);
        System.out.println("Host: Waiting for Packet.\n");

        // Receives the DatagramPacket
        try {        
            System.out.println("Waiting...");
            sendAndReceiveSocket.receive(receivePacket69);
        } catch (IOException e) {
            System.out.print("IO Exception: likely:");
            System.out.println("Receive Socket Timed Out.\n" + e);
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Host: Packet received from Server:");
        System.out.println("From host: " + receivePacket69.getAddress());
        System.out.println("Host port: " + receivePacket69.getPort());
        int len = receivePacket69.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: " );

        String received = new String(data,0,len);   
        System.out.println(received);
        this.printByteArray(data);
        System.out.println();
    }

    /**
     * @author Nathan MacDiarmid 101098993
     * Send method for Host that sends the message to the Client
     */
    public void sendToClient() {
        // Initializes the DatagramPacket to send to the Client
        sendPacket = new DatagramPacket(data, receivePacket69.getLength(),
        receivePacket23.getAddress(), receivePacket23.getPort());

        System.out.println( "Host: Sending packet:");
        System.out.println("To host: " + sendPacket.getAddress());
        System.out.println("Destination host port: " + sendPacket.getPort());
        int len = sendPacket.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: ");
        System.out.println(new String(sendPacket.getData(),0,len));
        this.printByteArray(data);
        System.out.println();

        // Sends the DatagramPacket to the Client
        try {
            sendAndReceiveSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Host: packet sent to Client");
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }

    /**
     * @author Nathan MacDiarmid 101098993
     * Receive method for Host that receives the message from the Client
     */
    public void receiveFromClient() {
        // Initializes the DatagramPacket to be received from the Client
        receivePacket23 = new DatagramPacket(data, data.length);
        System.out.println("Host: Waiting for Packet.\n");

        // Receives the DatagramPacket from the Client
        try {        
            System.out.println("Waiting...");
            receiveSocket23.receive(receivePacket23);
        } catch (IOException e) {
            System.out.print("IO Exception: likely:");
            System.out.println("Receive Socket Timed Out.\n" + e);
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Host: Packet received from Client:");
        System.out.println("From host: " + receivePacket23.getAddress());
        System.out.println("Host port: " + receivePacket23.getPort());
        int len = receivePacket23.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: " );

        String received = new String(data,2,len);   
        System.out.println(received);
        this.printByteArray(data);
        System.out.println();
    }

    /**
    * @author Nathan MacDiarmid 101098993
    * Prints a formatted array of bytes that it is passed
    * @param b an array of bytes that encode a message
    */
    public void printByteArray(byte[] b) {
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
        sendAndReceiveSocket.close();
        receiveSocket23.close();
    }

    /**
    * @author Nathan MacDiarmid 101098993
    * The main method for Host runs the Host program
    * Must be started second after Server and before Client
    * @param args
    */
    public static void main(String args[]) {
        Host host = new Host();

        for (int i = 1; i < 13; i++) {
            host.receiveFromClient();
            host.sendToServer();
            host.receiveFromServer();
            host.sendToClient();
        }
        host.closeSocket();
    }
}
