// 신고하기 모달창
{
    // let $modals = document.querySelectorAll('.board-object-btn');
    // let $modalBtnList = document.querySelectorAll('.modal-total-box');
    //
    // // console.log(" 모달탈 클릭")
    //
    // $modals.forEach(modal => {
    //     modal.addEventListener('click', function () {
    //         let $modalBtn = this.closest('.board-object-user-btn')
    //             .querySelector('.modal-total-box');
    //         $modalBtn.classList.remove('none');
    //     });
    // });
    //
    // document.body.addEventListener('click', function (e) {
    //     let target = e.target;
    //     // console.log(target)
    //     if (target.classList.contains('junjun-img')) {
    //         return;
    //     }
    //
    //     $modalBtnList.forEach(btn => {
    //         btn.classList.add('none');
    //     });
    // });

}
//버튼처리
{
    let $button = document.querySelector('.aside-button')
    let debateId = document.querySelector('.debateId-value').value;
    $button.addEventListener('click', function () {
        location.href = `/debate/write?debateId=${debateId}`;
    });
}
//댓글처리
{
    let $hiddenList = document.querySelectorAll(".hidden-noticeId");
    let noticeIdList = []
    $hiddenList.forEach($ele => {
        noticeIdList.push($ele.value);
    });

    console.log(noticeIdList)

    // let noticeId = document.querySelector(".hidden-noticeId").value;
    window.addEventListener('load', function () {
        // console.log(noticeId);
        // console.log("윈도우실행");

        // noticeIdList.forEach( (id, idx) => console.log(`${idx} :  ${id}`))
        noticeIdList.forEach( (id, idx) => getComment(id, idx, displayCommentList))
        // getcomment(noticeId, commentList)

    })


    function getComment(noticeId, idx, callback) {
        fetch(`/debate/boards/${noticeId}`, {
            method: 'GET'
        }).then(resp => {
            if (!resp.ok) {
                throw new Error('응답 오류');
            }
            return resp.json();
        }).then(obj => {
            // console.log(obj);
            callback(obj, idx);
        }).catch(error => {
            console.error("문제 발생 : ", error)
        });
    }

    function displayCommentList(obj, idx) {
        // console.log(obj);
        let tags = ''
        obj.forEach(comment => {
            tags += `
              <div class="board-object-comment">
            <div class="board-object-comment-inop-box">
                <div class="board-object-user-comment">
                    <div  class="board-object-img-box"><img class="debate-img" src="/img/user.png"/></div>
                    <div class="board-object-user-inpo">
                        <div class="board-object-user-name" >${comment.nickname}</div>
                        <div class="board-object-user-date" >${comment.commentDate}</div>
                    </div>
      
                </div>
                <div class="content-total-box-comment">${comment.debateComment}</div>
            </div>
        </div>

        `;

        });

        document.querySelectorAll('.comment-total-box')[idx].innerHTML = tags;
    }


}