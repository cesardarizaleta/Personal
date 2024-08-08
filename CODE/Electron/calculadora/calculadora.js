let btns = document.querySelectorAll('button');

btns.forEach(btn => {
    btn.onclick = function() {
        let input = document.querySelector('input');
        if(btn.innerText == 'C') {
            input.value = '';
            return;
        }
        else if(btn.innerText == '=') {
            if(input.value === 'NaN' || input.value === 'Infinity') {
                input.value = ""
                return
            }
            if(input.value[input.value.length - 1] == '+' || input.value[input.value.length - 1] == '-' || input.value[input.value.length - 1] == '*' || input.value[input.value.length - 1] == '/'){
                return;
            }
            input.value = eval(input.value);
            return;
        }
        if(input.value === 'NaN' || input.value === 'Infinity') {
            input.value = ""
        }
        input.value += btn.innerText;
    }
})

document.querySelector('body').onkeydown = function(e) {
    if(e.key.match(/[0-9]/)) {
        let input = document.querySelector('input');
        if(input.value === 'NaN' || input.value === 'Infinity'){
            input.value = ""
        }
        input.value += e.key;
    }
    else if(e.key.match(/[\+\-\*\/]/)) {
        let input = document.querySelector('input');
        if(input.value[input.value.length - 1] == '+' || input.value[input.value.length - 1] == '-' || input.value[input.value.length - 1] == '*' || input.value[input.value.length - 1] == '/'){
            return;
        }
        input.value += e.key;
    }
    else if(e.key === '=' || e.key === 'Enter') {
        let input = document.querySelector('input');
        if(input.value === 'NaN' || input.value === 'Infinity'){
            input.value = ""
            return
        }
        if(input.value[input.value.length - 1] == '+' || input.value[input.value.length - 1] == '-' || input.value[input.value.length - 1] == '*' || input.value[input.value.length - 1] == '/'){
            return;
        }
        input.value = eval(input.value);
    }
} 