-- CreateEnum
CREATE TYPE "UserType" AS ENUM ('CREATOR', 'BRAND', 'BASIC');

-- AlterTable
ALTER TABLE "User" ADD COLUMN     "userType" "UserType" NOT NULL DEFAULT 'BASIC';
