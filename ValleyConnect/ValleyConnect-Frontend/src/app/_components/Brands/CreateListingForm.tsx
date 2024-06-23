"use client";

import {
  Button,
  Group,
  MultiSelect,
  Paper,
  TextInput,
  Textarea,
  Text,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import React from "react";
import { JsxElement } from "typescript";
import { api } from "~/trpc/react";

export function CreateListingForm() {
  const form = useForm({
    initialValues: {
      name: "",
      description: "",
      requirements: "",
      platforms: [],
    },
  });

  const createListing = api.listings.createListing.useMutation({
    onSuccess: () => console.log("test"),
  });
  // add a toast to appear and clear the form on submit
  return (
    <Paper p={"sm"}>
      <form
        onSubmit={form.onSubmit((values) => console.log(values))}
        className="mx-3"
      >
        <TextInput
          withAsterisk
          label="Name"
          placeholder="What should your listing be called?"
          {...form.getInputProps("name")}
        />
        <Textarea
          mt={"sm"}
          withAsterisk
          label="Description"
          placeholder="Give it a description"
          autosize
          minRows={2}
          maxRows={24}
          {...form.getInputProps("description")}
        />
        <Textarea
          mt={"sm"}
          withAsterisk
          label="Creator Requirements"
          placeholder="What are the sponsorship requirements?"
          autosize
          minRows={2}
          maxRows={24}
          {...form.getInputProps("requirements")}
        />
        <MultiSelect
          mt={"sm"}
          label="Available Platforms"
          withAsterisk
          placeholder="Pick platforms"
          data={["Twitch", "X", "Instagram", "Ticktok", "Kick", "Youtube"]}
          {...form.getInputProps("platforms")}
        />

        <Group justify="flex-end" mt="md">
          <Button
            type="submit"
            onClick={async () =>
              createListing.mutate({
                name: form.values.name,
                description: form.values.description,
                requirements: form.values.requirements,
                platforms: form.values.platforms.toString(),
                brandId: "1234",
              })
            }
          >
            Submit
          </Button>
        </Group>
      </form>
    </Paper>
  );
}
