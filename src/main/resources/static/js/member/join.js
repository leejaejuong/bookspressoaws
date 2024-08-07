let $InputBox = document.querySelectorAll('.typoBox');
let $inputMsg = document.querySelectorAll('.inputMsg');
let $joinForm = document.querySelector("#join-form");
let $joinBtn = document.querySelector("#join-btn");

let $checkLoignId = document.getElementsByName("loginId");

// 안내 문자
// 아이디, 비밀번호
/**
 * 회원가입 정보 작성 데이터 중 아이디와 비밀번호를 입력하기 위해 input창을 클릭 시 자동으로 나오는
 * 아이디와 비밀번호의 작성 기준의 대한 메세지 출력 코드
 */
{

    let $inputLoginId = $InputBox[0];
    // let loginId = $inputLoginId.value;
// input 데이터의 값이 변동 되었을 때 실행 되는 이벤트
    $inputLoginId.addEventListener('change', function (){

        let  loginId = this.value;
        console.log("loginId = " + loginId);
        let resultMsg = "";

        fetch(`/member/check/${loginId}`, {method: 'POST'})
            .then(resp=> resp.text())
            .then(text => {
                if (text == 1){
                    // 이미 존재하는 아이디
                    resultMsg = ""
                }else{
                    resultMsg = "사용가능한 ID입니다. ";
                }
            })
    })


    // console("loginID @@@@@@@@@@ " + $checkLoignId);
    // fetch(`/member/${loginId}/checkLoginId`, {method: 'POST'})
    //     .then()



}

{
    for (let i = 0; i < $InputBox.length; i++) {

        $InputBox[i].addEventListener('focus', function (){
            let inputName = this.getAttribute("name");
            console.log("inputName ::: "+inputName);

            let className = $inputMsg[i].getAttribute("class");
            console.log("class = " + className);

            let basicMsg = document.getElementById(inputName+"Msg").innerText;
            console.log(basicMsg);

            $inputMsg[i].innerHTML = basicMsg;

            if(className == "inputMsg basicMsg error" || className == "inputMsg error"){
                $inputMsg[i].classList.remove("error");
                console.log("class = " + className);

            }


        })


    }}


{
    for (let i = 0; i < $InputBox.length; i++) {
        $InputBox[i].addEventListener('blur', function (){
            let inputName = this.getAttribute("name");
            console.log("focusOut ::: "+inputName);

            if (!this.value){
                let errorMsg = document.getElementById(inputName+"Invalid").innerHTML;
                console.log(errorMsg);

                // document.getElementsByClassName('inputMsg')

                $inputMsg[i].classList.add('error');

                $inputMsg[i].innerHTML = errorMsg;

            }else{
                $inputMsg[i].innerHTML="";
            }
    })
}
}


// 오류 문자 => font-color : red
// 아이디, 이름, 이메일, 닉네임


/**
 * 모든 input 에 데이터를 입력해야만 submit 버튼이 활성화 되게 하는 코드
 */
{
    let successJoin = [];

     $joinBtn.addEventListener("click", function (){
         let joinFormArray = Array.from($joinForm);

         for (let i = 0; i < joinFormArray.length-1; i++) {
             successJoin[i] =Boolean(joinFormArray[i].value);

             // console.log("num = " + joinFormArray.length);
             // console.log("name = " + joinFormArray[i].name);
             // console.log("value = " + joinFormArray[i].value );
         }
         console.log("array = " + successJoin);

         // let isBelowThreshold = (currentValue) => { currentValue = true;}
         let joinResult = successJoin.every(result => result===true);

         console.log("성공여부 = " + joinResult);

         if (joinResult){
             $joinForm.submit()
         }


     })
}

/**
 * fetch로 아이디, 별명 중복 확인 검사
 */
















