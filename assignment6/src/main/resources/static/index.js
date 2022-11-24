//index.js is the login page
//script takes the form, sends it to client
//2 possible responses: 1) student exists and logs in going to menu.html. 2) student does not exist and is prompted to relogin
const apiURL = "http://localhost:8080/api/v1/student/login";
const nextPageurl = "http://localhost:8080/menu.html";

let student;

//funtion loads another html page
function loadPage(){
    window.location.href = nextPageurl;
}

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
        console.log('response.status: ', rawResponse.status);
        console.log(rawResponse);
        if (rawResponse.status == 200){
            student = await rawResponse.json();
            console.log("status code 200");
            console.log(JSON.stringify(student));
            sessionStorage.setItem("student", JSON.stringify(student));
            loadPage()
        }
        else{
            var content = await rawResponse.json();
            console.log("status code not 200");
            alert(content.message);
        }
    });
}

//function putFetch
function enrollFetch(studentId, courseId ,url) {
    fetch(url + '/' + courseId, '/student' + studentId, {
      method: 'PUT'
    })
    .then(response => response.json());
}

loginForm.onsubmit = async (e) => {
    e.preventDefault();
    console.log("submit clicked");


    //storing first name last name and id
    data = new FormData(loginForm);
    [un, pw, id] = data.values()
    //could also do loginForm.fname.value instead of making FormData object

    let studentObj = {
        'username': un,
        'password': pw,
        'ucid': id,
    };

    //sending student to model
    postFetch(apiURL, studentObj);
    
};