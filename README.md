# flightApplication

# brief explanation of the project:

This android application allows the user to control the dashboard of a plane in a flight simulation.

# Added Features:

 Main screen that has 2 fileds to insert the port and the ip to connect to the FlightGear simulator.
 underneath those fileds there are 2 buttoms. the first one connects to the server and the second one closes the connection.
 in the bottom part of the screen there are 2 slideBars. the vertical slideBar controls the throttle and the horizontal slideBar controls the rudder.
 between them there is a Joystick that controls the aileron and the elevator.

# Compiling and Running

First, we need to open the flightGear and in the setting add:
--telnet=socket,in,10,127.0.0.1,6400,tcp
(6400 is the number of port)

Then we can open our Application.
When the app is opened the Main screen is showen.
The user needs to insert an IP address and a port number (the same number we defined in the FlightGear) then press the submit button.
in the FlightGear we need to press the autostart to start the engine and then we could start controling our plane.

# code design and architechture

We used the MVVM architechture in oreder to build our project.
the View part is the xml file that has the Visibility control, it present the features of the application to the user.
the moment the user moves or clicks any of the tools in the screen the View send a notification to the View Model.
The ViewModel holds a model field. when he gets a notification that the view send he uses the matching method in the model.
the Model implement the wanted action that we want to do in each occasion.

# UML chart:

Press [here](https://github.com/Ruth-Rot/flightApplication/blob/master/uml.png) to see the uml diagram

# Explanation Video

press here to watch our explanation videw: 

# Collaborators

This program was developed by Ruth Lofsky and Shaked Arel.
