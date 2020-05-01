import React, { Fragment, useState, useEffect } from "react";
import fetchData from "../functions/fetchData";
import deleteData from "../functions/deleteData";

import TableHeadings from "../components/TableHeadings";
import UserAdoptReqRow from "../components/UserAdoptReqRow";

const UserMain = props => {
  const [applicantsAvail, setApplicantsAvail] = useState([]);

  const apiEndpointGet = "/api/v1/adoption/applications/available";

  const fetchAvailApps = () => fetchData(apiEndpointGet, setApplicantsAvail);
  useEffect(fetchAvailApps, []);

  console.log(applicantsAvail); // =========================

  const editOnSubmit = event => {
    event.preventDefault();
    const matchId = Number(event.target.getAttribute("data-check-id"));
    console.log(matchId); // =========================
  };

  const deleteOnSubmit = event => {
    const matchId = Number(event.target.getAttribute("data-check-id"));
    const appToDelete = applicantsAvail.find(app => app.id === matchId);
    const apiEndpointDelete = `/api/v1/adoption/application/delete/${matchId}`;
    deleteData(apiEndpointDelete, appToDelete);
  };

  const mapAvailApps = applicantsAvail.map(app => (
    <UserAdoptReqRow
      key={app.id}
      applicant={app}
      editOnSubmit={editOnSubmit}
      deleteOnSubmit={deleteOnSubmit}
    />
  ));

  return (
    <Fragment>
      <h2>User Portal</h2>
      <div>
        <h3>Pending Adoption Requests</h3>
        <table className="hover">
          <TableHeadings lastColumnName={"Updates"} />
          <tbody>{mapAvailApps}</tbody>
        </table>
      </div>
    </Fragment>
  );
};

export default UserMain;
