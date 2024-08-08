const mapContainer = document.getElementById('library_map')
let mapOptions = {
    center : new kakao.maps.LatLng(37.657523763838014, 127.06180348717965),
    level : 3
};

let map = new kakao.maps.Map(mapContainer, mapOptions);

var markerPosition = new kakao.maps.LatLng(37.657523763838014, 127.06180348717965);

var marker = new kakao.maps.Marker({
    position: markerPosition
});

marker.setMap(map);