Homework (2p)

- [x]Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.

Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.).

list: prints the list of items on the screen;

view: opens an item using the native operating system application (see the Desktop class);

report: creates (and opens) an HTML report representing the content of the catalog.

Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.

(+1p) Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them.

The application will signal invalid date or the commands that are not valid using custom exceptions.

The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

All the commands are implemented in package commands and the classes: Main ,Item,Catalog,Book,Article are in base package.

In class InfoCommand i tried to get the metadatas from the catalog items using Apache Tika and display them .

In package exception i have MyException class which i use in add method in Catalog to see if an item I am trying to add is aleardy in the array.In main i am adding the same article twice but I commented on the add part so as not to display the error(for articole 2)

In target folder, items.txt is used in ViewCommand to see the items and in catalog.json i am saving the catalog ,then in LoadCommand i am retrieving the catalog.

I also used a custom exception in method add from class Catalog where I check if an item was already added before .The exception class is in package exception. 
