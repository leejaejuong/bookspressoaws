//댓글처리 모듈

export function getComment(noticeId, callback) {
    fetch(`/debate/boards/${noticeId}`, {
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

export function addComment(noticeId,commentObj,callback){
    fetch(`/debate/details/${noticeId}`,{
        method:'POST',
        headers:{
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(commentObj)
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
export function removeComment(noticeId,callback){
    fetch(`/debate/details/${noticeId}`,{
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
export function modifyComment(commentId,debateComment,callback){
    fetch(`/debate/details/${commentId}`,{
        method :'PATCH',
        headers :{ 'Content-Type' : 'application/json'},
        body :JSON.stringify(debateComment)
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