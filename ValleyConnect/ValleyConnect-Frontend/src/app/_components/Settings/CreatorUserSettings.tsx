"use client";
import {
  Box,
  Button,
  Center,
  Group,
  MultiSelect,
  Paper,
  Stack,
  TextInput,
  Title,
  Text,
  Code,
  ScrollArea,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { IconGripVertical, IconTrash } from "@tabler/icons-react";
import { DragDropContext, Droppable, Draggable } from "@hello-pangea/dnd";

export function SettingsPlatformEditForm() {
  //TODO save edits on this section

  const form = useForm({
    initialValues: {
      platforms: [{ name: "", link: "" }],
    },
  });

  const fields = form.values.platforms.map((_, index) => (
    <Draggable key={index} index={index} draggableId={index.toString()}>
      {(provided) => (
        <Group ref={provided.innerRef} mt="xs" {...provided.draggableProps}>
          <Center {...provided.dragHandleProps}>
            <IconGripVertical size="1.2rem" />
          </Center>
          <TextInput
            placeholder="Twitch"
            {...form.getInputProps(`platforms.${index}.name`)}
          />
          <TextInput
            placeholder="twitch.com"
            {...form.getInputProps(`platforms.${index}.link`)}
          />
          <Center>
            <IconTrash
              style={{ cursor: "pointer" }}
              size="1.2rem"
              onClick={() => {
                form.removeListItem("platforms", index);
              }}
            />
          </Center>
        </Group>
      )}
    </Draggable>
  ));

  return (
    <>
      <Title order={3}>Creator Settings</Title>
      <Paper p={"md"} mt={"sm"} radius={"md"}>
        <Stack>
          <Group gap={"xl"} mb={"md"}>
            <Title order={4}>Your Platforms</Title>
            <MultiSelect
              placeholder="Pick platforms"
              data={["Twitch", "X", "Instagram", "Ticktok", "Kick", "Youtube"]}
            />
          </Group>
          <Group flex={"start"}>
            <Stack mb={"auto"}>
              <Title order={4}>Your Links</Title>
            </Stack>
            <Stack>
              <ScrollArea.Autosize mah={"15rem"} offsetScrollbars>
                <Box>
                  <DragDropContext
                    onDragEnd={({ destination, source }) =>
                      destination?.index !== undefined &&
                      form.reorderListItem("platforms", {
                        from: source.index,
                        to: destination.index,
                      })
                    }
                  >
                    <Droppable droppableId="dnd-list" direction="vertical">
                      {(provided) => (
                        <div
                          {...provided.droppableProps}
                          ref={provided.innerRef}
                        >
                          {fields}
                          {provided.placeholder}
                        </div>
                      )}
                    </Droppable>
                  </DragDropContext>
                </Box>
              </ScrollArea.Autosize>
              <Group ml={"2.2rem"}>
                <Button
                  variant="gradient"
                  gradient={{ from: "violet", to: "pink", deg: 90 }}
                  onClick={() =>
                    form.insertListItem("platforms", { name: "", link: "" })
                  }
                >
                  Add a Platform
                </Button>
                <Button
                  variant="gradient"
                  gradient={{ from: "violet", to: "pink", deg: 20 }}
                  onClick={() =>
                    form.insertListItem("platforms", { name: "", link: "" })
                  }
                >
                  Save
                </Button>
              </Group>
            </Stack>
          </Group>
        </Stack>
      </Paper>
    </>
  );
}
