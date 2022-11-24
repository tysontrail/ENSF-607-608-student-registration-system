
function dispMenu(){
    document.getElementById("p1").innerHTML = "Welcome " + JSON.parse(sessionStorage.getItem("student")).username;
}
function clearSession(){
    sessionStorage.clear();
}