document.querySelector('#send').addEventListener('click', () => {
    const message = document.querySelector('input').value;
    if (message) {
        let messageElement = document.createElement('div');
        messageElement.classList.add('w-full','bg-white','p-5');
        messageElement.innerText = message;
        document.querySelector('#chat').appendChild(messageElement);
        document.querySelector('input').value = '';
    }
    else {
        alert('Please enter a message');
    }
})