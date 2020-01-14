"use strict"

function GamePlanHandler() {
    let plannerTable = document.getElementById("plannerTable");
    let plannerTableRows = plannerTable.getElementsByTagName("tr");
    for (i = 0; i < plannerTableRows.length; i++) {
        let selectedRow = plannerTable.plannerTableRows[i];
        let createClickHandler = 
            function(plannerTableRow) {
        		selectedRow.onclick = createClickHandler(selectedRow);
        }
    }
}
        
window.onload = GamePlanHandler();

/*
function deleteGamePlan() {
  document.getElementById("plannerTable").deleteRow(i);
}

axios.delete('http://localhost:8081/gameplan', {
    params: {
      gameId = futureGameId
    }
  })

  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  }); 


