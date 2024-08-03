document.onkeydown = function(e) {
    player = document.getElementById('player');
    if (e.keyCode == 37) {
        if(getComputedStyle(player).left > '0px'){
            player.style.left = parseInt(getComputedStyle(player).left) - 10 + 'px';
        }
    }
    if (e.keyCode == 39) {
        if(getComputedStyle(player).left.replace("px","") <= window.innerWidth - 100){
            player.style.left = parseInt(getComputedStyle(player).left) + 10 + 'px';
        }
    }
    if (e.keyCode == 38) {
        //Animacion de Salto
    }

    console.log(getComputedStyle(player).left);
}