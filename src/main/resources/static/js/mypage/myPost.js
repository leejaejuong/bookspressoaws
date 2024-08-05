{
    // 이미지 삽입
    let $fileInput = document.querySelector('#fileInput')

    $fileInput.addEventListener('change', function () {
        // // console.log('change')
        // console.dir(this)

        let files = this.files
        let file = files[0]

        let src = URL.createObjectURL(file)

        let $imgTags = document.querySelector('.post_banner_container')

        $imgTags.forEach(imgTag => {
            imgTag.setAttribute('src', src);
        })
    });
}