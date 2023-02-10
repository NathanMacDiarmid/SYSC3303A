Assignment2
Nathan MacDiarmid
101098993

Client

This class is the one that creates and sends messages to whichever
port is specified. In the case of Assignment2, it was specified as port 23.
It has a send and receive method that creates DatagramPackets to send and 
receive them over already created DatagramSockets. It also has methods to
properly format a message in the format 0# - string of byte - 0 - mode - 0
where # is either 1 for read request or 2 for a write request. If the message sent
is something other than 1 or 2, the Server returns the message and the Server shuts down.
Lastly, the Client prints out the message in String format as well as byte format
when both sending and receiving.

Host

This class is the intermediate Host or middle man between the Client
and the Server. It has methods that send and receive specifically to
the Client and Server respectfully. The Host sets up a DatagramSocket
that is linked to port 23, which allows for the Client to send directly
to the Host. When sending to the Server, it specifies the port 69 to be sent.
The Host does not change the message, just simply forwards it to the Server.

Server

This class is the one that receives all the incoming message from the Host
that were sent from the Client. The Server has send and receive methods
that determine what type of message it is (read or write), the message itself
and the mode in which to decode the byte array. If the message is a read message,
the Server formats a 4 bit byte array that when sent back to the Client is a 
smiley face and heart emoji. If the message is a write message, the byte array sent back
is a diamond emoji.

Closing Sockets

When each of the classes are done sending and receiving, a method called 
closeSocket() is called and closes all the open sockets that were created.

Opening the Project

When opening in eclipse, unzip the file and click file and open project.
Open the Assignment2 parent folder that contains src and bin folders.

Running the Project

When running, run the main method in Server first.
Then run the main method in Host second.
The run the main method in Client last.
This allows the Server to be initialized on port 69,
allows the Host to be initialized on port 23,
and allows the Client to properly send the messages to
port 23 and then onward.