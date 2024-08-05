let $InputBox = document.querySelectorAll('.typoBox');
let $inputMsg = document.querySelectorAll('.inputMsg');

// 안내 문자
// 아이디, 비밀번호
/**
 * 회원가입 정보 작성 데이터 중 아이디와 비밀번호를 입력하기 위해 input창을 클릭 시 자동으로 나오는
 * 아이디와 비밀번호의 작성 기준의 대한 메세지 출력 코드
 */
// function findBasicMsg(name) {
//
//     let basicMag = document.getElementById(name+"Msg").value;
//     console.log()
//     return basicMag;
// }

// {
//     for
//     $InputBox.addEventListener('focus', function (){
//         let inputName = this.getAttribute("name");
//         console.log("inputName ::: "+inputName);
//
//         // let value = document.getElementById(inputName+"Msg").innerHTML;
//         // console.log("value" + value);
//
//         // $InputBox.innerHTML=findBasicMsg(inputName);
//     })

{
    for (let i = 0; i < $InputBox.length; i++) {

        $InputBox[i].addEventListener('focus', function (){
            let inputName = this.getAttribute("name");
            console.log("inputName ::: "+inputName);

            let basicMsg = document.getElementById(inputName+"Msg").innerText;
            console.log(basicMsg);

            // $inputMsg[i].innerHTML = basicMsg;

            $inputMsg[i].innerHTML = basicMsg;

        })

        $InputBox[i].addEventListener('blur', function (){
            let inputName = this.getAttribute("name");
            console.log("focusOut ::: "+inputName);

            if (!this.value){
                let errorMsg = document.getElementById(inputName+"Invalid").innerText;
                console.log(errorMsg);

                // document.getElementsByClassName('inputMsg')

                // ++ 빈칸으로 focus out 시 inputMsg의 폰트 색상이 빨간색으로 변화되어얌!!
                // class에 error추가 해서 하면 될꺼 같은디?
                $inputMsg[i].classList.add('error');

                $inputMsg[i].innerHTML = errorMsg;

            }else{
                $inputMsg[i].innerHTML="";
            }



            // console.log("#######"+this.value);



        })


    }


}



// 오류 문자 => font-color : red
// 아이디, 이름, 이메일, 닉네임
/**
 * 회원가입을 위한 데이터 작성 중 input을 클릭 후 아무것도 작성하지 않고 다른 것을 클릭 했을 때
 * 출력되는 에러 메세지? 처리 코드
 */


/**
 * 모든 input 에 데이터를 입력해야만 submit 버튼이 활성화 되게 하는 코드
 */
// {
//      let $inputBox = document.querySelectorAll('.typoBox')
//
//
//
// }















