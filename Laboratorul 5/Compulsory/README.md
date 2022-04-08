Bibliography Management System

Write an application that can manage a catalog of resources (bibliographic references), such as books, articles, etc.
These resources might be represented by files in the local file system or a Web address. Apart from a unique identifier, a title and its location, a resource may have additional properties such as author(s), what year it was publihsed, description, etc.


Example of entries in the catalog might be:

{"id":"knuth67", "title":"The Art of Computer Programming", "location":"d:/books/programming/tacp.ps", "year":"1967", "author":"Donald E. Knuth", "type": "book"};  
{"id":"java17", "title":"The Java Language Specification", "location":"https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "year":"2021", "author":"James Gosling & others"}; 

Compulsory (1p)

- [x] Create an object-oriented model of the problem. You should have at least the following classes: Catalog and Item. The items should have at least a unique identifier, a title and its location. Consider using an interface or an abstract class in order to describe the items in a catalog.

- [x] Implement the following methods representing commands that will manage the content of the catalog:

add: adds a new entry into the catalog;

toString: a textual representation of the catalog;

save: saves the catalog to an external file using JSON format; you may use Jackson or other library;

load: loads the catalog from an external file.

- [x] The load and save methods are implimented in class CatalogCommands
- [x] The books are in folder Books and the catalog is saved in folder 'saved catalog' in a txtct file 
