/** Web Socket Implementation for BioT Project */
'use strict'


var stompClient = null;

connect();

function connect(event){
    var sock = new SockJS("/socket");
    stompClient = Stomp.over(sock);

    stompClient.connect({}, onConnect, onError);
}

function onConnect(){
    stompClient.subscribe("/topic/webClient", onMessageRecieved);
    stompClient.send("/app/register",
        {},
        JSON.stringify({id: uid, type: "USER", message: "Connected"})
    );
}

function onError(){
    console.log("Error while connecting to server");
    alert("Couldn't connect to messaging server");
}

function onMessageRecieved(payload){
    var message = JSON.parse(payload.body);
}