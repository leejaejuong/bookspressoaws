

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