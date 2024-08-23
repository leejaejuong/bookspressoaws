{// 진행중인토론
    document.addEventListener('DOMContentLoaded', () => {
        // ul 클래스 이름
        let $list = document.querySelector('#debate');
        if (!$list) {
            console.error("Element not found");
            return;
        }

        // 화면에 보이는 범위
        let $listScrollWidth = $list.scrollWidth;
        // 화면 밖까지의 전체 범위

        let $listClientWidth = $list.clientWidth;

        let startX = 0;
        let nowX = 0;
        let endX = 0;
        let listX = 0;
        // 현재 스크롤 위치

        const getClientX = (e) => {
            return e.touches ? e.touches[0].clientX : e.clientX;
        };

        const getTranslateX = () => {
            const transformMatrix = getComputedStyle($list).transform;
            if (transformMatrix !== 'none') {
                return parseInt(transformMatrix.split(/[^\-0-9]+/g)[5]);
            }
            return 0;
        };

        const setTranslateX = (x) => {
            $list.style.transform = `translateX(${x}px)`;
        };

        const onScrollStart = (e) => {
            startX = getClientX(e);
            listX = getTranslateX();
            window.addEventListener('mousemove', onScrollMove);
            window.addEventListener('touchmove', onScrollMove);
            window.addEventListener('mouseup', onScrollEnd);
            window.addEventListener('touchend', onScrollEnd);
        };


        const onScrollMove = (e) => {
            nowX = getClientX(e);
            let newX = listX + nowX - startX;
            if (newX > 0) {
                newX = 0;
            } else if (newX < (($listClientWidth - 800) * -1)) {
                newX = (($listClientWidth - 800) * -1);
            }
            setTranslateX(newX);
        };
        const onScrollEnd = (e) => {
            window.removeEventListener('mousemove', onScrollMove);
            window.removeEventListener('touchmove', onScrollMove);
            window.removeEventListener('mouseup', onScrollEnd);
            window.removeEventListener('touchend', onScrollEnd);
        };

        const onClick = (e) => {
            if (startX - endX !== 0) {
                e.preventDefault();
            }
        };

        const bindEvents = () => {
            $list.addEventListener('mousedown', onScrollStart);
            $list.addEventListener('touchstart', onScrollStart);
            $list.addEventListener('click', onClick);
        };

        bindEvents();
    });
    let $selectbtn =document.querySelectorAll('.book-button');
    $selectbtn.forEach( e=>{
        e.addEventListener('click',function (){
            let $detail=this.closest('.show-style')
                .querySelector('.book-button');
            let debateId=this.closest('.show-style')
                .querySelector('.debate-id').value;
            location.href=`/debate/board?debateId=${debateId}`
        });
    });
}
{// 오프라인
    document.addEventListener('DOMContentLoaded', () => {
        // ul 클래스 이름
        let $list = document.querySelector('#offline');
        if (!$list) {
            console.error("Element not found");
            return;
        }

        // 화면에 보이는 범위
        let $listScrollWidth = $list.scrollWidth;
        // 화면 밖까지의 전체 범위
        let $listClientWidth = $list.clientWidth;

        let startX = 0;
        let nowX = 0;
        let endX = 0;
        let listX = 0;
        // 현재 스크롤 위치

        const getClientX = (e) => {
            return e.touches ? e.touches[0].clientX : e.clientX;
        };

        const getTranslateX = () => {
            const transformMatrix = getComputedStyle($list).transform;
            if (transformMatrix !== 'none') {
                return parseInt(transformMatrix.split(/[^\-0-9]+/g)[5]);
            }
            return 0;
        };

        const setTranslateX = (x) => {
            $list.style.transform = `translateX(${x}px)`;
        };

        const onScrollStart = (e) => {
            startX = getClientX(e);
            listX = getTranslateX();
            window.addEventListener('mousemove', onScrollMove);
            window.addEventListener('touchmove', onScrollMove);
            window.addEventListener('mouseup', onScrollEnd);
            window.addEventListener('touchend', onScrollEnd);
        };


        const onScrollMove = (e) => {
            nowX = getClientX(e);
            let newX = listX + nowX - startX;
            if (newX > 0) {
                newX = 0;
            } else if (newX < (($listClientWidth - 800) * -1)) {
                newX = (($listClientWidth - 800) * -1);
            }
            setTranslateX(newX);
        };
        const onScrollEnd = (e) => {
            window.removeEventListener('mousemove', onScrollMove);
            window.removeEventListener('touchmove', onScrollMove);
            window.removeEventListener('mouseup', onScrollEnd);
            window.removeEventListener('touchend', onScrollEnd);
        };

        const onClick = (e) => {
            if (startX - endX !== 0) {
                e.preventDefault();
            }
        };

        const bindEvents = () => {
            $list.addEventListener('mousedown', onScrollStart);
            $list.addEventListener('touchstart', onScrollStart);
            $list.addEventListener('click', onClick);
        };

        bindEvents();
    });
    //자세히보기 버튼처리
    let $selectbtn =document.querySelectorAll('.book-button-off');
       $selectbtn.forEach( e=>{
           e.addEventListener('click',function (){
              let $detail=this.closest('.show-style')
                  .querySelector('.book-button-off');
              let debateId=this.closest('.show-style')
                  .querySelector('.debate-id-off').value;
               location.href=`/debate/board?debateId=${debateId}`
           });
       });
}
{ //포스트
    document.addEventListener('DOMContentLoaded', () => {
        // ul 클래스 이름
        let $list = document.querySelector('#post');
        if (!$list) {
            console.error("Element not found");
            return;
        }

        // 화면에 보이는 범위
        let $listScrollWidth = $list.scrollWidth;
        // 화면 밖까지의 전체 범위
        let $listClientWidth = $list.clientWidth;

        let startX = 0;
        let nowX = 0;
        let endX = 0;
        let listX = 0;
        // 현재 스크롤 위치

        const getClientX = (e) => {
            return e.touches ? e.touches[0].clientX : e.clientX;
        };

        const getTranslateX = () => {
            const transformMatrix = getComputedStyle($list).transform;
            if (transformMatrix !== 'none') {
                return parseInt(transformMatrix.split(/[^\-0-9]+/g)[5]);
            }
            return 0;
        };

        const setTranslateX = (x) => {
            $list.style.transform = `translateX(${x}px)`;
        };

        const onScrollStart = (e) => {
            startX = getClientX(e);
            listX = getTranslateX();
            window.addEventListener('mousemove', onScrollMove);
            window.addEventListener('touchmove', onScrollMove);
            window.addEventListener('mouseup', onScrollEnd);
            window.addEventListener('touchend', onScrollEnd);
        };


        const onScrollMove = (e) => {
            nowX = getClientX(e);
            let newX = listX + nowX - startX;
            if (newX > 0) {
                newX = 0;
            } else if (newX < (($listClientWidth - 800) * -1)) {
                newX = (($listClientWidth - 800) * -1);
            }
            setTranslateX(newX);
        };
        const onScrollEnd = (e) => {
            window.removeEventListener('mousemove', onScrollMove);
            window.removeEventListener('touchmove', onScrollMove);
            window.removeEventListener('mouseup', onScrollEnd);
            window.removeEventListener('touchend', onScrollEnd);
        };

        const onClick = (e) => {
            if (startX - endX !== 0) {
                e.preventDefault();
            }
        };

        const bindEvents = () => {
            $list.addEventListener('mousedown', onScrollStart);
            $list.addEventListener('touchstart', onScrollStart);
            $list.addEventListener('click', onClick);
        };

        bindEvents();
    });
    let $selectbtn =document.querySelectorAll('.book-button-post');
    $selectbtn.forEach( e=>{
        e.addEventListener('click',function (){
            let postId=this.closest('.manpage-debate-object-box')
                .querySelector('.post-object-title').dataset.id;
            location.href=`/post/detail?postId=${postId}`

        });
    });
}
{
    const swiper1 = new Swiper("#book", {
        // Optional parameters
        direction: "horizontal",
        loop: true,
        slidesPerView: 6,
        spaceBetween: 50,


    });
}






