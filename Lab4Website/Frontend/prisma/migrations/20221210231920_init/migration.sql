-- CreateTable
CREATE TABLE "Sighting" (
    "id" SERIAL NOT NULL,
    "location" TEXT NOT NULL,
    "date" TEXT NOT NULL,
    "time" TEXT NOT NULL,
    "onGround" TEXT NOT NULL,

    CONSTRAINT "Sighting_pkey" PRIMARY KEY ("id")
);
