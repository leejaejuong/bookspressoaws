let $idForm = document.querySelector('#idForm');
let $pwForm =document.querySelector('#pwForm');
let loginBtn = document.querySelector('#loginBtn');
let $loginForm = document.querySelector('#login-form');
{
    // $idForm.addEventListener('keyup', function(){
    //     console.log("@@@@@@@"+this.value);
    // })

    // $idForm.addEventListener('blur', function (){
    //     console.log(this.value);
    // })

    loginBtn.addEventListener('click', function (){
        console.log("id : " + $idForm.value);
        console.log("pw : " + $pwForm.value);
        if ($idForm.value&&$pwForm.value){
            console.log("ture");
            $loginForm.submit();
        }else {
            console.log("false");
            // continue; 반복문에서만 사용가능

        }

    })


}