

let $detailBtn = document.querySelectorAll('.detail-btn');
let $detailInfo = document.querySelectorAll('.view-info');
{

    /**
     * 토론리스트의 버튼을 누르면 토론의 상세 정보를 볼 수 있다.
     */

    for (let i = 0; i < $detailBtn.length; i++) {
        $detailBtn[i].addEventListener('click', function () {
            let info = $detailInfo[i].getAttribute("class");
            console.log("버튼 class 이름 : " + info);


            if (info == "view-info") {
                $detailInfo[i].classList.add("detailOff");
                console.log($detailInfo[i].getAttribute("class"));
            } else {
                $detailInfo[i].classList.remove("detailOff");
                console.log($detailInfo[i].getAttribute("class"));
            }


        })
    }
}

{
   let $allCheckBox = document.querySelector("#allCheck");
   let $checkBoxs = document.querySelectorAll(".check-boxes");

   // console.log($allCheckBox.checkbox);
   // $allCheckBox.addEventListener('click',function (){
   //
   // if ($allCheckBox.checked){
   //     console.log("checkk!!!");
   //
   //     for (let i = 0; i < $checkBoxs.length; i++) {
   //         $checkBoxs[i].addEventListener('click');
   //     }
   //
   // }else{
   //     console.log("enchecked!!!");
   // }
   // })

    $allCheckBox.addEventListener('change',function (){
        let isChecked = $allCheckBox.checked;
        $checkBoxs.forEach(function (checkBox){
            checkBox.checked = isChecked;
        })
    })

    let debateDropBtn = document.querySelector('#drop-btn');

    debateDropBtn.addEventListener('click',function (){


        // let value = $checkBoxs.val();
        // console.log("## checkBox = " + value);
        // fetch(`/debate/drop/${debateId}`, method='POST')
        //     .then(resp => resp.text())
    })





}


