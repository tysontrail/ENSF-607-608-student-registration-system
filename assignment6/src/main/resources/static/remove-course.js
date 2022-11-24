
deleteCourse.onsubmit = async (e) => {
    e.preventDefault();

    data = new FormData(deleteCourse);
    [cname, section] = data.values();

    fetch('http://localhost:8080/api/v1/course/' + cname + '/student/' +  JSON.parse(sessionStorage.getItem("student")).id,
    {
        
        method: "DELETE",
    }).then(async rawResponse =>{
        console.log('response.status: ', rawResponse.status);
        console.log(rawResponse);
        if (rawResponse.status == 200){
            student = await rawResponse.json();
            console.log("status code 200");
            alert("Course removed successfully");
        }
        else{
            var content = await rawResponse.json();
            console.log("status code not 200");
            alert(content.message);
        }
    });
}