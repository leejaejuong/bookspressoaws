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
        const title = document.getElementById("postTitle");
        const editor = document.getElementById("editor");
        const content = editor.innerHTML;
        const isbn13=document.getElementById("isbn13");
        let $isbn13Mag=document.querySelector('.error-mag-isbn13');
        let $titleMag=document.querySelector('.error-mag-title');
        let $contenMag=document.querySelector('.error-mag-content');
        let $isbn13error=document.querySelector('.select-book-sec');
        let $titleeroor = document.querySelector('.write-title-text');
        let $contenteroor = document.querySelector('.write-content-text');

        // DB 무결성을 위한 값검사
        //책선택
        if(isbn13.value ===''){
            $isbn13error.style.border="1px solid #ff4d4f";
            $isbn13Mag.style.display="flex";
        }else{
            $isbn13error.style.border = "1px solid #dee2e6";
            $isbn13Mag.style.display = "none";
        }
        // 타이틀
        if(title.value ===''){
            $titleeroor.style.border="1px solid #ff4d4f";
            $titleMag.style.display="flex";
        }else{
            $titleeroor.style.border = "1px solid #dee2e6";
            $titleMag.style.display = "none";
        }


        const $textarea = document.createElement('textarea');

        $textarea.setAttribute('name', 'postContent');
        $textarea.style.display='none'
        $textarea.innerText = content;

        if($textarea.value ===''){
            $contenteroor.style.border="1px solid #ff4d4f";
            $contenMag.style.display="flex";
        }else{
            $contenteroor.style.border = "1px solid #dee2e6";
            $contenMag.style.display = "none";
        }

        if(!(isbn13.value ===''||title.value ===''||$textarea.value ==='')){
            const $form = document.forms[0];

            $form.appendChild($textarea);
            $form.submit();
        }

    });
}















