// const mapContainer = document.getElementById('library_map')
// let mapOptions = {
//     center: new kakao.maps.LatLng(37.5516036, 127.0041767),
//     level: 3
// };
//
// let map = new kakao.maps.Map(mapContainer, mapOptions);

var mapContainer = document.getElementById('library_map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.5663245, 126.977752), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다
var markerPosition  = new kakao.maps.LatLng(37.5663245, 126.977752);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null)
let $libmap = document.querySelector('.lib_search_result');
$libmap.addEventListener('click', function (e) {

    if (e.target.classList.contains('lib_name')) {
        let lat = e.target.closest('.library_list').querySelector('.list_title').dataset.lat;
        let lng = e.target.closest('.library_list').querySelector('.list_title').dataset.lng;
        console.log(lat + lng);
        makeMap(lat, lng);
    }
});

function makeMap(lat, lng) {
    var mapContainer = document.getElementById('library_map'),
        mapOption = {
            center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// 마커가 표시될 위치입니다
    var markerPosition = new kakao.maps.LatLng(lat, lng);

// 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });

// 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map)

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);
}

const swiper = new Swiper("#debate", {
    // Optional parameters
    direction: "horizontal",
    loop: true,
    slidesPerView: 4,
    spaceBetween: 50,

});


//도서관 처리
{
    let $searchbtn = document.querySelector('.search_btn');



    $searchbtn.addEventListener('click', function () {
        let libname = document.querySelector('.input_lib_name').value;
        console.log(libname)
        addLibList(libname, libList);
    });

    let $inputLibName = document.querySelector('.input_lib_name')

    $inputLibName.addEventListener('keydown', function (e) {

        if(e.code === 'Enter') {
            $searchbtn.click();
        }
    })


    function addLibList(libname, callback) {
        fetch(`/search/details/${libname}`, {
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

    function libList(obj) {
        let tags = ''
        obj.forEach(comment => {
            tags += `
             <div class="library_list">
                                <div class="list_info_wrap">
                                
                                    <div class="list_title" data-lat="${comment.latitude}" data-lng="${comment.longitude}">
                                        <div class="lib_name">${comment.libname}</div>
                                    </div>
                                     
                                    <div class="ul_wrap">                                
                                        <ul class="list_content_detail">
                                            <!-- 이용시간 -->
                                            <li class="detail_li"> 휴관일 : ${comment.closed}</li>
                                       
                                            <!-- 전화번호 -->
                                            <li  class="lib_phone">전화번호 : ${comment.tel}</li>
                                            <!-- 홈페이지 -->
                                            <a href="${comment.homepage}" target="_blank" class="detail_li">홈펭지 : 방문 하기 </a>
                                            <!-- 주소 -->
                                            <li class="detail_li"> 주소 : ${comment.address}</li>
                                        </ul>
                                    </div>
                                  
                                </div>
                    </div>

        `;

        });

        document.querySelector('.lib_search_result').innerHTML = tags;
    }
}
// 책댓글
{
    let $addcommentbtn = document.querySelector('.submit_btn');
    let isbn13=document.querySelector('.book_info').dataset.isbn13;

$addcommentbtn.addEventListener('click',function (){
   let bookComment= document.querySelector('.comment-write-box').value;

    if(bookComment===''){
        alert("댓글을 작성해주세요");
    }else{
        let commentObj={
            bookComment:bookComment
        };
        console.log(isbn13);
        addComment(isbn13,commentObj,function (){
            addcommentList(isbn13,commentList);
        });
    }

});
// 수정삭제
  let $commntWrap=document.querySelector('.review_content_wrap');
    $commntWrap.addEventListener('click',function (e){
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
              addcommentList(isbn13,commentList);
          });
      }else if(clsList.contains('modal-modelete')){
          //삭제버튼
          let commentId =e.target.closest('.review_info_wrap').dataset.id;
          removeComment(commentId,function(){
              addcommentList(isbn13,commentList);
      });

      }
   });

addcommentList(isbn13,commentList);

    // 코멘트 불러오기
    function commentList(obj) {
        let tags = ''
        obj.forEach(comment => {
            tags += `
     <div class="review_info_wrap" data-id="${comment.commentId}">
                        <img class="profile" th:src="@{/img/search/profile.png}" alt="">
                        <div class="wrap" >
                            <div class="review_nickname">${comment.nickname}</div>
                            <div class="review_date">${comment.bookDate}</div>
                            <div class="review_content">${comment.bookComment}</div>

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

        document.querySelector('.review_content_wrap').innerHTML = tags;
    }

//     api 통신
    function addcommentList(isbn13, callback) {
        fetch(`/searchs/details/${isbn13}`, {
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
    function addComment(isbn13,commentObj,callback) {
        fetch(`/searchs/details/${isbn13}`, {
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
        fetch(`/searchs/details/${commentId}`, {
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
    fetch(`/searchs/details/${commentId}`,{
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