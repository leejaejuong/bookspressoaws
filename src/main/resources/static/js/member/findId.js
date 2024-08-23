let loginId = document.querySelector('.loginId')
let name = document.querySelector('.name');
let $email =document.querySelector('#email');
let $certifiedNumber = document.querySelector('.certified-num');
let $certifiBtn = document.querySelector('.certifi-btn');

let $findIdForm = document.querySelector('#findId-form');
let $findPwForm = document.querySelector('#findPw-form');

let findBtn= document.querySelector('#find-btn');


{
    findBtn.addEventListener('click',()=>{
        console.log($email.value);
        console.log($certifiedNumber.value);

        if(name.value&&$email.value&&$certifiedNumber.value){
            console.log("true");
            $findIdForm.submit();
        }else{
            console.log("false");
        }

    })
}

/* 비밀번호 찾기 데이터 전송*/
{
    findBtn.addEventListener('click',()=>{
        console.log(loginId.value);
        console.log($email.value);
        console.log($certifiedNumber.value);

        if(loginId.value&&name.value&&$email.value&&$certifiedNumber.value){
            console.log("true");
            $findPwForm.submit();
        }else{
            console.log("false");
        }

    })
}

//인증번호 발송
{

        $certifiBtn.addEventListener('click', function (){
            console.log('click!!!!!!')
            let email = $email.value;
            console.log(email)
            if (email==null){ alert('not')}
            fetch(`/findId/email/${email}`, {method:'POST'})
                .then(resp=> resp.text())
                .then(authNumber =>{
                    if(authNumber != ""){
                        console.log("authNumber = " + authNumber);
                        console.log("이메일 전송 성공!")
                        findBtn.addEventListener('click',()=>{
                        if (authNumber == $certifiedNumber.value){
                            console.log("인증 성공!!!")
                        }else{
                            let errorMsg = document.querySelector("#error-msg");
                                errorMsg.innerText = "인증번호가 틀렸습니다. 다시 입력해주세요.";
                                errorMsg.style.color = '#FF3831';

                                console.log("인증번호 실패 ");
                        }
                        })
                    }else{
                        // failedModal();
                        alert("입력하신 정보와 일치하는 회원이 없어 인증번호를 발송할 수 없습니다.");
                    }
                })
        });

}




{
    function failedModal() {
        let $closeBtn = document.querySelector('#close-modal_btn');
        let $modal = document.querySelector('.modal');

        $modal.style.display = "block";

        $closeBtn.addEventListener('click', ()=>{
            $modal.style.display = "none";
        })

    }

}