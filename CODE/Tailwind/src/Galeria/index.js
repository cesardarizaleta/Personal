lista = document.querySelector('main ul')

routes = ['images/Unknown.jpg','images/Unknown-2.jpg','images/Unknown-3.jpg','images/Unknown-4.jpg','images/Unknown-5.jpg']

routes.forEach(route => {
    li = document.createElement('li')
    img = document.createElement('img')
    img.src = route
    li.appendChild(img)
    lista.appendChild(li)
})