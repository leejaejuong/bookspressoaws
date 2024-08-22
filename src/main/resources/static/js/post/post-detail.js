// 포스트 댓글
{
    let $addComment = document.querySelector('.comment_btn');
    let commentId = document.querySelector()

    $addComment.addEventListener('click' , function (){
       let postComment = document.querySelector('.comment_textarea').value;
       let postId = document.querySelector('.book_container');

       if(postComment === ''){
           alert("댓글을 작성해주세요");
       }else{
           let commentObj = {
               postComment:postComment
           };
           addComment(postId, commentObj, function (){
               addcommentList(postId, commentList);
           })
       }
    });
}

// 수정삭제
let $commntWrap=document.querySelector('.comment_list');
$commntWrap.addEventListener('click',function (e){
    if(e.target.classList.contains('more-img')){
        let $btnBox = e.target.closest('.board-object-user-btn')
            .querySelector('.modal-total-box');
        $btnBox.classList.remove('none');

    }
});
document.body.addEventListener('click', function (e) {
    if (e.target.classList.contains('more-img')) {
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
        let $commentcontent = e.target.closest('.review_info_wrap').querySelector('.review_content');
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
        let commentId =e.target.closest('.review_info_wrap').dataset.id;
        let bookComment=e.target.closest('.review_info_wrap').querySelector('.modify-contnet').value;
        let commentObj={
            bookComment:bookComment
        }
        modifyComment(commentId,commentObj,function (){
            addcommentList(postId,commentList);
        });
    }else if(clsList.contains('modal-modelete')){
        //삭제버튼
        let commentId =e.target.closest('.review_info_wrap').dataset.id;
        removeComment(commentId,function(){
            addcommentList(isbn13,commentList);
        });

    }
});



// 코멘트 불러오기
function commentList(obj) {
    let tags = ''
    obj.forEach(comment => {
        tags += `
     <div class="review_info_wrap" data-id="${comment.commentId}">
                        <img class="profile" th:src="@{/img/search/profile.png}" alt="">
                        <div class="wrap" >
                            <div class="review_nickname">${comment.nickname}</div>
                            <div class="review_date">${comment.createDate}</div>
                            <div class="review_content">${comment.commentContent}</div>

                        </div>`;
        if(comment.memberId == sessionMemberId) {
            tags += `
                        <div  class="board-object-user-btn">
                            <div class="board-object-btn">
                                <img class="junjun-img" src="/img/junjun.png"/>
                            </div>
                            <div class="modal-total-box none">
                                <div class="modal-in-box">
                                    <button type="button" class="modal-modify">수 &nbsp; 정</button>
                                    <button type="button" class="modal-modelete"> 삭 &nbsp; 제</button>
                                </div>

                            </div>
                        </div>
                            `}
        tags +=`
                    </div>
                            `;
    });

    document.querySelector('.comment_textarea').innerHTML = tags;
}

//     api 통신
function addcommentList(postId, callback) {
    fetch(`/post/detail/${postId}`, {
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

function addComment(postId,commentObj,callback) {
    fetch(`/post/detail/${postId}`, {
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
function modifyComment(commentId,commentObj,callback) {
    fetch(`/post/detail/${commentId}`, {
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
function removeComment(commentId,callback){
    fetch(`/post/detail/${commentId}`,{
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