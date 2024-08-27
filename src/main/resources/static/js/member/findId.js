import {emailCertifiedNumber} from '../modul/email.js';

let $email =document.querySelector('#email');
let $certifiedBtn = document.querySelector('.certified-btn');

let $findForm = document.querySelector('#findId-form');

let $certifiedNumber = document.querySelector('.certified-num');
let findBtn= document.querySelector('#find-btn');
let errorMsg = document.querySelector("#error-msg");



/* 비밀번호 찾기 데이터 전송*/
// {
//     findBtn.addEventListener('click',()=>{
//         console.log(loginId.value);
//         console.log($email.value);
//         console.log($certifiedNumber.value);
//
//         if(loginId.value&&name.value&&$email.value&&$certifiedNumber.value){
//             console.log("true");
//             $findPwForm.submit();
//         }else{
//             console.log("false");
//         }
//
//     })
// }

//인증번호 발송
{

        $certifiedBtn.addEventListener('click', ()=>{
            console.log('click!!!!!!')
            let email = $email.value;
            console.log(email)
            if (email==null){ alert('이메일을 입력하세요.')}
            emailCertifiedNumber(email);
        });

}

