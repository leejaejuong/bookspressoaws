let loginId = document.querySelector('.loginId')
let name = document.querySelector('.name');
let email =document.querySelector('.email');
let certifiNum = document.querySelector('.certifi-num');

let $findIdForm = document.querySelector('#findId-form');
let $findPwForm = document.querySelector('#findPw-form');

let  findBtn= document.querySelector('#find-btn');

{
    findBtn.addEventListener('click',()=>{
        console.log(name.value);
        console.log(email.value);
        console.log(certifiNum.value);

        if(name.value&&email.value&&certifiNum.value){
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
        console.log(name.value);
        console.log(email.value);
        console.log(certifiNum.value);

        if(loginId.value&&name.value&&email.value&&certifiNum.value){
            console.log("true");
            $findPwForm.submit();
        }else{
            console.log("false");
        }

    })
}