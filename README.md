This application draws a canvas in the console.

It manages four models:

Canvas - the main table where put the figures
Point - the point to insert in the canvas
Figure - the rectangle or the line to insert in the canvas
Color - the color point where start to color in the canvas

Each module has its own renderer. The renderer is thought as an object that create a piece of matrix.

The application starts through a frontend managed by the following objects:

Starter - the frontend that starts the application. It calls an interpreter and it passes the commands wrote by the user in a shell console
Interpreter - the engine that interprets the commands and converts them in a matrix through the renderers
Command - the command passed by the shell. It contains the name of the command and the relative parameters
CommandName - the name of teh command (C,L,R,B,Q)

The errors in the shell are represented by a simple try/catch in the starter that catch the unsupported error in the case a line is diagonal and a generic exception for all other errors.

There is a junit test case representing the cases described in the specs document.

The build is wrote with maven. To start build the application and start the test simply uses the command: mvn install.

