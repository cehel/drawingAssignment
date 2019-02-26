# How to start the Drawing tool

The Drawing tool can be started with the delivered jar
  - start the delivered jar in a command line tool like this: java -jar drawing-1.0.0.jar

Rebuild the jar
  - install maven and run 'mvn clean install' inside the ./assignment folder
  - you will find the built jar in the ./assignment/target folder

# Functionality of the Drawing tool
Command description
  - C w h           Should create a new canvas of width w and height h.
  - L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
  - R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
  - B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
  - Q               Should quit the program.