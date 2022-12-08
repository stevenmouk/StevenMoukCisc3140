# Purpose
The purpose of this repository is to create an API endpoint based off of PostgreSQL database, that would allow for users to
track data about squirrels on campus. Our API endpoint will support the CRUD(Create, Read, Update, Delete) operations for our database.

<br></br>
# Installation & Setup
1) Download the latest version of PostGreSQL from https://www.postgresql.org/download/. The version we used was 15. 
2) Make sure you have ExpressJS installed: https://nodejs.org/en/download/.
We first downloaded NodeJS which had dependencies and packages of ExpressJS inside it, so we did not have to download it separately.
3) Run the command: <mark>npm init</mark>. Then keep clicking until you are prompted to enter another command, in which it would be <mark>npm install express<mark>. 

<br><br>
# Endpoints
## **Get**
- <mark>localhost:8000/read</mark> - Returns the data of all the squirrels in both our table to the console. 
So if we do, <mark>localhost:8000/read/squirrel_description</mark> it will give us all entries of data in that table.
## **Post**
Couple of commands listed under post:
1. ### **Create**
- Go to postman and put the following in the body url: 
```javascript
{
    "table": "squirrel_sightings_on_campus",
    "time": "('AM', '11-11-2022 1:30 EST')" 
}
```
2. ### **Update**
- Go to postman and put the following as body url:
- Usage: When we need to update a specific row or attribute of an individual squirrel or it could the whole table as well.
```javascript
{
    "table": "squirrel_description",
    "table_col": "fur_color",
    "new_val": "white",
    "id": "4"
}
```
3. ### **Delete**
- Go to postman and put the following as body url:
- Usage: Delete an individual squirrel based on the ID provided. Each squirrel is attributed with an individual ID as we add them to our database.
```javascript
{
    "table": "squirrel_sightings_on_campus",
    "id": "1"
}
```
