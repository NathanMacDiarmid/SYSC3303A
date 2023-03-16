Assignment 4
Nathan MacDiarmid
101098993

The goal of this assignment was to create a hierarchical
state machine that only needed to be started once and
then would run until the end of time. The state machine
was modeled after a traffic light with a cross-walk, changing
from green to yellow to red and then allowing pedestrians to
cross, flashing them a walk signal.

To run the program (outside of the test harness) run the main
method in Main. It will run forever, so make sure to stop it when
you see fit.

Main
Creates an instance of Context which simply starts the state machine.

Context
The Context file passes the information from each state to the next
state.

State
The State abstract class is the parent class for all of the different states.
It contains constants such as the light colours, the pedestrian flash time,
whether the pedestrian is waiting or not, and traffic light itself (signalVehicles).
All states inherit from this class and in turn get all its functions and attributes.

VehiclesEnabled
The VehiclesEnabled class inherits from the State abstract class and implements
the timeout and isPedestrianWaiting methods.

VehiclesGreen
The VehiclesGreen class inherits from the State abstract class and implements
the timeout and isPedestrianWaiting methods.

VehiclesYellow
The VehiclesYellow class inherits from the State abstract class and implements
the timeout and isPedestrianWaiting methods.

PedestriansEnabled
The PedestriansEnabled class inherits from the State abstract class and implements
the timeout and isPedestrianWaiting methods.

PedestriansWalk
The PedestriansWalk class inherits from the State abstract class and implements
the timeout and isPedestrianWaiting methods.

PedestriansFlash
The PedestriansFlash class inherits from the State abstract class and implements
the timeout and isPedestrianWaiting methods.