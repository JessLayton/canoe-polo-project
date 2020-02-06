"use strict"

let gamePlanArray = axios.get("/canoe-polo-app/gamePlans/getAllGamePlans")
	.then(response => { console.log(response.data); return response.data });



function deleteGame() {
	var confirmDelete = confirm("Are you sure? This will delete all games from the plan");
	if (confirmDelete == true) {
		gamePlanArray.then(data => {
			
			for (let gamePlan of data) {
				axios.delete("/canoe-polo-app/gamePlans/deleteGamePlan/" + gamePlan.gamePlanId)
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
	else {
		alert("Delete cancelled")
	}
		
}
