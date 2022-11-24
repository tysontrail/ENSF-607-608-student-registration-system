
function displayMyCourses(){
    console.log(sessionStorage.getItem("student"))
    fetch("http://localhost:8080/api/v1/student/myCourses", {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: sessionStorage.getItem("student")
    })
    .then(res => res.json())
    .then(data => 
        document.getElementById("myCourses").innerHTML =JSON.stringify(data));
}