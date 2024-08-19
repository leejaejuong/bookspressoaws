function execCmd(command, value = null) {
    if (command === "createLink") {
        const url = prompt("Enter the link URL");
        if (url) {
            document.execCommand(command, false, url);
        }
    } else {
        document.execCommand(command, false, value);
    }
}

let uploadedImage = "";

function insertImage(event) {
    const input = event.target;
    const file = input.files[0];
    const reader = new FileReader();

    reader.onload = function (e) {
        uploadedImage = e.target.result; // 업로드된 이미지 데이터 URL 저장

        // 이미지를 에디터에 삽입
        const imgElement = document.createElement('img');
        imgElement.src = uploadedImage;
        imgElement.style.maxWidth = '100%'; // 이미지가 에디터 너비를 넘지 않도록 설정
        imgElement.style.height = 'auto'; // 이미지 높이를 자동으로 조정
        document.getElementById('editor').appendChild(imgElement);

        input.value = ""; // 파일 인풋 초기화
    };
    reader.readAsDataURL(file);
}

function savePost() {
    const title = document.getElementById("title").value;
    const editor = document.getElementById("editor");
    const content = editor.innerHTML;

    // 이미지를 저장하지 않고 게시글만 저장
    const postContent = content.replace(/<img[^>]*>/g, ""); // 이미지 태그 제거

    const post = {
        title,
        content: postContent, // 이미지가 제거된 내용 저장
    };

    let posts = JSON.parse(localStorage.getItem("posts")) || [];
    posts.push(post);
    localStorage.setItem("posts", JSON.stringify(posts));

    window.location.href = "/PostMain/list.html"; // 리다이렉션 경로 확인
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("imageInput").addEventListener("change", insertImage);
});



//content DB 입력 처리 우리 DB 에서 OPINION 칼럼
{

    let $subminbtn=document.querySelector('.gather-create-butten-dv1')
   $subminbtn.addEventListener("click", ()=>{
    console.log(document.getElementById('opinion-hidden').value= document.querySelector('.write-content-text').innerHTML);
        document.getElementById('submitbtn').submit();
    });
}