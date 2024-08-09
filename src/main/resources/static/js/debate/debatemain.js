//버튼처리
{let $mackeBtn = document.querySelector('.mack-button')

    $mackeBtn.addEventListener('click',function (){
        if(sessionStorage.getItem("memberId")==null){
            location.href=`/member/login`
        }
        location.href=`/debate/make`
    })
}