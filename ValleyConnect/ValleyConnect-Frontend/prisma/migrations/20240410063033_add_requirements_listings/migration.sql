/*
  Warnings:

  - You are about to drop the column `UpdatedOn` on the `Brand` table. All the data in the column will be lost.
  - You are about to drop the column `UpdatedOn` on the `Listing` table. All the data in the column will be lost.
  - You are about to drop the column `platform` on the `Listing` table. All the data in the column will be lost.
  - You are about to drop the column `UpdatedOn` on the `Tag` table. All the data in the column will be lost.
  - Added the required column `updatedOn` to the `Brand` table without a default value. This is not possible if the table is not empty.
  - Added the required column `platforms` to the `Listing` table without a default value. This is not possible if the table is not empty.
  - Added the required column `requirements` to the `Listing` table without a default value. This is not possible if the table is not empty.
  - Added the required column `updatedBy` to the `Listing` table without a default value. This is not possible if the table is not empty.
  - Added the required column `updatedOn` to the `Listing` table without a default value. This is not possible if the table is not empty.
  - Added the required column `updatedOn` to the `Tag` table without a default value. This is not possible if the table is not empty.

*/
-- AlterTable
ALTER TABLE "Brand" DROP COLUMN "UpdatedOn",
ADD COLUMN     "updatedOn" TIMESTAMP(3) NOT NULL;

-- AlterTable
ALTER TABLE "Listing" DROP COLUMN "UpdatedOn",
DROP COLUMN "platform",
ADD COLUMN     "platforms" TEXT NOT NULL,
ADD COLUMN     "requirements" TEXT NOT NULL,
ADD COLUMN     "updatedBy" TEXT NOT NULL,
ADD COLUMN     "updatedOn" TIMESTAMP(3) NOT NULL;

-- AlterTable
ALTER TABLE "Tag" DROP COLUMN "UpdatedOn",
ADD COLUMN     "updatedOn" TIMESTAMP(3) NOT NULL;
