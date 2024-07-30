window.onscroll = function (e) {
    let element = document.getElementsByTagName('nav')[0]
    if(window.scrollY > 650 && window.scrollY < 2000) {
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

document.getElementById('btn-send').onclick = function() {

    let title = document.getElementsByClassName('input-desc')[0].value
    let descripcion = document.getElementsByClassName('area-desc')[0].value

    emailjs.init('HGxd9iZ1fDu_9Q9kE')

    emailjs.send("service_4y5fjw9","template_tifov3b",{
        message: descripcion,
        subject: title
    });
}