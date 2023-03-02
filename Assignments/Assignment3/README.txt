Assignment3
Nathan MacDiarmid
101098993

Questions

1 -
Because there would be multiple methods that would need a wait() method
as well as multiple methods that would need to notifyAll(). For example, 
each request and acknowledgement would be treated as a get or put respectively.
But, both the sendData and receiveData would also need to be treated as a get
and put method as well. Therefore possibly needing multiple Threads to handle
this dilema.

2 -
If you were to use Threads, it may have been. However, since I continued
to use UDP requests, even though they are asynchronous, the way the system
is developed, there is no need to use synchronized in the intermediate task.
This is because one command cannot run until it receives its required information
from the specific port. Therefore, not needing to use synchronized in the intermediate.

Client

This class is the one that creates and sends messages to whichever
port is specified. In the case of Assignment2, it was specified as port 23.
It has a send and receive method that creates DatagramPackets to send and 
receive them over already created DatagramSockets. It also has methods to
properly format a message in the format 0# - string of byte - 0 - mode - 0
where # is either 1 for read request or 2 for a write request. If the message sent
is something other than 1 or 2, the Server returns the message and the Server shuts down.
Lastly, the Client prints out the message in String format as well as byte format
when both sending and receiving. Upon sending a message, the Client receives an acknowledgement
from the Host that it has received the message. To receive a message, the Client must request it
from the Host.

Host

This class is the intermediate Host or middle man between the Client
and the Server. It has methods that send and receive specifically to
the Client and Server respectfully. The Host sets up two DatagramSockets
that are linked to port 23 and port 69. This allows for the Client and Server to send directly
to the Host. When sending to the Server, it specifies the port that was sent by
the Server request sent prior.
The Host does not change the message, just simply forwards it to the Server.
The Host simply acknowledges the requests and sends them that its been acknowledged.
The Host must receive a request for the message before sending the message to the requestor.

Server

This class is the one that receives all the incoming message from the Host
that were sent from the Client. The Server has send and receive methods
that determine what type of message it is (read or write), the message itself
and the mode in which to decode the byte array. If the message is a read message,
the Server formats a 4 bit byte array that when sent back to the Client is a 
smiley face and heart emoji. If the message is a write message, the byte array sent back
is a diamond emoji.
The Server must request the message prior to receiving.
Upon sending the return message, the Server receives acknowledgement from the Host
that the message has been received.

Closing Sockets

When each of the classes are done sending and receiving, a method called 
closeSocket() is called and closes all the open sockets that were created.

Opening the Project

When opening in eclipse, unzip the file and click file and open project.
Open the Assignment3 parent folder that contains src and bin folders.

Running the Project

When running, run the main method in Host first.
Then run the main method in Server second.
The run the main method in Client last.
This allows the Host to be initialized on port 23 and 69,
and allows the Client to properly send the messages to
port 23 and then onward.
This also allows Server to properly send messages to port 69
and then onward.