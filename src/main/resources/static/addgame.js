"use strict"

let playerRoster = document.getElementById("playerList").getElementsByTagName("option");

function createTeam(playerRoster) {
	
	let result = [];
	let players = playerRoster;
	for (let i=0; i < players.length; i++) {
	    let player = players[i];
	    
	    if (player.selected) {
	    	result = playerRoster.options[playerList.selectedIndex].value;
            results.push(result);
            console.log(results);
	    	}
        }
    }
        
      



function createGame(){
	let result = createTeam(playerRoster);
    let dt = document.getElementById("InputDate").value;
    console.log(dt);
    let opp = document.getElementById("InputOpposition").value;
    let loc = document.getElementById("InputLocation").value;
    let tm = result;
    let data = {"gameDate": dt, "opposition": opp, "location": loc, "team": tm};
    const url = 'http://localhost:8080/gameplan';
    axios.post(url, data
    ).then((response) => {
        console.log(response);
        //redirect back
    }).catch(e => {
        console.log(e);
        //refresh with ?error
    });

    let url2 = 'http://localhost:8080/gameplan/{gameId}';
    axios.update(url2, finalTeam
    ).then((response) => {
    console.log(response);
    }).catch(e => {
    console.log(e);
    });
     
}

function populateTable(){ 
    const url = 'http://localhost:8080/gameplan';
 
    axios.get(url
        ).then((response) => {
            response.data.forEach(addGame);
            
            console.log(response);
            //redirect back
        }).catch(e => {
            console.log(e);
            //refresh with ?error
        });
    
    }

    
function addGame() {
	let table1 = document.getElementById('plannerTable'),
    	row = table1.insertRow(table1.rows.length),
        i;
    for (i = 0; i < table1.rows[0].cells.length; i++) {
        createCell(row.insertCell(item.gameDate));
        createCell(row.insertCell(item.opposition));
        createCell(row.insertCell(item.location));
        createCell(row.insertCell(item.result));
    }
 }
    

    
    