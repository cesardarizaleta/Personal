menu = document.getElementById('menu')
lista = document.getElementsByClassName('nav-list')[0]
logo = document.getElementById('logo')
listaelement = document.getElementsByClassName('nav-element')

menu.style.display = 'none'

if(window.innerWidth < 600){
    lista.style.display = 'none'
    menu.style.display = 'inline'
}

menu.addEventListener('click',function(){
    
    lista.style.display = 'inline'
    this.style.display = 'none'
    for (let i = 0; i < listaelement.length; i++) {
        listaelement[i].style.display = 'inline'
        if(i===listaelement.length - 1){
            listaelement[i].style.display = 'none'
        }
    }
    
})


