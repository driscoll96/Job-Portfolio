
import { z } from "zod";
import { createTRPCRouter, protectedBrandProcedure, publicProcedure, } from "../trpc";
import { db } from "~/server/db";



export const listingsRouter = createTRPCRouter({
    getAll: publicProcedure.query(async ({ctx}) => {
        const listings = await ctx.db.listing.findMany({where: {status: 'ACTIVE'}});
        return listings;
    }),
    createListing: protectedBrandProcedure.input(z.object({name: z.string(), description: z.string(), requirements: z.string(), platforms: z.string(), brandId: z.string()})).mutation(async ({input, ctx}) => {
        await db.listing.create({data: {
            ...input,
            createdOn: new Date(),
            createdBy: ctx.session.user.id,
            updatedOn: new Date(),
            updatedBy: ctx.session.user.id,
            status: 'ACTIVE'
        }});
        })});
    
