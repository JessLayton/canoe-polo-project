"use strict"

function createPlayer(){
    let fName = document.getElementById("InputFirstName").value;
    let sName = document.getElementById("InputSurname").value;
    const url = 'http://localhost:8080/player/player';
    let data = {"firstName": fName, "surname": sName};
    axios.post(url, data
    ).then((response) => {
        console.log(response);
        //redirect back
    }).catch(e => {
        console.log(e);
        //refresh with ?error
    });

}

function populateSelect(){ 
    const url = 'http://localhost:8080/player/player';
     
    
    axios.get(url
    ).then((response) => {
        response.data.forEach(addToScreen);
        
        console.log(response);
        //redirect back
    }).catch(e => {
        console.log(e);
        //refresh with ?error
    });

}

function addToScreen(item, index){
    let option = document.createElement("option");
    let select = document.getElementById("playerList");
    option.innerText = (item.firstName + " " + item.surname);
    select.appendChild(option);
}
  
  