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


function insertImage(event) {
    let uploadedImage = "";
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

{
    document.getElementById("imageInput").addEventListener("change", insertImage);
    
    
    // 저장 버튼 이벤트 처리
    document.querySelector('#save-btn').addEventListener('click', function () {
        const title = document.getElementById("postTitle").value;
        const editor = document.getElementById("editor");
        const content = editor.innerHTML;

        // console.log(content)

        const $textarea = document.createElement('textarea');

        $textarea.setAttribute('name', 'postContent');
        $textarea.style.display='none'
        $textarea.innerText = content;

        const $form = document.forms[0];

        $form.appendChild($textarea);
        $form.submit();
    });
}















