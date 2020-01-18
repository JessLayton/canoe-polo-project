# Canoe Polo Game Planner Project



## The Brief: ##

To create an OOP-based application, manipulating two tables and including CRUD functionality 

## My Project: ##

I have made an application which can be used to plan future games for my canoe polo team by recording the date,
location, opposiition and players in the team. There is a many to many relationship between players and games
so all the players can be added to more than one game. There is CRUD functionality as it is possible to create,
view, delete and update the players and to create, view and delete games.

## Architecture: ##

### Entity Relationship Diagram ###

<p align="center">
  <img width="460" height="300" src="">
</p>

### Testing ###

Unit testing has been carried out using JUnit and Mockito tests, and SonarQube has been used for static reporting
and refactoring.

Back-end test coverage is at 80.1% which meets my goal of 80% coverage. I would like to carry out Selenium testing
of the front-end in the future. It passes the SonarQube quality gate, confirming that my project is production-ready.

<p align="center">
  <img width="460" height="300" src="">
</p>

### Deployment ###

Jenkins was used to automate the build, test and deployment processes, with a webhook to GitHub which was triggered 
with every push event.

<p align="center">
  <img width="460" height="300" src="">
</p>

## Technologies ##

* H2 Database (mySQL) - Database
* Java SpringBoot (2.2.2) - Back-end
* JavaScript, HTML5, CSS - Front-end
* Maven (3.6.0) - Build Tool

## Author ##

Jess Layton

