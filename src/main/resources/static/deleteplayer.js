let gamePlayerArray = axios.get("http://localhost:8081/player/player")
	.then(response => { console.log(response.data); return response.data });



function deletePlayer() {
	let playerSelectionList = document.getElementById("playerList");

	gamePlayerArray.then(data => {
		
		for (let teamPlayer of playerSelectionList.options) {
			console.log(playerList.options);
			console.log(teamPlayer.value);
			if (teamPlayer.selected) {
				axios.delete("http://localhost:8081/player/player/" + teamPlayer.value)
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

