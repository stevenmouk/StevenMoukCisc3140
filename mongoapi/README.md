## Completed Website

The hosted website can be found at (https://hosted-mongo-api-uxub.vercel.app/)

Here you can add,delete,edit inputs into the atlas database. It has a front end connected to the backend api.

## Getting Started

First, run the development server:

```bash
yarn
# followed by
yarn dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `pages/index.js`. This page contains the front end and makes fetch calls to the backend api. It is made with react and next js. The html in the document is the front end. The functions at the top are the api calls to the custom api I made. The styles are also in this file with the className in the html markup being the styles.

The `pages/api` folder contains all of the api endpoints. The `addSighting.js` file contains the endpoint to add a new input. Once the form is submitted in `pages/index.js`, the handleSubmit function in the `index.js` file is called to capture the form inputs and make a fetch request to the `pages/api/addSighting.js` api endpoint. This is true for add,delete,read, update files in the api folder.

Another example is the handleDelete function in the `pages/index.js`. Once the trash icon is pressed, the handleDelete function is called. The function makes a fetch request to the `pages/api/deleteSighting.js` file which is the api endpoint for deleting.

The `lib/mongodb.js` file is where I connect to the atlas database. This code is mostly boilerplate and provided by mongoDB Atlas to allow for connecting to a collection. It uses the MongoDB URI String which can be found in the .env file.

## Data Capacity

Since this is a hosted database, the data can be added manually by anyone and can hold virtually endless amounts of data. Even adding data in the localhost will add the data to the cloud database since a connection to the collection is made. As such, anyone can come and add or delete data. This is not ideal but it works for testing and learning how to use the api endpoints of a database. The database can hold well over 100 data inputs, but since anyone can come and delete them, I chose to not add that many. There are about 20 last time I checked but the database can hold an endless about of data but will need to be paid for one it reaches the limit.

## Learn More on MongoDB Atlas

The mongoDB Atlas documentation can be found at (https://www.mongodb.com/docs/atlas/).

## Run Script

The script.sh file can be run to locally run the website. After running script.sh, simply open (http://localhost:3000) to see the finished website.

## Deploy on Vercel

The way I deployed the Next.js app is to use the [Vercel Platform](https://vercel.com/new?utm_medium=default-template&filter=next.js&utm_source=create-next-app&utm_campaign=create-next-app-readme)

The documentation can be found at(https://nextjs.org/docs/deployment)
