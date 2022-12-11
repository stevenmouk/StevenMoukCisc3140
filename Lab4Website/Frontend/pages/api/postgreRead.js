import prisma from "../../lib/prisma";

export default async function handle(req, res) {
  const result = await prisma.sighting.findMany({});
  return res.json(result);
}
