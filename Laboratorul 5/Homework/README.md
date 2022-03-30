Homework (2p)

Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.

Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.).

list: prints the list of items on the screen;

view: opens an item using the native operating system application (see the Desktop class);

report: creates (and opens) an HTML report representing the content of the catalog.

Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.

(+1p) Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them.

The application will signal invalid date or the commands that are not valid using custom exceptions.

The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

All the commands are imlemented in package commands and de classes: Main ,Item,Catalog,Book,Article are in base package.

In class InfoCommand i tried to get the metadatas from the catalog items using Apache Tika and display them .

