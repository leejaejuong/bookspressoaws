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
//댓글처리
{
let $noticeId = document.querySelector(".hidden-noticeId").value;
 window.addEventListener('load',function (){
     console.log($noticeId);
     console.log("윈도우실행");
     getcomment($noticeId,commentList)

 })







     function getcomment(noticeId, callback) {
        fetch(`/debate/boards/${noticeId}`, {
            method: 'GET'
        }).then(resp => {
            if (!resp.ok) {
                throw new Error('응답 오류');
            }
            return resp.json();
        }).then(obj => {
            console.log(obj);
            callback(obj);
        }).catch(error => {
            console.error("문제 발생 : ", error)
        });
    }

    function commentList(obj) {
        console.log(obj);
        let tags = ''
        obj.forEach(comment => {
            tags += `
     <div class="board-object-comment-inop-box">
                                <div class="board-object-user-comment">
                                    <div><img class="debate-img" src="/img/user.png"/></div>
                                    <div class="board-object-user-inpo">
                                        <div class="board-object-user-name" th:text="${comment.nickname}"></div>
                                        <div class="board-object-user-date" th:text="${comment.commentDate}"> 3 달전</div>
                                    </div>
                                    <div class="board-object-user-btn">
                                        <div class="board-object-btn">
                                            <img class="junjun-img" src="/img/junjun.png"/>
                                        </div>
                                        <div class="modal-total-box none">
                                            <div class="modal-in-box">
                                                <div class="modal-text1"><p>수 &nbsp; 정</p></div>
                                                <div class="modal-text1"><p> 삭 &nbsp; 제</p></div>
                                            </div>
                                            <div class="modal-text"> 신 &nbsp; 고</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="content-total-box" th:text="${comment.debateComment}">

                                </div>
                            </div>
        `;

        });

        document.querySelector('.board-object-comment').innerHTML = tags;

    }





}