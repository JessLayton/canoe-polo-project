"use strict"


function newGame(){
    let gameDate = document.getElementById("InputDate").value;
    let opponent = document.getElementById("InputOpposition").value;
    let location = document.getElementById("InputLocation").value;
    let team = createTeam();
    let newGameUrl = 'http://localhost:8081/gameplan';
    let data = {"gameDate": gameDate, "opposition": opponent, "location": location, "team": []};
    axios.post(newGameUrl, data)
    .then((response) => {
        // addToTable(dt, opp, loc, tm);
        console.log("this is the post response innit m8: "+response.data.futureGameId);
        addTeamToPlan(team, response.data.futureGameId);
    })
        //redirect back
    .catch(e => {
        console.log(e);
        //refresh with ?error
    });

}

function populateTable(){ 
    let populateTableUrl = 'http://localhost:8081/gameplan';
     
    axios.get(populateTableUrl)
    	.then((response) => {
    		addToTable(response.data);
            console.log(response);
        })
    		
        .catch(e => {
        console.log(e);
        
        });

	}

function addToTable(data) {
    
    let plannerTable = document.getElementById("plannerTable");
    for (let i =0; i<data.length; i++){
        let gameRow = plannerTable.insertRow(i+1);

        let gameDateCell = gameRow.insertCell(0);
        let oppositionCell = gameRow.insertCell(1);
        let locationCell = gameRow.insertCell(2);
        let teamCell = gameRow.insertCell(3);
    
        gameDateCell.innerHTML = data[i].gameDate;
        oppositionCell.innerHTML = data[i].opposition;
        locationCell.innerHTML = data[i].location;
        teamCell.innerHTML = data[i].team;
    }
    
}

function createTeam() {
    let selectedPlayerIds = [];
	let playerSelectionList = document.getElementById("playerList");
	// let playerRoster = playerSelect.getElementsByTagname("option").values;
     console.log(playerSelectionList);
    

	
    for (let selectedPlayer of playerSelectionList.options) {
        if (selectedPlayer.selected) {
            console.log(selectedPlayer);
            selectedPlayerIds.push(selectedPlayer.value);
        }
    }
    console.log(selectedPlayerIds);
    return selectedPlayerIds;
    // for (let i=0; i < playerRoster.length; i++) {
	// let player = selectablePlayers[i];   
			
	// if (player.selected) {
	   	
    //     playerIds.push(result);
    //     console.log(playerIds);
    //     }
    // }
}

function addTeamToPlan(team, gameId) {
    let addTeamToPlanUrl = `http://localhost:8081/gameplan/${gameId}`;
    axios.put(addTeamToPlanUrl, team)
    .then((response) => {
        //create();
        console.log("this is the put response innit m8" + response);
    })    
    .catch(e => {
        console.log(e);
        
    });

}