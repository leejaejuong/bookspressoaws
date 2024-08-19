{   // 모달창 처리
    const $selectBookSec = document.querySelector('.select-book-sec');
    const $closeBtn = document.querySelector('#search-box__close-btn');
    const $modal =document.querySelector('#modal');
    const $searchInput = document.querySelector('#search-box__search-input');

    // 책 선택 누르면 모달창 on
    $selectBookSec.addEventListener('click', function () {
        // console.log('click')
        modalOnOff(true);
        searchResultReset();
    });

    // 닫기 버튼 누르면 모달창 off
    $closeBtn.addEventListener('click', function () {
        modalOnOff(false);
        searchResultReset();
    });

    // 모달 배경 누르면 모달창 off
    $modal.addEventListener('click', function (e) {
       if(e.target.id === 'modal') {
           modalOnOff(false);
           searchResultReset();
       }
    });

    // 검색 input 엔터 처리
    $searchInput.addEventListener('keyup', function (e, ) {
        e.preventDefault();
        e.stopPropagation();

        if(e.key === 'Enter') {
            // console.log('엔터!');
            getBookSearchList(this.value, displayBookList);
        }
    });
}

/**
 * 책 검색 후 나타난 리스트 중 하나를 선택하면 해당 책 정보를 화면에 뿌리는 함수<br>
 * form내부에 있는 input:hidden에 isbn을 삽입한다.
 *
 * @param {HTMLElement} target - 선택 버튼, JS에서 리스트를 만들어 뿌릴때 onclick으로 처리한다.
 */
function selectBook(target) {
    // console.log(target)
    const $item = target.closest('.modal__item');

    const isbn = target.dataset.isbn
    const imgSrc = $item.querySelector('.item__img-box > img').getAttribute('src');
    const title = $item.querySelector('.item__title').innerText;
    const author = $item.querySelector('.item__author').innerText;
    const content = $item.querySelector('.item__content').innerText;

    document.querySelector('.select-book__book-img').setAttribute('src', imgSrc);
    document.querySelector('.select-book__book-title').innerText=title;
    document.querySelector('.select-book__book-author').innerText=author;
    document.querySelector('.select-book__book-content').innerText=content;
    document.querySelector('#isbn').value = isbn.trim();


    document.querySelector('.select-book--select').classList.add('none');
    document.querySelector('.select-book--selected').classList.remove('none');
    modalOnOff(false);
    searchResultReset();
}


/**
 * 모달창에 책 리스트를 뿌려주는 함수
 *
 * @param {Array} list - 통신을 통해 받아온 Book리스트
 */
function displayBookList(list) {
    let html = '';

    // console.log(list)

    list.forEach(book => {
        html += `
        <li class="modal__item">
            <div class="item__img-box">
                <img src="${book.cover}" alt="">
            </div>
            <div class="item__text-box">
                <div class="item__title">${book.title}</div>
                <div class="item__author">${book.author}</div>
                <div class="item__content">${book.description}</div>
            </div>
            <div class="item__select-btn-box">
                <button type="button" onclick="selectBook(this)" data-isbn="${book.isbn13}">선택</button>
            </div>
        </li>
        `
    })

    const $modalList = document.querySelector('.modal__list');
    $modalList.innerHTML = html;
}

/**
 * 책 검색 결과 모달창 리셋 함수 <br>
 * 검색어 입력하는 input 칸과 검색 결과 리스트 제거
 */
function searchResultReset() {
    const $searchInput = document.querySelector('#search-box__search-input');
    const $modalList = document.querySelector('.modal__list');
    $modalList.innerHTML = '';
    $searchInput.value = '';
}

/**
 * 모달창 on/off 처리 함수
 * @param {boolean} isOn - true는 on, false는 off
 */
function modalOnOff(isOn) {
    const $modal = document.querySelector('#modal');
    const $modalBox = document.querySelector('.modal__box');
    // console.log($modal)
    // console.log($modalBox)
    if(isOn) {
        $modal.classList.remove('none')
        $modalBox.classList.remove('none')
        document.body.style.overflow = 'hidden';
        return;
    }

    $modal.classList.add('none')
    $modalBox.classList.add('none')
    document.body.style.overflow = 'auto';
}

/**
 * 키워드로 검색하여 책 리스트를 받아오는 함수. <br>
 * 모듈화 해야할 수도 있음
 *
 * @param {string} keyword  - 검색어
 * @param {function} callback - 통신 성공시 실행할 함수(매개변수로 리스트를 받음)
 */
function getBookSearchList(keyword, callback){
    fetch(`/debate/inpos/${keyword}`, {
        method : 'GET'
    }).then(resp => {
        if (resp.ok) { return resp.json(); }
        throw new Error('책 검색 통신 오류!');
    }).then(list => {
        if (callback) {
            callback(list);
        }
    }).catch(console.error)
}







