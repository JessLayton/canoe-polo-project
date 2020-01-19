"use strict"


function newGame() {
	let newGameForm = document.getElementById("newGameForm");
    let gameInput = document.getElementById("InputDate").value;
    let gameDate = gameInput.split("/").reverse().join("-")
    let opposition = document.getElementById("InputOpposition").value;
    let location = document.getElementById("InputLocation").value;
    let team = createTeam();
    let newGameUrl = '/canoe-polo-app/gamePlans/addGamePlan';
    let data = { "gameDate": gameDate, "opposition": opposition, "location": location, "team": team };
    if (team.length == 5) {
    axios.post(newGameUrl, data, {"Content-Type": "application/json"})
        .then((response) => {
            console.log(response.data.gamePlanId);                        	
        })
        .catch(error => {
        	alert("Game added");
            console.log(error);
        });
    }
    else if (team.length > 5) {
    	alert("Too many players added!");
    }
    else {
    	alert("Too few players added!");
    }
}


function populateTable() {
    
    axios.get('/canoe-polo-app/gamePlans/getAllGamePlans')
        .then((response) => {
            addToTable(response.data);
            console.log("get: " + response.data);
            console.log("gettext: " + response.text);
            console.log(response);
        })

        .catch(error => {
            console.log(error);

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

        const {  gameDate = "N/A", opposition = "N/A", location = "N/A", team = ["N/A"] } = game;
        gameDateCell.innerHTML = gameDate;
        oppositionCell.innerHTML = opposition;
        locationCell.innerHTML = location;
        console.log(team);
        let resultTeam = "";
        for (let i=0; i<team.length; i++) {
	        if (team[i]) {
	        	if(i!=0){
	        		resultTeam += ", ";
	        	}
	        	resultTeam += team[i].firstName + " " + team[i].surname;
	        }
        }
        teamCell.innerHTML = resultTeam;
    });

}

function createTeam() {
    let selectedPlayerIds = [];
    let playerSelectionList = document.getElementById("playerList");
    console.log(playerSelectionList);

    for (let selectedPlayer of playerSelectionList.options) {
        if (selectedPlayer.selected) {
            console.log("selected player ID:" + selectedPlayer.value);
            selectedPlayerIds.push({"id": selectedPlayer.value}); 
        }
    }
    console.log("selected player ids: " + selectedPlayerIds);
    return selectedPlayerIds;
}


