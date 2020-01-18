# Canoe Polo Game Planner Project

## Index ##
* [Intro](#intro)
* [Features](#features)
* [Testing](#testing)
* [Deployment](#deployment)
* [Technolgies](#technologies)
* [Support](#support)

<a name="intro"></a>
## My Project: ##

The aim was to create an OOP-based application, with two related tables and CRUD functionality. 
I have made an application which can be used to plan future games for my canoe polo team by recording the date,
location, opposition and players in the team. There is a many to many relationship between players and games
so all the players can be added to more than one game. There is CRUD functionality as it is possible to create,
view, delete and update the players and to create, view and delete games.

<a name="features"></a>
## Features ##

* Create: 
Can create new players and new game plans

* Read: 
Players are displayed in a select box where they can be selected to add to gameplans.
      
Games are displayed in the game plan table where new rows are dynamically created when a game is added.

* Update: 
Players can be updated

* Delete: 
Players and games can be deleted

<a name="testing"></a>
### Testing ###

Unit testing: JUnit and Mockito tests - 80.1 % coverage (See [SureFire Report Summary]())
SonarQube: static reporting and refactoring - Build = pass

<a name="deployment"></a>
### Deployment ###

Jenkins was used to automate the build, test and deployment processes, with a webhook to GitHub which was triggered 
with every push event.


<a name="technologies"></a>
## Technologies ##

* H2 Database (mySQL) - Database
* Java SpringBoot (2.2.2) - Back-end
* JavaScript, HTML5, CSS - Front-end
* Maven (3.6.0) - Build Tool

<a name="support"></a>
## Browser Support ##

![Chrome](https://raw.github.com/alrra/browser-logos/master/src/chrome/chrome_48x48.png) | ![Firefox](https://raw.github.com/alrra/browser-logos/master/src/firefox/firefox_48x48.png) | 
--- | --- | 
Latest ✔ | Latest ✔ |

## Author ##

Jess Layton

