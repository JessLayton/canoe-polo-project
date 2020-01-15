"use strict"


function newGame() {
	let newGameForm = document.getElementById("newGameForm");
    let gameInput = document.getElementById("InputDate").value;
    let gameDate = gameInput.split("/").reverse().join("-")
    let opposition = document.getElementById("InputOpposition").value;
    let location = document.getElementById("InputLocation").value;
    let team = createTeam();
    let newGameUrl = 'http://localhost:8081/gamePlans/addGamePlan';
    let data = { "gameDate": gameDate, "opposition": opposition, "location": location, "team": team };
    
    axios.post(newGameUrl, data)
        .then((response) => {
            console.log(response.data.gamePlanId);
            addTeamToPlan(team, response.data.gamePlanId);
                        	
        })
        .catch(e => {
            console.log(e);
        });
    }


function populateTable() {
    let populateTableUrl = 'http://localhost:8081/gamePlans/getAllGamePlans';

    axios.get(populateTableUrl)
        .then((response) => {
            addToTable(response.data);
            console.log("get: " + response.data);
            console.log("gettext: " + response.text);
            console.log(response);
        })

        .catch(e => {
            console.log(e);

        });

}

function addToTable(data) {

    let plannerTable = document.getElementById("plannerTable");
    let i = 1;
    data.forEach((game, i) => {
        let gameRow = plannerTable.insertRow(i + 1);

        let gameDateCell = gameRow.insertCell(0);
        let oppositionCell = gameRow.insertCell(1);
        let locationCell = gameRow.insertCell(2);
        let teamCell = gameRow.insertCell(3);

        const {  gameDate = "N/A", opposition = "N/A", location = "N/A", team } = game;
        gameDateCell.innerHTML = gameDate;
        oppositionCell.innerHTML = opposition;
        locationCell.innerHTML = location;
        if (team[0]) {
        	teamCell.innerHTML = team[0].firstName + " " + team[0].surname;
        }
    });

}

function createTeam() {
    let selectedPlayerIds = [];
    let playerSelectionList = document.getElementById("playerList");
    console.log(playerSelectionList);

    for (let selectedPlayer of playerSelectionList.options) {
        if (selectedPlayer.selected) {
            console.log("selected player:" + selectedPlayer.text);
            console.log("selected player ID:" + selectedPlayer.value)// ?
            selectedPlayerIds.push(selectedPlayer.value); // ??
        }
    }
    console.log("selected player ids: " + selectedPlayerIds);
    return selectedPlayerIds;
}

function addTeamToPlan(team, gameId) {
    let addTeamToPlanUrl = `http://localhost:8081/gamePlans/updateGamePlan/${gameId}`;
    axios.put(addTeamToPlanUrl, team)
        .then((response) => {
            console.log(response);
        })
        .catch(e => {
            console.log(e);
        });

}


function validateAddGameForm() {
    let oppositionInput = document.forms["addGameForm"]["InputOpposition"].value;
    let locationInput = document.forms["addGameForm"]["InputOpposition"].value;
    
    
}
