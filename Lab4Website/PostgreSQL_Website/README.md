## Getting Started with server

The backend of this project is built with Nextjs, prisma, and postgreSQL. Prisma is an ORM to help get connected to postgreSQL. To get started with the server, download postgreSQL 15 and run a server on localhost:5432. The docs can be found at https://www.postgresql.org/docs/).

You can easily start a server using the postges app. The potgres app makes it very easy to start a postgres server. The documentation and download for the app can be found at: (https://postgresapp.com/downloads.html). The next step is to download pg Admin. This helps to manage the postgreSQL database. The download link can be found at: (https://www.pgadmin.org/download/).

Within pg Admin, I created a database called Squirrel with username: "postgres" and password: "admin" . This will complete the setup of the database.

Within the project, enter the prisma folder and the schema.prisma file. This is where the schema for the datbase was created. It uses the DATABASE_URL that can be found in the .env file. This is how I connect the local database to the backend. In this file, you can also see the schema which is the Sighting table. It has the inputs of id,location, date, time, onGround. These are all of my inputs for the table. The id portion increments itself and the rest is user entered.

Finally, the lib/prisma.js file creates the client prisma connection which is used in the api calls.

The prisma documentation can be found at (https://www.prisma.io/docs)

## Api Endpoints

The api endpoints can be found in the pages/api folder. There are 4 api endponts. These are used for create, Read, update, delete and they are labeled accordingly. The postgreAdd.js is the endpoint for adding a new sighting. postgreRead is used to read a new sighting. PostgreUpdate.js is used to update a sighting and same for delete. They all use the prisma crud guide found at(https://www.prisma.io/docs/concepts/components/prisma-client/crud)

## Running the website

First, run the development server:

```bash
yarn
# followed by
yarn dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `pages/index.js`. This page contains the front end and makes fetch calls to the backend api. It is made with react and next js. The html in the document is the front end. The functions at the top are the api calls to the custom api endpoints I made in the pages/api folder. The styles are also in this file with the className in the html markup being the styles.
