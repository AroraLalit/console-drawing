# ConsoleDrawing Application
Console drawing app supports drawing shapes like line, rectangle etc into the canvas

*** The Problem ***

__Description__

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit


Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behavior of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

__Sample I/O__

````text
Below is a sample run of the program. User input is prefixed with enter command:

enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q
````
__Build__ <br />
To build the executable Jar, run the following maven command in the project root directory:
$ mvn clean package

It will create a jar consoledrawing-1.0.0-jar-with-dependencies.jar in <project root>/target directory.

__Run__ <br />
To run the program:
$ java -jar consoledrawing-1.0.0-jar-with-dependencies.jar

alternatively use below command to exeute using maven execution pluggin.
$ mvn exec:java

__Test__ <br />
$ mvn test

It will run all the tests available in the application. I have used Jacoco to generate test report with coverage. It will be available under root>/target/my-reports directory. The test coverage is currently 89% we can improve it more based on the minimum required threshold.

__Assumption__ <br />
No assumption as such.

__Project Structure__ <br />
Used Maven as the build tool but didn't use spring to make it lightweight java application. The ConsoleDrawingApplication starts working from Main method, it generates relevant command object based on the user input and execute the command for user just like a TV remote. The Commands in the background generates desired object and append same in the available canvas and paints the updated canvas on the console. 

__Algorithms__ <br />
Used BFS to solve the Bucket Fill problem.

__Design__ <br />
Used a Mixture of Factory and Command Pattern to solve the object creational and behavioural problems.

__3rd Party Liberaries__ <br />
Junit5 - for unit testing the application. <br />
Mockito - for testing the void methods in application and increase the code coverage.<br />
We have skipped using Log4J as this needs to be simple console application.

__Maven Pluggins__ <br />
Compiler - to specify the project compilation and target java version. <br />
SureFire -  to run junit tests during the build phase of the application. <br />
Assembly - to package the executable Jar file. <br />
Execution - To run application using maven command.