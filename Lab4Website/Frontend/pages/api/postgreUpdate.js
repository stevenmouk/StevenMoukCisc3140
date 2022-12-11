import prisma from "../../lib/prisma";

export default async function handle(req, res) {
  // creating a new todo.
  const data = req.query;
  const what = data.what;
  const to = data.to;
  let search = JSON.parse(`{"${data.radio}":"${data.what}"}`);
  let replace = JSON.parse(`{"${data.radio}":"${data.to}"}`);

  const result = await prisma.sighting.updateMany({
    where: search,
    data: replace,
  });
  return res.json(result);
}
