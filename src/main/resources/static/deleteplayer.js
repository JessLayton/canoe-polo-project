let gamePlayerArray = axios.get("http://localhost:8081/teamPlayers/getAllPlayers")
	.then(response => { console.log(response.data); return response.data });



function deletePlayer() {
	let playerSelectionList = document.getElementById("playerList");

	gamePlayerArray.then(data => {
		
		for (let teamPlayer of playerSelectionList.options) {
			if (teamPlayer.selected) {
				axios.delete("http://localhost:8081/teamPlayers/deletePlayer/" + teamPlayer.value)
					.then(function (response) {
						console.log(response);
						location.reload();
					})
					.catch(function (error) {
						console.log(error);
					});
			}
		}
	});
}

