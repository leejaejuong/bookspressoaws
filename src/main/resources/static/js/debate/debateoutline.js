{//모달창
    let $modal = document.querySelector('.book-modal');
    let $modalbtn = document.querySelector('.gather-create-book');
    let $modalbtnclose = document.querySelector('.book-modal-body-close');
    let $booksearchout = document.querySelector('.book-search-out');

    $modalbtn.addEventListener("click", () => {
        $modal.style.display = "flex";
        $booksearchout.style.display = "none";
    });
    $modalbtnclose.addEventListener("click", () => {
        $modal.style.display = "none";
    });


}
{ //버튼처리
    let $typeRemove = document.querySelector('.type-remove')
    $typeRemove.addEventListener("click", function () {
        location.href = `/debate/type`;
    });
}
{//글자수 세기
    let $textrea = document.querySelector('.title-box');
    let $textcount = document.querySelector('.title-count');

    $textrea.addEventListener('keyup', onkeyup)

    function onkeyup() {
        const inputText = $textrea.value;
        $textcount.innerText = inputText.length;
    }

}


{ //range 바
    //  날자 나타내는 ~ 표시 조절
    let $inds = document.querySelector('.pather-value-box');
    let $indt = document.querySelector('.pather-value-box2')
    let $slider = document.querySelector('.gather-group');
    let $sliderD = document.querySelector('.gather-group-d');
    $slider.addEventListener('change', () => {
        $inds.style.display = "flex";
    });
    $sliderD.addEventListener('change', () => {
        $indt.style.display = "flex";
    });


    let $output = document.querySelector('.gather-value');
    let $Datenow = document.querySelector('.gather-value-in')
    let $Datenew = document.querySelector('.gather-value-out')
    let $groupStartDate = document.querySelector('.groupStartDate');
    let $groupEndDate = document.querySelector('.groupEndDate');

    let nowDate = new Date();
    let startdate;
    //range 에다른 일수 계산
    $output.innerHTML = $slider.value;
    $slider.oninput = function () {
        //range 바에 따른 일수를 계산하여 반영한다
        $output.innerHTML = this.value;
        $groupStartDate.value = formatDate(nowDate);

        //현재 날자와 range의 값을 addDate에 넘겨 +계산을 한다
        $Datenew.innerHTML = formatDate(addDate(nowDate, parseInt(this.value)));
        $groupEndDate.value = formatDate(addDate(nowDate, parseInt(this.value)));
        startdate = addDate(nowDate, parseInt(this.value));
    }
    $Datenow.innerHTML = formatDate(nowDate);


    let $outputD = document.querySelector('.gather-value-d');
    let $DatenowD = document.querySelector('.gather-value-ind')
    let $DatenewD = document.querySelector('.gather-value-outd')
    let $debateStartDate = document.querySelector('.debateStartDate');
    let $debateEndDate = document.querySelector('.debateEndDate');
    $outputD.innerHTML = $sliderD.value;


    $sliderD.oninput = function () {
        $outputD.innerHTML = this.value;

        $DatenowD.innerHTML = formatDate(startdate);
        $debateStartDate.value = formatDate(startdate);
        $DatenewD.innerHTML = formatDate(addDate(startdate, this.value));
        $debateEndDate.value = formatDate(addDate(startdate, this.value));

    }

    function addDate(date, days) {
        let today = new Date(date);//

        let dates = today.setDate(today.getDate() + parseInt(days));
        return today;
    }

    function formatDate(date) {
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }
}
//책검색
{
    let $modalTextBox = document.querySelector('.modal-text-box')
    $modalTextBox.addEventListener('click', function (e) {
        if (e.target.classList.contains('modal-select-btn')) {

            let $closeBtn = document.querySelector('.book-modal-body-close');
            $closeBtn.click();
            document.querySelector('.book-search-in').style.display="flex";
            let $this = e.target;

            let $parent = $this.closest('.modal-text-content-in-box');
            // 사진부분
            let $imgTag = $parent.querySelector('.modal-text-img');
            let $inImgTag=document.querySelector('.book-search-in-img');
            let src = $imgTag.getAttribute("src");
                $inImgTag.setAttribute("src",src);

            //   타이틀
            let $titleTag = $parent.querySelector('.modal-text-title');
            let $intTitleTag=document.querySelector('.book-search-title-text');
            let title = $titleTag.innerText;
            $intTitleTag.innerText=title;

            // 작가
            let $authorTag = $parent.querySelector('.modal-text-author');
            let $inAuthorTag=document.querySelector('.book-search-author');
            let author = $authorTag.innerText;
            $inAuthorTag.innerText=author;
            // 소개글
            let $contentTag = $parent.querySelector('.modal-text-content');
            let $inContentTag=document.querySelector('.book-search-content');
            let content = $contentTag.innerText;
            $inContentTag.innerText=content;

            // 고유번호
            let $isbn13Tag=$parent.querySelector('.isbn13');
            let $inIsbn13Tag=document.querySelector('.book-search-isbn13');
            let $isbn13Hidden=document.querySelector('.gather-isbn13-hidden');
            let isbn13=$isbn13Tag.value;
            $inIsbn13Tag.value=isbn13;
            $isbn13Hidden.value=isbn13;

        }
    });


    let $searchText = document.querySelector('.modal-search-text');
    $searchText.addEventListener('keydown', function (e) {
        let list = '';
        if (e.key === 'Enter') {
            getList($searchText.value, showBookList);

        }
    });

    function getList(title, callback) {
        fetch(`/debate/inpos/${title}`, {
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

    function showBookList(obj) {

        let tags = ''
        obj.forEach(comment => {
            tags += `
           <div class="modal-text-content-in-box">
                <div class="modal-text-img-box"><img class="modal-text-img" src="${comment.cover}" alt="${comment.title}"></div>
                <div class="modal-comtent-box">
                    <div class="modal-text-title">${comment.title}</div>
                    <div class="modal-text-author">작가 : ${comment.author}</div>
                    <div class="modal-text-content">${comment.description}</div>
                    <input type="hidden" value="${comment.isbn13}" class="isbn13">
                </div>
                <div class="modal-select">
                <button class="modal-select-btn">선택</button>
               
                </div>
               
            </div>

        `;

        });

        document.querySelector('.modal-text-box').innerHTML = tags;

    }


}

// 글쓰기가 비어있을때
{
    let $nexttype = document.querySelector('.next');
    let $titleBox = document.querySelector('.title-box');
    let $contentBox = document.querySelector('.content-box');
    let $groupEndDate = document.querySelector('.groupStartDate');
    let $debateStartDate = document.querySelector('.debateStartDate');
    let $bookTotalBox=document.querySelector('.gather-create-book');
    let $contentErr = document.querySelector('.content-err');
    let $contentErr2 = document.querySelector('.content-err2');
    let $contentErr3 = document.querySelector('.content-err3');
    let $contentErr4 = document.querySelector('.content-err4');
    let $contentErr5 = document.querySelector('.content-err5');

    let isn13=$bookTotalBox.getAttribute("isbn13");

    $nexttype.addEventListener("click", () => {
        //타이틀 값검사
        if ($titleBox.value === '') {
            $titleBox.style.border = "1px solid #ff4d4f";
            $contentErr.style.display = "flex";
        } else {
            $titleBox.style.border = "1px solid #dee2e6";
            $contentErr.style.display = "none";
        }
        //컨텐트값검사
        if ($contentBox.value === '') {
            $contentBox.style.border = "1px solid #ff4d4f";
            $contentErr2.style.display = "flex";
        } else {
            $contentBox.style.border = "1px solid #dee2e6";
            $contentErr2.style.display = "none";
        }
        //날자검사
        if ($groupEndDate.value === '') {
            $contentErr3.style.display = "flex";
        } else {
            $contentErr3.style.display = "none";
        }
        //날자검사
        if ($debateStartDate.value === '') {
            $contentErr4.style.display = "flex";
        } else {
            $contentErr4.style.display = "none";
        }
        //책정보 검사
        if(isn13===''){
            $bookTotalBox.style.border = "1px solid #ff4d4f";
            $contentErr5.style.display="flex";
        }else{
            $bookTotalBox.style.border = "1px solid #dee2e6";
            $contentErr5.style.display="none";
        }

        if (!($titleBox.value === '' || $contentBox.value === '' ||
            $groupEndDate.value === '' || $debateStartDate.value === ''||
            isn13==='')) {
            document.getElementById('submitbtn').submit();
        }


    });

}
