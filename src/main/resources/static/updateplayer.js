"use strict"

let playerToUpdate = document.getElementById("updatePlayerList");



//const playerOptions = axios.get("http://localhost:8081/teamPlayers/getAllPlayers")
//    .then(response => { console.log(response.data); return response.data });

function updatePlayer() {
	
	let updatedFirstName = document.getElementById("InputUpdatedFirstName").value;
	let updatedSurname = document.getElementById("InputUpdatedSurname").value;
	let data = { "firstName": updatedFirstName, "surname": updatedSurname };
    console.log(data);
    
    for (let teamPlayer of playerToUpdate) {
    	console.log(teamPlayer.value);

    			if (teamPlayer.selected) {
			
			axios.put("http://localhost:8081/teamPlayers/updatePlayer/" + teamPlayer.value, data)
				.then(function (response) {
					console.log(response);
				});
		}
    }
}
   
