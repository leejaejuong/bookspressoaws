export function emailCertifiedNumber(email){
    let findBtn= document.querySelector('#find-btn');
    let errorMsg = document.querySelector("#error-msg");
    let $findForm = document.querySelector('#find-form');
    let $certifiedNumber = document.querySelector('.certified-num');

    fetch(`/find/email/${email}`, {method:'POST'})
        .then(resp=> resp.text())
        .then(authNumber =>{
            if(authNumber != ""){
                console.log("authNumber = " + authNumber);
                console.log("이메일 전송 성공!");
                // ok
                findBtn.addEventListener('click',()=>{
                    if (authNumber == $certifiedNumber.value){
                        console.log("인증 성공!!!" + authNumber);
                        $findForm.submit();
                    }
                    else{
                        errorMsg.innerText = "인증번호가 틀렸습니다. 다시 입력해주세요.";
                        errorMsg.style.color = '#FF3831';
                        console.log("인증번호 실패 ");
                    }
                })
            }else{
                alert("입력하신 정보와 일치하는 회원이 없어 인증번호를 발송할 수 없습니다.");
            }
        })
}
