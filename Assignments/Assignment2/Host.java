package Assignment2;

import java.io.*;
import java.net.*;

public class Host {
    DatagramPacket sendPacket, receivePacket23, receivePacket69;
    DatagramSocket sendAndReceiveSocket, receiveSocket23;
    byte[] data = new byte[100];

   public Host() {
      try {
         // Construct a datagram socket and bind it to any available 
         // port on the local host machine. This socket will be used to
         // send UDP Datagram packets.
         sendAndReceiveSocket = new DatagramSocket();

         // Construct a datagram socket and bind it to port 5000 
         // on the local host machine. This socket will be used to
         // receive UDP Datagram packets.
         receiveSocket23 = new DatagramSocket(23);

         // to test socket timeout (2 seconds)
         //receiveSocket.setSoTimeout(2000);
      } catch (SocketException se) {
         se.printStackTrace();
         System.exit(1);
      } 
   }

   public void sendToServer() {
        // Create a new datagram packet containing the string received from the client.

        // Construct a datagram packet that is to be sent to a specified port 
        // on a specified host.
        // The arguments are:
        //  data - the packet data (a byte array). This is the packet data
        //         that was received from the client.
        //  receivePacket.getLength() - the length of the packet data.
        //    Since we are echoing the received packet, this is the length 
        //    of the received packet's data. 
        //    This value is <= data.length (the length of the byte array).
        //  receivePacket.getAddress() - the Internet address of the 
        //     destination host. Since we want to send a packet back to the 
        //     client, we extract the address of the machine where the
        //     client is running from the datagram that was sent to us by 
        //     the client.
        //  receivePacket.getPort() - the destination port number on the 
        //     destination host where the client is running. The client
        //     sends and receives datagrams through the same socket/port,
        //     so we extract the port that the client used to send us the
        //     datagram, and use that as the destination port for the echoed
        //     packet.

        sendPacket = new DatagramPacket(data, receivePacket23.getLength(),
        receivePacket23.getAddress(), 69);

        System.out.println( "Host: Sending packet:");
        System.out.println("To host: " + sendPacket.getAddress());
        System.out.println("Destination host port: " + sendPacket.getPort());
        int len = sendPacket.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: ");
        System.out.println(new String(sendPacket.getData(),0,len));
        // or (as we should be sending back the same thing)
        // System.out.println(received); 

        // Send the datagram packet to the client via the send socket. 
        try {
            sendAndReceiveSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Host: packet sent to Server");
    }

    public void receiveFromServer() {
        // Construct a DatagramPacket for receiving packets up 
       // to 100 bytes long (the length of the byte array).
       receivePacket69 = new DatagramPacket(data, data.length);
       System.out.println("Host: Waiting for Packet.\n");
 
       // Block until a datagram packet is received from receiveSocket.
       try {        
          System.out.println("Waiting..."); // so we know we're waiting
          sendAndReceiveSocket.receive(receivePacket69);
       } catch (IOException e) {
          System.out.print("IO Exception: likely:");
          System.out.println("Receive Socket Timed Out.\n" + e);
          e.printStackTrace();
          System.exit(1);
       }
 
       // Process the received datagram.
       System.out.println("Host: Packet received from Server:");
       System.out.println("From host: " + receivePacket69.getAddress());
       System.out.println("Host port: " + receivePacket69.getPort());
       int len = receivePacket69.getLength();
       System.out.println("Length: " + len);
       System.out.print("Containing: " );
 
       // Form a String from the byte array.
       String received = new String(data,0,len);   
       System.out.println(received + "\n");
       
       // Slow things down (wait 5 seconds)
       /*try {
          Thread.sleep(5000);
      } catch (InterruptedException e ) {
          e.printStackTrace();
          System.exit(1);
      }*/
    }

    public void sendToClient() {
        // Create a new datagram packet containing the string received from the client.

        // Construct a datagram packet that is to be sent to a specified port 
        // on a specified host.
        // The arguments are:
        //  data - the packet data (a byte array). This is the packet data
        //         that was received from the client.
        //  receivePacket.getLength() - the length of the packet data.
        //    Since we are echoing the received packet, this is the length 
        //    of the received packet's data. 
        //    This value is <= data.length (the length of the byte array).
        //  receivePacket.getAddress() - the Internet address of the 
        //     destination host. Since we want to send a packet back to the 
        //     client, we extract the address of the machine where the
        //     client is running from the datagram that was sent to us by 
        //     the client.
        //  receivePacket.getPort() - the destination port number on the 
        //     destination host where the client is running. The client
        //     sends and receives datagrams through the same socket/port,
        //     so we extract the port that the client used to send us the
        //     datagram, and use that as the destination port for the echoed
        //     packet.

        sendPacket = new DatagramPacket(data, receivePacket23.getLength(),
        receivePacket23.getAddress(), receivePacket23.getPort());

        System.out.println( "Host: Sending packet:");
        System.out.println("To host: " + sendPacket.getAddress());
        System.out.println("Destination host port: " + sendPacket.getPort());
        int len = sendPacket.getLength();
        System.out.println("Length: " + len);
        System.out.print("Containing: ");
        System.out.println(new String(sendPacket.getData(),0,len));
        // or (as we should be sending back the same thing)
        // System.out.println(received); 

        // Send the datagram packet to the client via the send socket. 
        try {
            sendAndReceiveSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Host: packet sent to Client");

        sendAndReceiveSocket.close();
    }

    public void receiveFromClient() {
        // Construct a DatagramPacket for receiving packets up 
       // to 100 bytes long (the length of the byte array).
       receivePacket23 = new DatagramPacket(data, data.length);
       System.out.println("Host: Waiting for Packet.\n");
 
       // Block until a datagram packet is received from receiveSocket.
       try {        
          System.out.println("Waiting..."); // so we know we're waiting
          receiveSocket23.receive(receivePacket23);
       } catch (IOException e) {
          System.out.print("IO Exception: likely:");
          System.out.println("Receive Socket Timed Out.\n" + e);
          e.printStackTrace();
          System.exit(1);
       }
 
       // Process the received datagram.
       System.out.println("Host: Packet received from Client:");
       System.out.println("From host: " + receivePacket23.getAddress());
       System.out.println("Host port: " + receivePacket23.getPort());
       int len = receivePacket23.getLength();
       System.out.println("Length: " + len);
       System.out.print("Containing: " );
 
       // Form a String from the byte array.
       String received = new String(data,0,len);   
       System.out.println(received + "\n");
       
       // Slow things down (wait 5 seconds)
       /*try {
          Thread.sleep(5000);
      } catch (InterruptedException e ) {
          e.printStackTrace();
          System.exit(1);
      }*/
        receiveSocket23.close();
    }
}
