import React from "react";

const UserAdoptReqRow = props => {
  return (
    <tr>
      <td>{props.applicant.id}</td>
      <td>{props.applicant.name}</td>
      <td>{props.applicant.phoneNumber}</td>
      <td>{props.applicant.email}</td>
      <td>{props.applicant.homeStatus}</td>
      <td>
        <a
          href={`creatures/${props.applicant.creature.creatureType.type}/${props.applicant.creature.id}`}
          target="_blank"
        >
          {props.applicant.creature.name}
        </a>
      </td>
      <td>{props.applicant.creature.adoptionStatus}</td>
      <td>
        <form onSubmit={props.editOnSubmit} data-check-id={props.applicant.id}>
          <input className="button success" type="submit" value="Edit" />
        </form>
        <form
          onSubmit={props.deleteOnSubmit}
          data-check-id={props.applicant.id}
        >
          <input className="button alert" type="submit" value="Delete" />
        </form>
      </td>
    </tr>
  );
};

export default UserAdoptReqRow;
