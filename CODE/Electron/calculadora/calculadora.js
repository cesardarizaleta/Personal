let btns = document.querySelectorAll('button');

btns.forEach(btn => {
    btn.onclick = function() {
        let input = document.querySelector('input');
        if(btn.innerText == 'C') {
            input.value = '';
            return;
        }
        else if(btn.innerText == '=') {
            if(input.value === 'NaN'){
                input.value = ""
                return
            }
            if(input.value[input.value.length - 1] == '+' || input.value[input.value.length - 1] == '-' || input.value[input.value.length - 1] == '*' || input.value[input.value.length - 1] == '/'){
                return;
            }
            input.value = eval(input.value);
            return;
        }
        if(input.value === 'NaN'){
            input.value = ""
        }
        input.value += btn.innerText;
    }
})