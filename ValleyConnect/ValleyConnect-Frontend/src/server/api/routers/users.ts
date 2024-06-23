import { UserType } from "@prisma/client";
import { createTRPCRouter, protectedProcedure } from "../trpc";

import { z } from "zod";


export const usersRouter = createTRPCRouter({
    getByUserType: protectedProcedure.input(z.nativeEnum(UserType)).query(async ({input, ctx}) => {
        return await ctx.db.user.findMany({where: {userType: input}});
    })

})