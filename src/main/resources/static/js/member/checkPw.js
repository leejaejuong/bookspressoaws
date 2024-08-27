
let $changePwForm = document.querySelector('#changePw-form');
let $changeBtn = document.querySelector('#change-btn');

let $newPw = document.querySelector('#newPassword');
let $checkNewPw = document.querySelector('#check-newPassword');

let newPwErrorMsg = document.querySelector('.newPw-msg');
let checkErrorMsg = document.querySelector('.check-msg');


{

     let checkPW = $checkNewPw.value;

    let pwReg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/

    $newPw.addEventListener('change', function () {

        let newPw = this.value;
        console.log("newpw = " + newPw);
        if(!pwReg.test(newPw)){
            newPwErrorMsg.innerText = '8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합으로 만들어주세요.';
            newPwErrorMsg.style.color = '#FF3831';
        }else{
            newPwErrorMsg.innerText='';
        }
    })
    //새로운 비밀번호 정규화
    //예전 비밀번호가 일치하는지 확인

$changeBtn.addEventListener('click', ()=>{
    let newPw = $newPw.value;
    let checkNewPw = $checkNewPw.value;
     if (newPw == checkNewPw ){
         let loginId = document.getElementById('loginId').value;
         console.log("loginId = " + loginId);
         fetch(`/update/password/${loginId}/${newPw}`, {method:'POST'})
             .then(resp => {
                 if(resp){
                     console.log("비번 수정 완료 ");
                     $changePwForm.submit();
                 }else{
                     console.log("비번 수정 실패");
                 }
             })


     }else{
         checkErrorMsg.innerText = '비밀번호가 일치하지 않습니다.';
         checkErrorMsg.style.color = '#FF3831';
     }
})
}


