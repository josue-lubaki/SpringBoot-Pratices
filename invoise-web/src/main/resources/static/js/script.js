
fetch('../invoice')
    .then(res => res.json())
    .then(res => {
        const invoiceListNode = document.getElementById('invoice-list');
        invoiceListNode.innerHTML = "";

        const table = document.createElement("table");
        table.setAttribute("border","1");
        invoiceListNode.appendChild(table);

        res.forEach(invoice => {
            let tr = document.createElement("tr");
            table.appendChild(tr);

            let td = document.createElement("td");
            let text = document.createTextNode(`${invoice.number}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            text = document.createTextNode(`${invoice.customer.name}`);
            td.appendChild(text);
            tr.appendChild(td);

            td = document.createElement("td");
            let button = document.createElement("button");
            button.setAttribute("type","button");
            button.onclick = function() {
                showDetail(`${invoice.number}`);
            };
            text = document.createTextNode("Details");
            button.appendChild(text);
            td.appendChild(button);
            tr.appendChild(td);


        });

    });


function showDetail(invoiceNumber){
    fetch(invoiceNumber)
    .then(res => res.json())
    .then(res => {
        const invoiceDetailNode = document.getElementById('invoice-detail');
        invoiceDetailNode.innerHTML = "";

        let p = document.createElement("p");
        let text = document.createTextNode(`Number: ${res.number}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Customer name: ${res.customer.name}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

        p = document.createElement("p");
        text = document.createTextNode(`Order number: ${res.orderNumber}`);
        p.appendChild(text);
        invoiceDetailNode.appendChild(p);

    });
}
