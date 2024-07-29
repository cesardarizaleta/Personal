document.getElementById('enviar').addEventListener('click', function() {
    if(document.querySelector('select').value === 'Seleccionar asignatura' || document.querySelector('textarea').value === '') {
        alert('Por favor, rellene todos los campos')
        return
    }
    else if(document.querySelector('textarea').value.length < 30) {
        alert('La descripción debe tener al menos 30 caracteres')
        return
    }
    
    const asignatura = document.createTextNode(document.querySelector('select').value)
    const descripcion = document.createTextNode(document.querySelector('textarea').value)
    const descargar = document.createElement('a');
    descargar.classList.add('bg-blue-500','text-white','p-2','rounded-lg','text-center','w-full','cursor-pointer')
    descargar.innerText = 'Descargar'
    const newNode = document.createElement("div");
    newNode.appendChild(asignatura);
    newNode.appendChild(document.createElement('br'))
    newNode.appendChild(descripcion)
    newNode.appendChild(descargar);
    newNode.classList.add('bg-white','shadow-lg','w-full','h-full','rounded-lg','p-2','flex','justify-center','items-center')
    const li = document.createElement('li');
    li.appendChild(newNode);
    document.querySelector('#documentos').appendChild(li);

    document.querySelector('select').value = 'Seleccionar'
    document.querySelector('textarea').value = ''
})