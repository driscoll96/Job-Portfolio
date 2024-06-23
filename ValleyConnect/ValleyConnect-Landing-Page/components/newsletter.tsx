"use client";

import { Button, Container, Group, MultiSelect, Title } from "@mantine/core";
import { type SetStateAction, useState } from "react";
import classes from "./ui/newsletter.module.css";
const INIT = "INIT";
const SUBMITTING = "SUBMITTING";
const ERROR = "ERROR";
const SUCCESS = "SUCCESS";
const formStates = [INIT, SUBMITTING, ERROR, SUCCESS] as const;
const formStyles = {
  id: "clr4bv3cp00itoi3l8ll026k1",
  name: "Default",
  formStyle: "buttonBelow",
  placeholderText: "First Name",
  formFont: "Inter",
  formFontColor: "#000000",
  formFontSizePx: 14,
  buttonText: "Submit",
  buttonFont: "Inter",
  buttonFontColor: "#ffffff",
  buttonColor: "#0D9488",
  buttonFontSizePx: 14,
  successMessage: "Thanks! We'll be in touch!",
  successFont: "Inter",
  successFontColor: "#FFFFFF",
  successFontSizePx: 14,
  userGroup: "",
};
const domain = "app.loops.so";

export default function SignUpFormReact() {
  const TWITCH = "Twitch";
  const YOUTUBE = "Youtube";
  const KICK = "Kick";
  const TIKTOK = "Tiktok";
  const INSTAGRAM = "Instagram";
  const TWITTER = "Twitter";
  const DISCORD = "Discord";

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [twitch, setTwitch] = useState("");
  const [twitchFollowers, setTwitchFollowers] = useState<number>();
  const [instagram, setInstagram] = useState("");
  const [instagramFollowers, setInstagramFollowers] = useState<number>();
  const [discord, setDiscord] = useState("");
  const [discordMembers, setDiscordMembers] = useState<number>();
  const [youtube, setYoutube] = useState("");
  const [youtubeSubscribers, setYoutubeSubscribers] = useState<number>();
  const [kick, setKick] = useState("");
  const [kickFollowers, setKickFollowers] = useState<number>();
  const [tiktok, setTiktok] = useState("");
  const [tiktokFollowers, setTiktokFollowers] = useState<number>();
  const [twitter, setTwitter] = useState("");
  const [twitterFollowers, setTwitterFollowers] = useState<number>();
  const [games, setGames] = useState("");
  const [referral, setReferral] = useState("");
  const [website, setWebsite] = useState("");
  const [product, setProduct] = useState("");
  const [budget, setBudget] = useState("");
  const [targetAudience, setTargetAudience] = useState("");

  const [formState, setFormState] = useState<(typeof formStates)[number]>(INIT);

  const [selectedPlatforms, setSelectedPlatforms] = useState<string[]>([]);

  const [selectedForm, setSelectedForm] = useState("");

  const [errorMessage, setErrorMessage] = useState("");

  const resetForm = () => {
    setEmail("");
    setFormState(INIT);
    setErrorMessage("");
  };

  /**
   * Rate limit the number of submissions allowed
   * @returns {boolean} true if the form has been successfully submitted in the past minute
   */
  const hasRecentSubmission = () => {
    const time = new Date();
    const timestamp = time.valueOf();
    const previousTimestamp = localStorage.getItem("loops-form-timestamp");

    // Indicate if the last sign up was less than a minute ago
    if (
      previousTimestamp &&
      Number(previousTimestamp) + 60 * 1000 > timestamp
    ) {
      setFormState(ERROR);
      setErrorMessage("Too many signups, please try again in a little while");
      return true;
    }

    localStorage.setItem("loops-form-timestamp", timestamp.toString());
    return false;
  };

  const inputButton = (
    name: string,
    placeholder: string,
    value: any,
    setState: (value: SetStateAction<any>) => void,
    isNumber: boolean,
    required: boolean
  ) => {
    return (
      <input
        type="text"
        name={name}
        placeholder={placeholder}
        value={value}
        onChange={(e) => setState(e.target.value)}
        required={required}
        style={{
          color: formStyles.formFontColor,
          fontFamily: `'${formStyles.formFont}', sans-serif`,
          fontSize: `${formStyles.formFontSizePx}px`,
          margin: isInline ? "0px 10px 0px 0px" : "0px 0px 10px",
          width: "100%",

          minWidth: "100px",
          background: "#FFFFFF",
          border: "1px solid #D1D5DB",
          boxSizing: "border-box",
          boxShadow: "rgba(0, 0, 0, 0.05) 0px 1px 2px",
          borderRadius: "6px",
          padding: "8px 12px",
        }}
      />
    );
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    // Prevent the default form submission
    event.preventDefault();

    // boundary conditions for submission
    if (formState !== INIT) return;
    if (!isValidEmail(email)) {
      setFormState(ERROR);
      setErrorMessage("Please enter a valid email");
      return;
    }
    if (hasRecentSubmission()) return;
    setFormState(SUBMITTING);

    // build body
    const formBody = `userGroup=${encodeURIComponent(
      selectedForm
    )}&firstName=${encodeURIComponent(firstName)}&lastName=${encodeURIComponent(
      lastName
    )}&email=${encodeURIComponent(email)}&twitch=${encodeURIComponent(
      twitch
    )}&twitchFollowers=${encodeURIComponent(
      twitchFollowers ?? 0
    )}&youtube=${encodeURIComponent(
      youtube
    )}&youtubeSubscribers=${encodeURIComponent(
      youtubeSubscribers ?? 0
    )}&kick=${encodeURIComponent(kick)}&kickFollowers=${encodeURIComponent(
      kickFollowers ?? 0
    )}&tikTok=${encodeURIComponent(
      tiktok
    )}&tikTokFollowers=${encodeURIComponent(
      tiktokFollowers ?? 0
    )}&instagram=${encodeURIComponent(
      instagram
    )}&instagramFollowers=${encodeURIComponent(
      instagramFollowers ?? 0
    )}&twitter=${encodeURIComponent(
      twitter
    )}&twitterFollowers=${encodeURIComponent(
      twitterFollowers ?? 0
    )}&discord=${encodeURIComponent(
      discord
    )}&discordMembers=${encodeURIComponent(
      discordMembers ?? 0
    )}&games=${encodeURIComponent(games)}&referral=${encodeURIComponent(
      referral
    )}&brandWebsite=${encodeURIComponent(
      website
    )}&brandProduct=${encodeURIComponent(
      product
    )}&brandBudget=${encodeURIComponent(
      budget
    )}&brandTargetAudience=${encodeURIComponent(targetAudience)}`;

    // API request to add user to newsletter
    fetch(`https://${domain}/api/newsletter-form/${formStyles.id}`, {
      method: "POST",
      body: formBody,
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
    })
      .then((res: any) => [res.ok, res.json(), res])
      .then(([ok, dataPromise, res]) => {
        if (ok) {
          resetForm();
          setFormState(SUCCESS);
        } else {
          dataPromise.then((data: any) => {
            setFormState(ERROR);
            // eslint-disable-next-line @typescript-eslint/no-unsafe-argument
            setErrorMessage(data.message || res.statusText);
            localStorage.setItem("loops-form-timestamp", "");
          });
        }
      })
      .catch((error) => {
        setFormState(ERROR);
        // check for cloudflare error
        if (error.message === "Failed to fetch") {
          setErrorMessage(
            "Too many signups, please try again in a little while"
          );
        } else if (error.message) {
          // eslint-disable-next-line @typescript-eslint/no-unsafe-argument
          setErrorMessage(error.message);
        }
        localStorage.setItem("loops-form-timestamp", "");
      });
  };

  const isInline = formStyles.formStyle === "inline";

  switch (formState) {
    case SUCCESS:
      return (
        <div
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            width: "100%",
          }}
        >
          <p
            style={{
              fontFamily: `'${formStyles.successFont}', sans-serif`,
              color: formStyles.successFontColor,
              fontSize: `${formStyles.successFontSizePx}px`,
            }}
          >
            {formStyles.successMessage}
          </p>
        </div>
      );
    case ERROR:
      return (
        <>
          <SignUpFormError />
          <BackButton />
        </>
      );
    default:
      return (
        <>
          <Container mb={"md"}>
            <Group justify="center">
              <Button
                variant="gradient"
                gradient={{ from: "grape", to: "red", deg: 90 }}
                size="lg"
                onClick={() => setSelectedForm("creator")}
              >
                For Creators
              </Button>
              <Button
                variant="gradient"
                gradient={{ from: "indigo", to: "grape", deg: 90 }}
                size="lg"
                onClick={() => setSelectedForm("brand")}
              >
                For Brands
              </Button>
            </Group>
          </Container>

          {selectedForm.length > 0 ? (
            <form
              onSubmit={handleSubmit}
              style={{
                display: "flex",
                flexDirection: isInline ? "row" : "column",
                alignItems: "center",
                justifyContent: "center",
                width: "100%",
              }}
            >
              <Title order={2}> Contact Information </Title>
              <div className="grid gap-4 grid-cols-2">
                {inputButton(
                  "firstName",
                  "First Name",
                  firstName,
                  setFirstName,
                  false,
                  true
                )}
                {inputButton(
                  "lastName",
                  "Last Name",
                  lastName,
                  setLastName,
                  false,
                  true
                )}
                <div className="col-span-2">
                  {inputButton("email", "Email", email, setEmail, false, true)}
                </div>
              </div>

              {selectedForm === "brand" ? (
                <>
                  <Title order={2}>Brand Information</Title>
                  <div className="grid gap-4 grid-cols-2">
                    {inputButton(
                      "webSite",
                      "Website",
                      website,
                      setWebsite,
                      false,
                      true
                    )}
                    {inputButton(
                      "product",
                      "Product",
                      product,
                      setProduct,
                      false,
                      true
                    )}
                    {inputButton(
                      "budget",
                      "Budget",
                      budget,
                      setBudget,
                      false,
                      false
                    )}
                    {inputButton(
                      "targetAudience",
                      "Target Audience",
                      targetAudience,
                      setTargetAudience,
                      false,
                      false
                    )}
                  </div>
                </>
              ) : (
                <></>
              )}

              {selectedForm === "creator" ? (
                <>
                  <Title order={2}>Platforms</Title>
                  <Container mb={"md"}>
                    <MultiSelect
                      classNames={{
                        input: classes.input,
                        pill: classes.pill,
                        option: classes.option,
                      }}
                      placeholder="Your Platforms"
                      data={[
                        TWITCH,
                        YOUTUBE,
                        KICK,
                        TIKTOK,
                        INSTAGRAM,
                        TWITTER,
                        DISCORD,
                      ]}
                      value={selectedPlatforms}
                      onChange={setSelectedPlatforms}
                    />
                  </Container>
                  <div className="grid gap-4 grid-cols-2">
                    {selectedPlatforms.find((val) => val === TWITCH) ? (
                      <>
                        {inputButton(
                          "twitchName",
                          TWITCH,
                          twitch,
                          setTwitch,
                          false,
                          false
                        )}
                        {inputButton(
                          "twitchFollowers",
                          "Twitch Followers",
                          twitchFollowers,
                          setTwitchFollowers,
                          true,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}

                    {selectedPlatforms.find((val) => val === YOUTUBE) ? (
                      <>
                        {inputButton(
                          "youtube",
                          YOUTUBE,
                          youtube,
                          setYoutube,
                          false,
                          false
                        )}
                        {inputButton(
                          "youtubeFollowers",
                          "Youtube Subscribers",
                          youtubeSubscribers,
                          setYoutubeSubscribers,
                          true,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}

                    {selectedPlatforms.find((val) => val === KICK) ? (
                      <>
                        {inputButton("kick", KICK, kick, setKick, false, false)}
                        {inputButton(
                          "kickFollowers",
                          "Kick Followers",
                          kickFollowers,
                          setKickFollowers,
                          true,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}
                    {selectedPlatforms.find((val) => val === TIKTOK) ? (
                      <>
                        {inputButton(
                          "tiktok",
                          TIKTOK,
                          tiktok,
                          setTiktok,
                          false,
                          false
                        )}
                        {inputButton(
                          "tiktokFollowers",
                          "TikTok Followers",
                          tiktokFollowers,
                          setTiktokFollowers,
                          true,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}
                    {selectedPlatforms.find((val) => val === INSTAGRAM) ? (
                      <>
                        {inputButton(
                          "instagram",
                          INSTAGRAM,
                          instagram,
                          setInstagram,
                          false,
                          false
                        )}
                        {inputButton(
                          "instagramFollowers",
                          "Instagram Followers",
                          instagramFollowers,
                          setInstagramFollowers,
                          true,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}
                    {selectedPlatforms.find((val) => val === TWITTER) ? (
                      <>
                        {inputButton(
                          "twitter",
                          TWITTER,
                          twitter,
                          setTwitter,
                          false,
                          false
                        )}
                        {inputButton(
                          "twitterFollowers",
                          "Twitter Followers",
                          twitterFollowers,
                          setTwitterFollowers,
                          false,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}
                    {selectedPlatforms.find((val) => val === DISCORD) ? (
                      <>
                        {inputButton(
                          "discord",
                          DISCORD,
                          discord,
                          setDiscord,
                          false,
                          false
                        )}
                        {inputButton(
                          "discordMembers",
                          "Discord Members",
                          discordMembers,
                          setDiscordMembers,
                          true,
                          false
                        )}
                      </>
                    ) : (
                      <></>
                    )}
                  </div>{" "}
                </>
              ) : (
                <></>
              )}
              <Title order={2}>Additional Information</Title>
              <div className="grid gap-4 grid-cols-2">
                <div className="col-span-2">
                  {selectedForm === "creator" ? (
                    <>
                      {inputButton(
                        "games",
                        "Games Played ex. fortnite, age of empires, call of duty",
                        games,
                        setGames,
                        false,
                        false
                      )}
                    </>
                  ) : (
                    <></>
                  )}
                  {inputButton(
                    "referral",
                    "Who referred you? (email)",
                    referral,
                    setReferral,
                    false,
                    false
                  )}
                </div>
              </div>
              <Container w={"15rem"} mt={"md"}>
                <SignUpFormButton />
              </Container>
            </form>
          ) : (
            <> </>
          )}
        </>
      );
  }

  function SignUpFormError() {
    return (
      <div
        style={{
          alignItems: "center",
          justifyContent: "center",
          width: "100%",
        }}
      >
        <p
          style={{
            fontFamily: "Inter, sans-serif",
            color: "rgb(185, 28, 28)",
            fontSize: "14px",
          }}
        >
          {errorMessage || "Oops! Something went wrong, please try again"}
        </p>
      </div>
    );
  }

  function BackButton() {
    const [isHovered, setIsHovered] = useState(false);

    return (
      <button
        style={{
          color: "#6b7280",
          font: "14px, Inter, sans-serif",
          margin: "10px auto",
          textAlign: "center",
          background: "transparent",
          border: "none",
          cursor: "pointer",
          textDecoration: isHovered ? "underline" : "none",
        }}
        onMouseOut={() => setIsHovered(false)}
        onMouseOver={() => setIsHovered(true)}
        onClick={resetForm}
      >
        &larr; Back
      </button>
    );
  }

  function SignUpFormButton({ props }: any) {
    return (
      <button
        type="submit"
        className="bg-indigo-500 hover:bg-indigo-600"
        style={{
          fontSize: `${formStyles.buttonFontSizePx}px`,
          color: formStyles.buttonFontColor,
          fontFamily: `'${formStyles.buttonFont}', sans-serif`,
          width: isInline ? "min-content" : "100%",
          maxWidth: "300px",
          whiteSpace: isInline ? "nowrap" : "normal",
          height: "38px",
          alignItems: "center",
          justifyContent: "center",
          flexDirection: "row",
          padding: "9px 17px",
          boxShadow: "0px 1px 2px rgba(0, 0, 0, 0.05)",
          borderRadius: "6px",
          textAlign: "center",
          fontStyle: "normal",
          fontWeight: 500,
          lineHeight: "20px",
          border: "none",
          cursor: "pointer",
        }}
      >
        {formState === SUBMITTING ? "Please wait..." : formStyles.buttonText}
      </button>
    );
  }
}

function isValidEmail(email: any) {
  // eslint-disable-next-line @typescript-eslint/no-unsafe-argument
  return /.+@.+/.test(email);
}
