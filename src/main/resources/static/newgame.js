"use strict"


function newGame(){
    var dt = document.getElementById("InputDate").value;
    var opp = document.getElementById("InputOpposition").value;
    var loc = document.getElementById("InputLocation").value;
    var tm = [];
    const url2 = 'http://localhost:8081/gameplan';
    let data = {"gameDate": dt, "opposition": opp, "location": loc, "team": tm};
    axios.post(url2, data)
    .then((response) => {
        addToTable(dt, opp, loc, tm);
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
    		addToTable(response.data);
    		console.log(response);})
    		//redirect back
        .catch(e => {
        console.log(e);
        //refresh with ?error
        });

	}

function addToTable(data) {
    
    let table1 = document.getElementById("plannerTable");
    for (let i =0; i<data.length; i++){
        let row = table1.insertRow(i+1);

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
    
            cell1.innerHTML = data[i].gameDate;
            cell2.innerHTML = data[i].opposition;
            cell3.innerHTML = data[i].location;
            cell4.innerHTML = data[i].team;
    }
    
}



    
    
    
