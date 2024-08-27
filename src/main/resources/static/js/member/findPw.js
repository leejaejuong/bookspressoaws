import {emailCertifiedNumber} from '../modul/email.js';

let $loginId = document.querySelector('.loginId')
let $email =document.querySelector('#email');
let $certifiedBtn = document.querySelector('.certified-btn');


//인증번호 발송

{
        $certifiedBtn.addEventListener('click', function (){
            let login = $loginId.value;
            let email = $email.value;

            if (email!=null&&$loginId!=null){
                fetch(`/find/loginId/${email}`, {method:"POST"})
                    .then(resp=>resp.text())
                    .then(text=>{
                        if (text != login){
                            alert("올바른 아이디가 아닙니다.");
                        }else{
                            console.log("login = " + login );
                            emailCertifiedNumber(email);
                        }
                    })
            }


        })


}
