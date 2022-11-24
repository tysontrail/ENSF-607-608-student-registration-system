function addCourse(){
    fetch('http://localhost:8080/course', {method: 'POST', body: new FormData(form)})
    .then(res => res.json())
    .then(console.log)
}