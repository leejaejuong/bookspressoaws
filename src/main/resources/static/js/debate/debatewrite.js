let $textrea = document.querySelector('.write-title-text');
let $textcount = document.querySelector('.title-count');

$textrea.addEventListener('keyup', onkeyup)
function onkeyup() {
    const inputText = $textrea.value;
    $textcount.innerText = inputText.length;
}