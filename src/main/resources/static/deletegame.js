"use strict"

let gamePlanArray = axios.get("http://localhost:8081/gameplan")
	.then(response => { console.log(response.data); return response.data });



function deleteGame() {

	gamePlanArray.then(data => {
		const url = 'http://localhost:8081/gameplan/'
		for (let gamePlan of data) {
			axios.delete("http://localhost:8081/gameplan/" + gamePlan.futureGameId)
				.then(function (response) {
					console.log(response);
					location.reload();
				})
				.catch(function (error) {
					console.log(error);
				});
		}
	});
}
