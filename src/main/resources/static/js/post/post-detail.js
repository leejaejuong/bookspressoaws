// 포스트 댓글
{
    let $addComment = document.querySelector('.comment_btn');
    let postId = document.querySelector('.flex_container').dataset.id
    console.log(postId)

    $addComment.addEventListener('click' , function (){
        let commentContent = document.querySelector('.comment_textarea').value;
        console.log(commentContent)
        if(commentContent === ''){
           alert("댓글을 작성해주세요");
       }else{
           let commentObj = {
               commentContent:commentContent
           };
           addComment(postId, commentObj, function (){
               addcommentList(postId, commentList);
           })
       }
    });
    addcommentList(postId, commentList);

// 수정삭제
    let $commntWrap=document.querySelector('.ul_comment_list');
    $commntWrap.addEventListener('click',function (e){
        if(e.target.classList.contains('board-object-btn')){
            console.log("클릭")
            let $btnBox = e.target.closest('.board-object-user-btn')
                .querySelector('.modal-total-box');
            $btnBox.classList.remove('none');

        }
    });
    document.body.addEventListener('click', function (e) {
        if (e.target.classList.contains('board-object-btn')) {
            return;
        }
        let $modalBtnList = document.querySelectorAll('.modal-total-box');
        $modalBtnList.forEach(btn => {
            btn.classList.add('none');
        });
    });
    $commntWrap.addEventListener('click',function (e){

        let clsList =e.target.classList;
        if(clsList.contains('modal-modify')) {
            //수정버튼
            let $commentContent = e.target.closest('.li_comment_list').querySelector('.post_comment');
            let $modifyBox= document.createElement('div');
            $modifyBox.classList.add('modify-box');
            $modifyBox.innerHTML=`
                <div class="modify-total-box">
           <textarea class="modify-contnet">${$commentContent.innerText}</textarea>
           <button type="button" class="modify-content-btn">수정 완료</button>
           </div>
           `;
            $commentContent.replaceWith($modifyBox);
        }else if(clsList.contains('modify-content-btn')){
            let commentId =e.target.closest('.li_comment_list').dataset.id;
            let commentContent=e.target.closest('.li_comment_list').querySelector('.modify-contnet').value;
            let commentObj={
                commentContent:commentContent
            }
            modifyComment(commentId,commentObj,function (){
                addcommentList(postId,commentList);
            });
        }else if(clsList.contains('modal-modelete')){
            //삭제버튼
            let commentId =e.target.closest('.li_comment_list').dataset.id;
            removeComment(commentId,function(){
                addcommentList(postId,commentList);
            });
        }
    });
    addcommentList(postId,commentList);




// 코멘트 불러오기
function commentList(obj) {
    let tags = ''
    obj.forEach(comment => {
        tags += `
            <li class="li_comment_list" data-id="${comment.commentId}">
               <div><!-- 사용자 이미지 --></div>
                   <div class="info">
                      <p class="nickname">${comment.nickname}</p>
                      <span class="date">${comment.createDate}</span>
                      <pre class="post_comment">${comment.commentContent}</pre>
                   </div>`;
                       if(comment.memberId == sessionMemberId) {
                                tags += `
                        <div style="cursor: pointer"  class="board-object-user-btn">
                            <div class="board-object-btn">
                                <img class="more-img"src="/img/more.png"/>
                            </div>
                            <div class="modal-total-box none">
                                <div class="modal-in-box">
                                    <button type="button" class="modal-modify">수 &nbsp; 정</button>
                                    <button type="button" class="modal-modelete"> 삭 &nbsp; 제</button>
                                </div>
                            </div>
                        </div>
                    </div>
                 </li>
               `}
    });
    document.querySelector('.ul_comment_list').innerHTML = tags;
}

//     api 통신
function addcommentList(postId, callback) {
    fetch(`/posts/details/${postId}`, {
        method: 'GET'
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp.json();
    }).then(obj => {
        callback(obj);
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });
}

// 댓글 추가
function addComment(postId,commentObj,callback) {
    fetch(`/posts/details/${postId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(commentObj)
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp;
    }).then(obj => {
        callback();
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });
}

// 댓글 수정
function modifyComment(commentId,commentObj,callback) {
    fetch(`/posts/details/${commentId}`, {
        method: 'PATCH',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(commentObj)
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp;
    }).then(obj => {
        callback();
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });
}

// 댓글 삭제
function removeComment(commentId,callback){
    fetch(`/posts/details/${commentId}`,{
        method:'DELETE'
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp;
    }).then(obj => {
        callback();
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });

}
}