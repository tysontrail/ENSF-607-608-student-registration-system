
addCourse.onsubmit = async (e) => {
    e.preventDefault();

    data = new FormData(addCourse);
    [cname] = data.values()
    console.log(cname);

    fetch('http://localhost:8080/api/v1/course/' + cname + '/student/' +  JSON.parse(sessionStorage.getItem("student")).id,
    {
        
        method: "PUT",
    })
    .then(async rawResponse =>{
        console.log('response.status: ', rawResponse.status);
        console.log(rawResponse);
        if (rawResponse.status == 200){
            student = await rawResponse.json();
            alert("Course added successfully");
        }
        else{
            var content = await rawResponse.json();
            console.log("status code not 200");
            alert(content.message);
        }
    });

}