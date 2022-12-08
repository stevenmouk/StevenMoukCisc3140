const { Client } = require("pg");
const myExpress = require("express");
const myAppParse = require("body-parser");
const { request } = require("express");
const app = myExpress();
app.use(myAppParse.json({ extended: true }));
const port = 8000;
const cred = { // credentials to our database.
    user: "postgres",
    host: "localhost",
    database: "Squirrel-Tracking",
    password: "jamesliwood12",
    port: "5432",
};

app.get('/', (req, res) => { // the path that we give are the api endpoints
    res.end("welcome to this api.\n" +
        "/create to insert elements into a database.\n" +
        "/delete to delete elements into a database.\n" +
        "/update to update elements into a database.");
});

app.get('/read', (req, res) => {
    var myQuery;
    var myQuery2;
    const connection = async () => {
        try {
            const myClient = new Client(cred);
            await myClient.connect();
            myQuery = await myClient.query("SELECT * FROM squirrel_description"); // the query function returns a JSON object
            myQuery2 = await myClient.query("SELECT * FROM squirrel_sightings_on_campus");

            res.end(JSON.stringify(myQuery.rows) + "\n" + JSON.stringify(myQuery2.rows)); // turn rows into a string
            await myClient.end();
        }
        catch (error) {
            console.log("Error");
        }
    };
    connection();
});

app.post('/create', (req, res) => {
    var createTable;
    const connection = async () => {
        try {
            const myClient = new Client(cred);
            await myClient.connect();
            // we're converting the JSON object that we passed to the request into a query statement.
            createTable = await myClient.query("INSERT INTO " + req.body.table + " VALUES " + req.body.time);

            await myClient.end();
            res.sendStatus(200);
        }
        catch (error) {
            console.log(error);
            res.sendStatus(400);
        }
    };
    connection();
});

app.post('/delete', (req, res) => {
    var deleteTable;
    const connection = async () => {
        try {
            const myClient = new Client(cred);
            await myClient.connect();
            // we're converting the JSON object that we passed to the request into a query statement.
            deleteTable = await myClient.query("DELETE FROM " + req.body.table + " WHERE id = " + req.body.id);

            await myClient.end();
            res.sendStatus(200);
        }
        catch (error) {
            console.log(error);
            res.sendStatus(400);
        }
    };
    connection();
});

app.post('/update', (req, res) => {
    var updateTable;
    const connection = async () => {
        try {
            const myClient = new Client(cred);
            await myClient.connect();
            // we're converting the JSON object that we passed to the request into a query statement.
            updateTable = await myClient.query("UPDATE " + req.body.table + " SET " + req.body.table_col + " = '" + req.body.new_val +
                "' WHERE id = " + req.body.id);

            await myClient.end();
            res.sendStatus(200);
        }
        catch (error) {
            console.log(error);
            res.sendStatus(400);
        }
    };
    connection();
});

app.listen(port, () => { // app.listen will open the server
    console.log(`app listening at http://localhost:${port}`);
});