//function for registering student
function displayCatalog(){

    fetch("http://localhost:8080/api/v1/course")
    .then(res => res.json())
    .then(data => document.getElementById("courseCat").innerHTML =JSON.stringify(data));
}