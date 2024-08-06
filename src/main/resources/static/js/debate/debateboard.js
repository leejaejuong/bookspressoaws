// 신고하기 모달창
{
    let $modals = document.querySelectorAll('.board-object-btn');
    let $modalBtnList = document.querySelectorAll('.modal-total-box');

    console.log(" 모달탈 클릭")

    $modals.forEach(modal => {
        modal.addEventListener('click', function () {
            let $modalBtn = this.closest('.board-object-user-btn')
                .querySelector('.modal-total-box');
            $modalBtn.classList.remove('none');
        });
    });

    document.body.addEventListener('click', function (e) {
        let target = e.target;
        console.log(target)
        if (target.classList.contains('junjun-img')) {
            return;
        }

        $modalBtnList.forEach(btn => {
            btn.classList.add('none');
        });
    });

}
//버튼처리
{
    let $button=document.querySelector('.aside-button')
    $button.addEventListener('click',function(){
        location.href=`/debate/write`;
    });
}