JDBC - World Cities

Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

The main specifications of the application are:

Compulsory (1p)

- [x] Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).

- [x] Write an SQL script that will create the following tables:

countries: id, name, code, continent

continents: id, name

- [x] Update pom.xml, in order to add the database driver to the project libraries.

- [x] Create a singleton class in order to manage a connection to the database.

- [x] Create DAO classes that offer methods for creating countries and continents, and finding them by their ids and names;

- [x] Implement a simple test using your classes.

For this problem i used postgresql ,where the tables looks something like this:

![image](https://user-images.githubusercontent.com/79132498/164899595-786da35e-2827-4a36-ab12-24be46d2b9df.png)


![image](https://user-images.githubusercontent.com/79132498/164899876-cb3e8b4f-549d-441d-9b28-b32683ff2223.png)


The projects has two packages , in package DAO i have ContinentDAO and CountryDAO and in database i have Database .

I test my project using method printCountries and printContinents to print  all countries and continents and also printCountriesFromContinent(continent id) to print all the countries that have this continent id.

The output looks like this:

![image](https://user-images.githubusercontent.com/79132498/164908162-af78b67d-5840-4928-8766-1dc5bdb87012.png)
