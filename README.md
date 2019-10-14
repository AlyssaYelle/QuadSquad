# QUAD SQUAD
A social media experience designed by Alyssa Jones, Tefe Del Rosario-Bell, & Ashley Joseph

## Concept
QUAD SQUAD is an online forum for lifting enthusiasts to share their acheivements, seek advice, find information about competitions, and generally connect with other individuals who have or desire fabulous quads. No arms bros allowed!

## User Stories
![Entity-Relationship Diagram](/img/freya.png)
![Entity-Relationship Diagram](/img/shayla.png)
![Entity-Relationship Diagram](/img/marten.png)
![Entity-Relationship Diagram](/img/edgar.png)

## Technologies Used
Back end: Java, Springboot

Front end: Javascript, HTML, CSS

Collaboration: Git/github

## Database Structure
![Entity-Relationship Diagram](/img/luv-letters-to-dogs.png)

## API Structure

![API Structure](/img/API-Structure.png)

## Front-end Design
The code for our front-end design is located [here](https://github.com/AlyssaYelle/front-end-designs-misc/tree/master/quad-squad).

See user flow diagram below.

![User flow diagram](/img/user-flow-site.png)

## Timeline

### Days 1-2
Preplanning, discuss front end and back end project requirements, establish flow chart of SQL mapping and other wireframes

### Days 3-4
Creation of SQL database, set up security configuration, dev properties, begin writing models and other java classes.

### Days 5-6
Continue updating the java classes, fine-tune the code snippets and API design, brainstorming ideas for front end, begin unit testing and API testing

### Days 7-8
Redesign of front end, creating user stories, test user functions on front end,  finish unit testing on back end, resolve any integration issues of merging front and back

### Day 9
Test full functionality, discuss presentation of project, complete any missing deliverables

## Final Thoughts
Project 2 proved to be more accessible and easier to transform from concept to completion than Project 1. We had cultivated more experience working both independently and in group settings on class lab assignments and thus, more seemed to go well for our team than awry. Our general approach was to first create an ER diagram to establish the database relations between a person using the app, posts created, comments made to a post and any other necessary entities. Then we set about writing the code for the program files following the general workflow of creating models, repositories, service files, implementation files, and then controllers. White boarding was very helpful in the process of discussing relations, especially when we had to revise the roles and make tweaks to the mappings.

The pushing and pulling and merging of content through Github was sometimes a nuisance. On the very first day of working together, a substantial amount of file creation was lost due to a git-ignore error. Files that were supposed to be ignored were not and ended up in the 'master,' and this caused unfixable compilation errors. We abandoned attempts at debugging and decided to start the project over. Another hurdle was the realization that the front end and back end could not communicate with one another due to port sharing conflicts. This required research and the implementation of a CORS security file which was wholly unfamiliar to us.

One advantage gained while working on Project 2 was our ability to make use of a three-member team. Simply put: more help in accomplishing tasks. None of the hurdles proved excessively challenging. We even found enough time to devise a new front end design and concept. Writing user stories for the concept was left for the end of the process.

Overall we enjoyed working on and completing this project. We gained immeasurably from the exercise of putting everything we had learned about Springboot into practice.

