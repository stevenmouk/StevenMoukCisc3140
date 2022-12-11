import prisma from "../../lib/prisma";

export default async function handle(req, res) {
  // creating a new todo.
  const data = req.query;

  const deleteItem = data.id;
  console.log(deleteItem);
  const result = await prisma.sighting.delete({
    where: {
      id: Number(deleteItem),
    },
  });
  return res.json(result);
}
