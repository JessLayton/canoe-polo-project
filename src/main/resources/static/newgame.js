"use strict"

function newGame(){
    let dt = document.getElementById("InputDate").value;
    let opp = document.getElementById("InputOpposition").value;
    let loc = document.getElementById("InputLocation").value;
    let tm = [];
    const url2 = 'http://localhost:8080/gameplan';
    let gameData = {"gameDate": dt, "opposition": opp, "location": loc, "team": tm};
    axios.post(url2, gameData)
    .then((response) => {
        console.log(response);})
        //redirect back
    .catch(e => {
        console.log(e);
        //refresh with ?error
    });

}

function populateTable(){ 
    const url2 = 'http://localhost:8080/gameplan';
     
    axios.get(url2)
    	.then((response) => {
    		addToTable(response.gameData);
    		console.log(response);})
    		//redirect back
        .catch(e => {
        console.log(e);
        //refresh with ?error
        });

	}

function addToTable() {
    let table1 = document.getElementById("plannerTable");
    let row = table1.insertRow(1);
        
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    cell1.innerHTML = (value.gameDate);
    cell2.innerHTML = (value.opposition);
    cell3.innerHTML = (value.location);
    cell4.innerHTML = (value.team);
}

    
    
    
