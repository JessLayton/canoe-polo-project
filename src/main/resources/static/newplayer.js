"use strict"

function createPlayer() {
    let firstName = document.getElementById("InputFirstName").value;
    let surname = document.getElementById("InputSurname").value;
    const newPlayerUrl = 'http://localhost:8081/teamPlayers/addPlayer';
    let data = { "firstName": firstName, "surname": surname };
    axios.post(newPlayerUrl, data)
        .then((response) => {
            window.alert("Player Added");
            console.log(response);
        })

        .catch(error => {
            window.alert("Player Not Added");
            console.log(error);
        });

}

function populateSelect(elementToPopulate) {
    const getNewPlayersUrl = 'http://localhost:8081/teamPlayers/getAllPlayers';
    

    axios.get(getNewPlayersUrl)
        .then((response) => {
            addToScreen(response.data, elementToPopulate);
            console.log(response);
        })
        //redirect back
        .catch(e => {
            console.log(e);
            //refresh with ?error
        });

}

function addToScreen(item, elementToPopulate) {
    for (let x of item) {
    	
        let option = document.createElement("option");
        let select = document.getElementById(elementToPopulate);
        option.innerText = (x.firstName + " " + x.surname);
        option.value = x.id;
        option.id = x.id;
        console.log(x.id);
        select.appendChild(option);
    }

}

