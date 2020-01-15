"use strict"

let gamePlanArray = axios.get("http://localhost:8081/gamePlans/getAllGamePlans")
	.then(response => { console.log(response.data); return response.data });



function deleteGame() {

	gamePlanArray.then(data => {
		
		for (let gamePlan of data) {
			axios.delete("http://localhost:8081/gamePlans/deleteGamePlan/" + gamePlan.futureGameId)
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
