let $allCheckBox = document.querySelector("#allCheck");
let $checkBoxs = document.querySelectorAll(".check-boxes");
let $debateDropBtn = document.querySelector('#drop-btn');
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
    $allCheckBox.addEventListener('change',function (){
        let isChecked = $allCheckBox.checked;
        $checkBoxs.forEach(function (checkBox){
            checkBox.checked = isChecked;
        })
    })


}



    // let dropDebateLists = [];

    // $checkBoxs.forEach(function () {
    //     if (checkbox.checked){
    //         dropDebateLists.push(checkbox.value);
    //     }
    // })





    // debateDropBtn.addEventListener('click',function (){
    //
    //     // let value = $checkBoxs.val();
    //     // console.log("## checkBox = " + value);
    //     // fetch(`/debate/drop/${debateId}`, method='POST')
    //     //     .then(resp => resp.text())
    // })

// let paramString =
// let params = URLSearchParams();
// dropDebateLists.forEach((debateId)=>{
//     params.append("debateId", debateId);
// });
// console.log("params = " + params);

{
    $debateDropBtn.addEventListener('click',() =>{
        let dropDebateLists = [];

        for (let i = 0; i < $checkBoxs.length; i++) {
            if ($checkBoxs[i].checked){
                dropDebateLists.push($checkBoxs[i].value);
                console.log("삭제 할 것 " + $checkBoxs[i].value);
            }else{
                console.log("no drop");
            }
        }
        console.log("dropDebateLists = " + dropDebateLists);



        fetch(`/admin/debate/drop/${dropDebateLists}`,{method : "POST"
        }).then(resp => {
            if (!resp.ok) {
                throw new Error('응답 오류');
            }
            return resp;
        }).catch(error => {
            console.error("문제 발생 : ", error)
        });

        location.replace("admin/debate/onGoing");

    })


}



