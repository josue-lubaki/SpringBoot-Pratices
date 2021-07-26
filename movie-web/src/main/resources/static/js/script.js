
fetch('../movie')
    .then(res => res.json())
    .then(res => {
        var movieListNode = document.getElementById('movie-list');
        movieListNode.innerHTML = "";

        var table = document.createElement("table");
        table.setAttribute("border","1");
        movieListNode.appendChild(table);

        res.forEach(movie => {

            var tr = document.createElement("tr");
            table.appendChild(tr);

            var td = document.createElement("td");
            var text = document.createTextNode(`${movie.id}`);
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
            var button = document.createElement("button");
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
            var movieDetailNode = document.getElementById('movie-detail');
            movieDetailNode.innerHTML = "";

            var p = document.createElement("p");
            var text = document.createTextNode(`Id: ${res.id}`);
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

        });
}
