
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE EXTENSION IF NOT EXISTS "pgsodium" WITH SCHEMA "pgsodium";

ALTER SCHEMA "public" OWNER TO "postgres";

CREATE EXTENSION IF NOT EXISTS "pg_graphql" WITH SCHEMA "graphql";

CREATE EXTENSION IF NOT EXISTS "pg_stat_statements" WITH SCHEMA "extensions";

CREATE EXTENSION IF NOT EXISTS "pgcrypto" WITH SCHEMA "extensions";

CREATE EXTENSION IF NOT EXISTS "pgjwt" WITH SCHEMA "extensions";

CREATE EXTENSION IF NOT EXISTS "supabase_vault" WITH SCHEMA "vault";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA "extensions";

SET default_tablespace = '';

SET default_table_access_method = "heap";

CREATE TABLE IF NOT EXISTS "public"."Account" (
    "id" text NOT NULL,
    "userId" text NOT NULL,
    "type" text NOT NULL,
    "provider" text NOT NULL,
    "providerAccountId" text NOT NULL,
    "refresh_token" text,
    "access_token" text,
    "expires_at" integer,
    "token_type" text,
    "scope" text,
    "id_token" text,
    "session_state" text
);

ALTER TABLE "public"."Account" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."Brand" (
    "id" text NOT NULL,
    "name" text NOT NULL,
    "image" text,
    "description" text,
    "verified" boolean NOT NULL,
    "createdOn" timestamp(3) without time zone NOT NULL,
    "createdBy" text NOT NULL,
    "UpdatedOn" timestamp(3) without time zone NOT NULL,
    "status" text NOT NULL
);

ALTER TABLE "public"."Brand" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."BrandTag" (
    "id" text NOT NULL,
    "brandId" text NOT NULL,
    "image" text,
    "createdOn" timestamp(3) without time zone NOT NULL,
    "createdBy" text NOT NULL,
    "updatedOn" timestamp(3) without time zone NOT NULL,
    "status" text NOT NULL
);

ALTER TABLE "public"."BrandTag" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."Listing" (
    "id" text NOT NULL,
    "name" text NOT NULL,
    "description" text NOT NULL,
    "brandId" text NOT NULL,
    "platform" text NOT NULL,
    "image" text,
    "createdOn" timestamp(3) without time zone NOT NULL,
    "createdBy" text NOT NULL,
    "UpdatedOn" timestamp(3) without time zone NOT NULL,
    "status" text NOT NULL
);

ALTER TABLE "public"."Listing" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."Session" (
    "id" text NOT NULL,
    "sessionToken" text NOT NULL,
    "userId" text NOT NULL,
    "expires" timestamp(3) without time zone NOT NULL
);

ALTER TABLE "public"."Session" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."Tag" (
    "id" text NOT NULL,
    "name" text NOT NULL,
    "createdOn" timestamp(3) without time zone NOT NULL,
    "createdBy" text NOT NULL,
    "UpdatedOn" timestamp(3) without time zone NOT NULL,
    "status" text NOT NULL
);

ALTER TABLE "public"."Tag" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."User" (
    "id" text NOT NULL,
    "name" text,
    "email" text,
    "emailVerified" timestamp(3) without time zone,
    "image" text
);

ALTER TABLE "public"."User" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."VerificationToken" (
    "identifier" text NOT NULL,
    "token" text NOT NULL,
    "expires" timestamp(3) without time zone NOT NULL
);

ALTER TABLE "public"."VerificationToken" OWNER TO "postgres";

CREATE TABLE IF NOT EXISTS "public"."_prisma_migrations" (
    "id" character varying(36) NOT NULL,
    "checksum" character varying(64) NOT NULL,
    "finished_at" timestamp with time zone,
    "migration_name" character varying(255) NOT NULL,
    "logs" text,
    "rolled_back_at" timestamp with time zone,
    "started_at" timestamp with time zone DEFAULT now() NOT NULL,
    "applied_steps_count" integer DEFAULT 0 NOT NULL
);

ALTER TABLE "public"."_prisma_migrations" OWNER TO "postgres";

ALTER TABLE ONLY "public"."Account"
    ADD CONSTRAINT "Account_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."BrandTag"
    ADD CONSTRAINT "BrandTag_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."Brand"
    ADD CONSTRAINT "Brand_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."Listing"
    ADD CONSTRAINT "Listing_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."Session"
    ADD CONSTRAINT "Session_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."Tag"
    ADD CONSTRAINT "Tag_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."User"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY ("id");

ALTER TABLE ONLY "public"."_prisma_migrations"
    ADD CONSTRAINT "_prisma_migrations_pkey" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "Account_provider_providerAccountId_key" ON public."Account" USING btree (provider, "providerAccountId");

CREATE UNIQUE INDEX "Session_sessionToken_key" ON public."Session" USING btree ("sessionToken");

CREATE UNIQUE INDEX "User_email_key" ON public."User" USING btree (email);

CREATE UNIQUE INDEX "VerificationToken_identifier_token_key" ON public."VerificationToken" USING btree (identifier, token);

CREATE UNIQUE INDEX "VerificationToken_token_key" ON public."VerificationToken" USING btree (token);

ALTER TABLE ONLY "public"."Account"
    ADD CONSTRAINT "Account_userId_fkey" FOREIGN KEY ("userId") REFERENCES public."User"(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY "public"."BrandTag"
    ADD CONSTRAINT "BrandTag_brandId_fkey" FOREIGN KEY ("brandId") REFERENCES public."Brand"(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY "public"."BrandTag"
    ADD CONSTRAINT "BrandTag_createdBy_fkey" FOREIGN KEY ("createdBy") REFERENCES public."User"(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY "public"."Brand"
    ADD CONSTRAINT "Brand_createdBy_fkey" FOREIGN KEY ("createdBy") REFERENCES public."User"(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY "public"."Listing"
    ADD CONSTRAINT "Listing_brandId_fkey" FOREIGN KEY ("brandId") REFERENCES public."Brand"(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY "public"."Listing"
    ADD CONSTRAINT "Listing_createdBy_fkey" FOREIGN KEY ("createdBy") REFERENCES public."User"(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ONLY "public"."Session"
    ADD CONSTRAINT "Session_userId_fkey" FOREIGN KEY ("userId") REFERENCES public."User"(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE ONLY "public"."Tag"
    ADD CONSTRAINT "Tag_createdBy_fkey" FOREIGN KEY ("createdBy") REFERENCES public."User"(id) ON UPDATE CASCADE ON DELETE RESTRICT;

REVOKE USAGE ON SCHEMA "public" FROM PUBLIC;

RESET ALL;
