"use strict"

function createPlayer(){
    let fName = document.getElementById("InputFirstName").value;
    let sName = document.getElementById("InputSurname").value;
    const url = 'http://localhost:8081/player/player';
    let data = {"firstName": fName, "surname": sName};
    axios.post(url, data)
    .then((response) => {
    	window.alert("Player Added");
        console.log(response);})
        
    .catch(e => {
    	window.alert("Player Not Added");
        console.log(e);
    });

}

function populateSelect(){ 
    const url = 'http://localhost:8081/player/player';
         
    axios.get(url)
    	.then((response) => {
    		addToScreen(response.data);
    		console.log(response);})
    		//redirect back
        .catch(e => {
        console.log(e);
        //refresh with ?error
        });

	}

function addToScreen(item, index){
	for (let x of item) {
		let option = document.createElement("option");
		    let select = document.getElementById("playerList");
		    option.innerText = (x.firstName + " " + x.surname);
		    option.value = x.id;
		    console.log(x.id);
		    select.appendChild(option);
	}
    
}
  
  