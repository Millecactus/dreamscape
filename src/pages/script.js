document.getElementById('textForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Empêche l'envoi du formulaire par défaut

    // Récupérer le contenu du textarea
    var text = document.getElementById('textInput').value;

    // Envoyer le texte au backend (vous devez implémenter cette partie)
    // Vous pouvez utiliser AJAX, Fetch API ou d'autres méthodes pour envoyer les données au backend
    // Par exemple avec Fetch API :
    fetch('/api/enregistrerTexte', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ texte: text })
    })
    .then(response => {
        if (response.ok) {
            console.log('Texte enregistré avec succès !');
        } else {
            console.error('Échec de l\'enregistrement du texte !');
        }
    })
    .catch(error => {
        console.error('Erreur lors de l\'envoi des données au backend :', error);
    });
});
