import prisma from "../../lib/prisma";

export default async function handle(req, res) {
  // creating a new todo.
  const data = req.query;

  const location = data.location;
  const date = data.date;
  const time = data.time;
  const onGround = data.onGround;

  const result = await prisma.sighting.create({
    data: {
      location,
      date,
      time,
      onGround,
    },
  });
  return res.json(result);
}
