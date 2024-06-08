menu = document.getElementById('menu')
lista = document.getElementsByClassName('nav-list')[0]

menu.style.display = 'none'

if(window.innerWidth < 600){
    lista.style.display = 'none'
    menu.style.display = 'inline'
}
