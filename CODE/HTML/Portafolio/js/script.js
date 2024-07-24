window.onscroll = function (e) {
    let element = document.getElementsByTagName('nav')[0]
    if(window.scrollY > 650){
        element.classList.add('nav-change')
    }
    else {
        element.classList.remove('nav-change')
    }
}

document.getElementById('nav-logo').onclick = function() {
    let element = document.getElementsByTagName('main')[0]
    element.scrollIntoView()
}