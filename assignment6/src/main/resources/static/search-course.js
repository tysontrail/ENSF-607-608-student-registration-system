searchCourse.onsubmit = async (e) => {
    e.preventDefault();

    data = new FormData(searchCourse);
    [cname] = data.values();

    fetch('http://localhost:8080/api/v1/course/' + cname,
    {
        method: "GET",
    }).then(async rawResponse =>{
        console.log('response.status: ', rawResponse.status);
        console.log(rawResponse);
        if (rawResponse.status == 200){
            course = await rawResponse.json();
            console.log("status code 200");
            console.log(course);
            document.getElementById("course").innerHTML =JSON.stringify(course);
        }
        else{
            var content = await rawResponse.json();
            console.log("status code not 200");
            alert(content.message);
        }
    });
}