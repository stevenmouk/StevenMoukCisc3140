import { Client } from "pg";

const client = new Client({
  user: process.env.PGSQL_USER,
  password: process.env.PGSQL_PASSWORD,
  host: process.env.PGSQL_HOST,
  port: 5432,
  database: process.env.PGSQL_DATABASE,
});

client.connect().then(() => console.log("workds"));
