"use strict"

function createPlayer() {
    let fName = document.getElementById("InputFirstName").value;
    let sName = document.getElementById("InputSurname").value;
    const newPlayerUrl = '/canoe-polo-app/teamPlayers/addPlayer';
    let data = { "firstName": fName, "surname": sName };
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

function populateSelect() {
    const getNewPlayersUrl = '/canoe-polo-app/teamPlayers/getAllPlayers';

    axios.get(getNewPlayersUrl)
        .then((response) => {
            addToScreen(response.data);
            console.log(response);
        })
        //redirect back
        .catch(e => {
            console.log(e);
            //refresh with ?error
        });

}

function addToScreen(item, index) {
    for (let x of item) {
        let option = document.createElement("option");
        let select = document.getElementById("playerList");
        option.innerText = (x.firstName + " " + x.surname);
        option.value = x.id;
        console.log(x.id);
        select.appendChild(option);
    }

}

