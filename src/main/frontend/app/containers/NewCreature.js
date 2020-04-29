import React, { useState, useEffect } from "react";
import NewCreatureForm from "../components/NewCreatureForm";
import postData from "../functions/postData";

const NewCreature = props => {
  const [submitted, setSubmitted] = useState(false);

  const apiPath = "/api/v1/surrender/new";

  const addNewCreature = formPayLoad => {
    event.preventDefault();

    console.log(formPayLoad); /// ==============================
    postData(apiPath, formPayLoad, setSubmitted);
  };

  let submittedResponse = "Your request is in process.";
  if (submitted) {
    return <h1>{submittedResponse}</h1>;
  } else {
    return <NewCreatureForm addNewCreature={addNewCreature} />;
  }
};

export default NewCreature;
