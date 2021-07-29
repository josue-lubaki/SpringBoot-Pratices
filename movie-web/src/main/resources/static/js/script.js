
fetch('../movie')
    .then(res => res.json())
    .then(res => {
        const movieListNode = document.getElementById('movie-list');
        movieListNode.innerHTML = "";

        const table = document.createElement("table");
        table.setAttribute("border","1");
        movieListNode.appendChild(table);

        res.forEach(movie => {

            let tr = document.createElement("tr");
            table.appendChild(tr);

            let td = document.createElement("td");
            let text = document.createTextNode(`${movie.id}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${movie.titre}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${movie.genre}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            let button = document.createElement("button");
            button.setAttribute("type","button");
            button.onclick = function() {
                showDetail(`${movie.id}`);
            };
            text = document.createTextNode("Details");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);

        });

    });


function showDetail(movieNumber){
    fetch(movieNumber)
        .then(res => res.json())
        .then(res => {
            let movieDetailNode = document.getElementById('movie-detail');
            movieDetailNode.innerHTML = "";

            let p = document.createElement("p");
            let text = document.createTextNode(`Id: ${res.id}`);
            p.appendChild(text);
            movieDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Titre: ${res.titre}`);
            p.appendChild(text);
            movieDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Genre: ${res.genre}`);
            p.appendChild(text);
            movieDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Description: ${res.descriptions}`);
            p.appendChild(text);
            movieDetailNode.appendChild(p);

            p = document.createElement("p");
            text = document.createTextNode(`Main actor: ${res.mainActor.firstName} ${res.mainActor.lastName}`);
            p.appendChild(text);
            movieDetailNode.appendChild(p);

            p = document.createElement("p");
            let sum = res.reviews.map((a) => a.mark).reduce((a, b) => a + b, 0);
            let avg = (sum / res.reviews.length) || 0;
            text = document.createTextNode(`Mark: ${avg}/5`);
            p.appendChild(text);
            movieDetailNode.appendChild(p);

        });
}
