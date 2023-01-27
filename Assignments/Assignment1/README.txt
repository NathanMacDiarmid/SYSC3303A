SYSC3303A Assignment1
Nathan MacDiarmid
101098993

Agent
This class is the producer class for two of the three
ingredients needed for a sandwhich. It then passes the
ingredients to the Table that locks the ingredients 
there until the correct consumer comes to collect the ingredients.

Chef
This class is the consumer class for the last of the
three ingredients needed for a sandwhich. It then
alers the Table that it has consumed the sandwhich with
the correct ingredient (the one that's missing).
This then unlocks the Table so the Agent can add 
two new ingredients.

Table
This class is the middle man or the Box class that
holds the ingredients and waits for the correct consumer
to come collect the ingredients. It verifies that only
Chef's with specific ingredients can access the ingredients
that are stored on the Table.

Main
This class initializes all of the classes and all of the
Threads that are needed to run the program. It also calls
.start() which kicks off the method .run() in each of the
Threads (this is the run() method in Agent and Chef()). This
class is where you will compile and run the program.