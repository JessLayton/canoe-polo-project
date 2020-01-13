"use strict"

function newGame(){
    let dt = document.getElementById("InputDate").value;
    let opp = document.getElementById("InputOpposition").value;
    let loc = document.getElementById("InputLocation").value;
    let tm = [];
    const url2 = 'http://localhost:8081/gameplan';
    let data = {"gameDate": dt, "opposition": opp, "location": loc, "team": tm};
    axios.post(url2, data)
    .then((response) => {
        console.log(response);})
        //redirect back
    .catch(e => {
        console.log(e);
        //refresh with ?error
    });

}

function populateTable(){ 
    const url2 = 'http://localhost:8081/gameplan';
     
    axios.get(url2)
    	.then((response) => {
    		addToTable();
    		console.log(response);})
    		//redirect back
        .catch(e => {
        console.log(e);
        //refresh with ?error
        });

	}

function addToTable(item, i) {
    let table1 = document.getElementById("plannerTable");
    let row = table1.insertRow(1);

    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var count = table.rows.length;
    for (var i = 0; i < count; i++) {   // ?
        console.log(table1.rows[i]);    // ?

        cell1.innertext = item.gameDate;
        console.log(item.gameDate);
        cell2.innertext = item.opposition;
        cell3.innertext = item.location;
        cell4.innertext = item.team;
    }
}



    
    
    
