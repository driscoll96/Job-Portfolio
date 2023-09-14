import React from "react";

export default function AuthPageTextInput({
  inputLabel,
  inputValue,
  handleTextInput,
}) {
  const tagNameLabel = inputLabel.replaceAll("_", "");
  const displayLabel = inputLabel.replaceAll("_", " ");

  //Alters Display Text: First Letter Uppercase, add colon and space at end.
  const formatDisplayText = () => {
    const upperCase = [...displayLabel];
    upperCase[0] = upperCase[0].toUpperCase();
    const nameString = [...upperCase, ": "].join("");
    return nameString;
  };

  //Change autoComplete for confirm fiel
  const changeAutoComplete = () => {
    if (inputLabel === "confirm_Email" || inputLabel === "confirm_Password") {
      return "no";
    } else {
      return "on";
    }
  };

  return (
    <>
      <label autoCapitalize="true" htmlFor={inputLabel}>
        {formatDisplayText()}
        <input
          autoComplete={changeAutoComplete()}
          aria-required="true"
          aria-label={inputLabel}
          type="text"
          name={tagNameLabel}
          value={inputValue}
          onChange={handleTextInput}
        ></input>
      </label>
      <br />
    </>
  );
}