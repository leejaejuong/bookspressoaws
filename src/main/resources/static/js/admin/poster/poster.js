import {dropDebate} from "../modul/debateModul.js";

let $debateDropBtn = document.querySelector('#drop-btn');
let $allCheckBox = document.querySelector("#allCheck");
let $checkBoxs = document.querySelectorAll(".check-boxes");

    // 체크 박스 전체 선택
{
    $allCheckBox.addEventListener('change',function (){
        let isChecked = $allCheckBox.checked;
        $checkBoxs.forEach(function (checkBox){
            checkBox.checked = isChecked;
        })
    })
}
{
    $debateDropBtn.addEventListener('click',() =>{
        dropDebate();
        console.log("포스트 삭제 성공!");
        location.reload();
    })
}