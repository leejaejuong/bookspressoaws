let $allCheckBox = document.querySelector("#allCheck");
let $checkBoxs = document.querySelectorAll(".check-boxes");
let $memberDropBtn = document.querySelector('#member-drop-btn');


{
    $allCheckBox.addEventListener('change',function (){
        let isChecked = $allCheckBox.checked;
        $checkBoxs.forEach(function (checkBox){
            checkBox.checked = isChecked;
        })
    })
}


// 삭제 처리
{
    $memberDropBtn.addEventListener('click', () => {
        let dropMemberLists = [];

        for (let i = 0; i < $checkBoxs.length; i++) {
            if ($checkBoxs[i].checked) {
                dropMemberLists.push($checkBoxs[i].value);
                console.log("삭제 할 것 " + $checkBoxs[i].value);
            } else {
                console.log("no drop");
            }
        }
        console.log("dropMemberLists = " + dropMemberLists);


        fetch(`/admin/member/drop/${dropMemberLists}`, {
            method: "POST"
        }).then(resp => {
            if (!resp.ok) {
                throw new Error('응답 오류');
            }
            return resp;
        }).catch(error => {
            console.error("문제 발생 : ", error)
        });

        location.reload();

        //No static resource admin/member/admin/member/allList.
        //잘못된 경로 못찾겠음
        // location.replace 경로가 잘못된 것으로 얘상됨
    });
}