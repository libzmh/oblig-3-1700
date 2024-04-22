let ticketsArray = [];

function buyTickets() {
    const movie = document.getElementById('movie').value;
    const tickets = document.getElementById('tickets').value;
    const firstname = document.getElementById('firstname').value;
    const surname = document.getElementById('surname').value;
    const email = document.getElementById('email').value;
    const telephone = document.getElementById('telephone').value;

    if (!movie) {
        document.getElementById('movieError').textContent = 'Please select a movie';
        return;
    } else {
        document.getElementById('movieError').textContent = '';
    }

    if (isNaN(tickets) || tickets <= 0) {
        document.getElementById('ticketsError').textContent = 'Please enter a valid number of tickets';
        return;
    } else {
        document.getElementById('ticketsError').textContent = '';
    }

    if (!firstname) {
        document.getElementById('firstnameError').textContent = 'First name is required';
        return;
    } else {
        document.getElementById('firstnameError').textContent = '';
    }

    if (!surname) {
        document.getElementById('surnameError').textContent = 'Surname is required';
        return;
    } else {
        document.getElementById('surnameError').textContent = '';
    }

    if (!email.includes('@') || !email.includes('.')) {
        document.getElementById('emailError').textContent = 'Please enter a valid email';
        return;
    } else {
        document.getElementById('emailError').textContent = '';
    }

    if (telephone.length !== 8 || isNaN(telephone)) {
        document.getElementById('telephoneError').textContent = 'Please enter a valid telephone number';
        return;
    } else {
        document.getElementById('telephoneError').textContent = '';
    }

    const ticketObject = {
        movie: movie,
        tickets: tickets,
        firstname: firstname,
        surname: surname,
        email: email,
        telephone: telephone
    };
    $.post("/lagrefilm", ticketObject, function(){
         hentAlle();
     });

    ticketsArray.push(ticketObject);
    document.getElementById("movie").value="";
    document.getElementById("tickets").value="";
    document.getElementById("firstname").value="";
    document.getElementById("surname").value="";
    document.getElementById("email").value="";
    document.getElementById("telephone").value="";
    displayTickets();
}
function hentAlle() {
    $.get( "/hentfilm", function( data ) {
        displayTickets(data);
    });
}

function displayTickets(ticketsArray) {
    let out = "<table><tr>" +
        "<th>Movie</th><th>Amount</th><th>Firstname</th><th>Lastname</th><th>Telephone</th><th>Email</th>" +
        "</tr>";
    for (const tickets of ticketsArray) {
        out += "<tr>";
        out += "<td>"+tickets.movie+"</td>" +
            "<td>"+tickets.tickets+"</td>" +
            "<td>"+tickets.firstname+"</td>" +
            "<td>"+tickets.surname+"</td>" +
            "<td>"+tickets.email+"</td>" +
            "<td>"+tickets.telephone+"</td>";
        out += "</tr>";
    }
    document.getElementById("ticketTableBody").innerHTML = out;
}


function deleteAllTickets() {
    ticketsArray = [];
    document.getElementById("ticketTableBody").innerHTML = "";
    $.get( "/slettalle", function() {
        hentAlle();
    });
    //displayTickets();
}
