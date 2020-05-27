// Your web app's Firebase configuration
var firebaseConfig = {
    apiKey: "AIzaSyDnM7XBR4KT8vMWJSWS1RZDe7J9GxhckYE",
    authDomain: "wellness-jdr3011.firebaseapp.com",
    databaseURL: "https://wellness-jdr3011.firebaseio.com",
    projectId: "wellness-jdr3011",
    storageBucket: "wellness-jdr3011.appspot.com",
    messagingSenderId: "342085213102",
    appId: "1:342085213102:web:6a7efe6a396b246f26c63f",
    measurementId: "G-GBDS8EF8F0"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
const database = firebase.database();

/**********splash Logic**********/

const firstRegisterBtn = document.getElementById("firstRegisterBtn");

if(firstRegisterBtn != null){
    firstRegisterBtn.addEventListener("click", function(){
        window.location.href = "Register.html";
    });
}


/**********Login Logic**********/

const emailLogin = document.getElementById("emailLogin");
const passwordLogin = document.getElementById("passwordLogin");
const loginBtn = document.getElementById("loginBtn");

if(loginBtn != null){
    loginBtn.addEventListener("click", validateUser);
}

function validateUser(){

    let email = emailLogin.value;
    let password = passwordLogin.value;

    let found = false;

    database.ref().child("Users").on("child_added",function(snapshot){
        let user = snapshot.val();
        if(email == user.email && password == user.password){
            found = true;
        }
    });

    if(found){
        window.location.href = "Home.html";
    }else{
        alert("datos incorrectos");
    }

}

/**********Register Logic**********/

const nameRegister = document.getElementById("nameRegister");
const emailRegister = document.getElementById("emailRegister");
const passwordRegister = document.getElementById("passwordRegister");
const registerBtn = document.getElementById("registerBtn");

if(registerBtn != null){
    registerBtn.addEventListener("click",addUser);
}


function validateData(name,email,password){

    let validate =true;

    let expresion = /\w+@(hotmail|gmail)+\.(com)/;

    if(name == "" || email == "" || password == ""){
        validate = false;
        alert("Por favor rellene todos los parametros");
    }
    else if(!expresion.test(email)){
        validate = false;
        alert("correo no valido");
    }

    return validate;
}

function addUser(){

    let name = nameRegister.value;
    let email = emailRegister.value;
    let password = passwordRegister.value;

    if(validateData(name,email,password)){

        let id = database.ref().child("Users").push().key;
        let user = new User(id,name,email,password);

        database.ref().child("Users").child(id).set(user);

        alert("Se ha añadido el usuario");

        nameRegister.value = "";
        emailRegister.value = "";
        passwordRegister.value = "";

        window.location.href = "Login.html";
    }
}


