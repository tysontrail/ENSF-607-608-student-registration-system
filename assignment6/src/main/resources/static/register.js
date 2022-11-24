const apiURL = "http://localhost:8080/api/v1/student/register";

//post function. Stringifies for you and recieves object
async function postFetch(url, body1) {

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body1)
    })
    .then(async rawResponse =>{
        console.log(rawResponse);
        var content = await rawResponse.json();
        alert(content['message']);
    })
    .catch(test =>{
        console.log("promise not fulfilled therefore user has been logged in");
        console.log(test);
        alert("Student Successfully Registered!");
    });
}

registerForm.onsubmit = async (e) => {
    e.preventDefault();
    console.log("submit clicked");


    //storing first name last name and id
    data = new FormData(registerForm);
    [un, pw, id] = data.values()
    //could also do registerForm.fname.value instead of making FormData object

    let studentObj = {
        'username': un,
        'password': pw,
        'ucid': id,
    };

    //sending student to model
    postFetch(apiURL, studentObj);
    
};