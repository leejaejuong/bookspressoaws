{ // 글작성 제목 글자수 처리
    const $postTitleInput = document.querySelector('#postTitle');

    $postTitleInput.addEventListener('keyup', function () {
       document.querySelector('.title-count').innerText = this.value.length;
    });
}

