import React from "react";

const AdminAdoptReqRowDone = props => {
  return (
    <tr>
      <td>{props.applicant.id}</td>
      <td>{props.applicant.name}</td>
      <td>{props.applicant.phoneNumber}</td>
      <td>{props.applicant.email}</td>
      <td>{props.applicant.homeStatus}</td>
      <td>
        <a href={`creatures/${props.applicant.creature.creatureType.type}/${props.applicant.creature.id}`} target="_blank">
          {props.applicant.creature.name}
        </a>
      </td>
      <td>{props.applicant.creature.adoptionStatus}</td>
      <td>{props.applicant.applicationStatus}</td>
    </tr>
  );
};

export default AdminAdoptReqRowDone;
