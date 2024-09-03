import * as comm from '../modul/comment.js';


// 신고하기 모달창
{
    let $modals = document.querySelectorAll('.board-object-btn');
    let $modalBtnList = document.querySelectorAll('.modal-total-box');
    $modals.forEach(modal => {
        modal.addEventListener('click', function () {
            let $modalBtn = this.closest('.board-object-user-btn')
                .querySelector('.modal-total-box');
            $modalBtn.classList.remove('none');
        });
    });

    document.body.addEventListener('click', function (e) {
        let target = e.target;
        // console.log(target)
        if (target.classList.contains('junjun-img')) {
            return;
        }

        $modalBtnList.forEach(btn => {
            btn.classList.add('none');
        });
    });

}
//버튼처리
{   //write 연결
    let $button = document.querySelector('.aside-button')
    let debateId = document.querySelector('.debateId-value').value;

    $button.addEventListener('click', function () {
        location.href = `/debate/write?debateId=${debateId}`;
    });
    //수정삭제
    let $modifybtn = document.querySelector('.modal-modify');
    let $delectbtn = document.querySelector('.modal-modelete');
    let noticeId = document.querySelector(".hidden-noticeId").value;

    $modifybtn.addEventListener('click', function(){
        location.href=`/debate/modify?debateId=${debateId}&noticeId=${noticeId}`
    });
    $delectbtn.addEventListener('click',function (){
        location.href=`/debate/remove?debateId=${debateId}&noticeId=${noticeId}`
    })
}
//댓글처리
{
    let noticeId = document.querySelector(".hidden-noticeId").value;
    let $replyBtn =document.querySelector('.comment-btn-box');
    //수정 삭제 버튼처리
    let $commentWrap = document.querySelector('.comment-total-box');
        $commentWrap.addEventListener('click',function (e){
           if(e.target.classList.contains('junjun-img')){
               let $btnBox = e.target.closest('.board-object-user-btn')
                   .querySelector('.modal-total-box');
               $btnBox.classList.remove('none');

           }
        });
    document.body.addEventListener('click', function (e) {
        if (e.target.classList.contains('junjun-img')) {
            return;
        }
        let $modalBtnList = document.querySelectorAll('.modal-total-box');
        $modalBtnList.forEach(btn => {
            btn.classList.add('none');
        });
    });


    $commentWrap.addEventListener('click',function (e){
        let clsList =e.target.classList;
      if(clsList.contains('modal-modify')){
          // 수정버튼
          let $commentcontent = e.target.closest('.board-object-comment').querySelector('.content-total-box');
           let $modifyBox= document.createElement('div');
           $modifyBox.classList.add('modify-box');
           $modifyBox.innerHTML=`
                <div class="modify-total-box">
           <textarea class="modify-contnet">${$commentcontent.innerText}</textarea>
           <button type="button" class="modify-content-btn">수정 완료</button>
           </div>
           `;
           $commentcontent.replaceWith($modifyBox);
      }else if(clsList.contains('modify-content-btn')){
          let commentId=e.target.closest('.board-object-comment-inop-box').dataset.id;
          let debateComment = e.target.closest('.board-object-comment-inop-box').querySelector('.modify-contnet').value;
          let commentObj={
              debateComment :debateComment
          }
          comm.modifyComment(commentId,commentObj,function (){
              comm.getComment(noticeId,displayCommentList);
          })
      } else if(clsList.contains('modal-modelete')){
          // 삭제버튼
          let commentId=e.target.closest('.board-object-comment-inop-box').dataset.id;
          comm.removeComment(commentId,function (){
              comm.getComment(noticeId,displayCommentList);
          })

      }
    });



    $replyBtn.addEventListener('click',function (){
        let debateComment =document.querySelector('.comment-text').value;
        if(debateComment  === ''){

            alert("댓글을 작성해주세요");
        }else{
          let commentObj={
              debateComment :debateComment
          };
          comm.addComment(noticeId,commentObj,function (){
              comm.getComment(noticeId,displayCommentList);
          });
        }

    })


     comm.getComment(noticeId,displayCommentList);



    function displayCommentList(obj) {
        let tags = ''
        obj.forEach(comment => {
            tags += `
              <div class="board-object-comment">
            <div class="board-object-comment-inop-box" data-id="${comment.commentId}">
                <div class="board-object-user-comment">
                    <div><img class="debate-img" src="/img/user.png"/></div>
                    <div class="board-object-user-inpo">
                        <div class="board-object-user-name" >${comment.nickname}</div>
                        <div class="board-object-user-date" >${comment.commentDate}</div>
                    </div>`;


                         if(comment.memberId == sessionMemberId){
                        tags +=`
                 <div class="board-object-user-btn">
                        <div class="board-object-btn">
                            <img class="junjun-img" src="/img/junjun.png"/>
                        </div>
                        <div class="modal-total-box none">
                            <div class="modal-in-box">
                                <button class="modal-modify">수 &nbsp; 정</button>
                                <button class="modal-modelete"> 삭 &nbsp; 제</button>
                            </div>
                           
                        </div>`;}


            tags+=` </div>
                </div>
                <div class="content-total-box-coment">${comment.debateComment}</div>
            </div>
        </div>

        `;

        });

        document.querySelector('.comment-total-box').innerHTML = tags;
    }


}