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
    if (e.target.classList.contains('lib-btn')) {
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
    // let libname = document.querySelector('.input_lib_name').value;


    $searchbtn.addEventListener('click', function () {
        let libname = document.querySelector('.input_lib_name').value;
        console.log(libname)
        addLibList(libname, libList);
    });


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
             <button type="button" class="lib-btn">
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
                                </button>
                    </div>

        `;

        });

        document.querySelector('.lib_search_result').innerHTML = tags;
    }
}