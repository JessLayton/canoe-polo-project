let gamePlayerArray = axios.get("/mucc-canoe-polo/teamPlayers/getAllPlayers")
	.then(response => { console.log(response.data); return response.data });



function deletePlayer() {
	let playerSelectionList = document.getElementById("playerList");

	gamePlayerArray.then(data => {
		
		for (let teamPlayer of playerSelectionList.options) {
			if (teamPlayer.selected) {
				axios.delete("/mucc-canoe-polo/teamPlayers/deletePlayer/" + teamPlayer.value)
					.then(function (response) {
						console.log(response);
						location.reload();
					})
					.catch(function (error) {
						console.log(error);
						alert("Cannot delete player used in gameplan")
					});
			}
		}
	});
}

