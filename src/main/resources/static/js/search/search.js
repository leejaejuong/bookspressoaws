//버튼처리
{//검색처리
    let $searchText = document.querySelector('.saerch-text');
    $searchText.addEventListener('keydown', function (e) {
        let list = '';
        if (e.key === 'Enter') {
            getList($searchText.value, showBookList)


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
      <div class="modal-text-img-box"><img class="book-img-box" src="${comment.cover}" alt="${comment.title}"></div>
      <div class="modal-comtent-box">
                     <div class="modal-text-title">${comment.title}</div>
                    <div class="modal-text-author">작가 : ${comment.author}</div>
                    <div class="modal-text-content">${comment.description}</div>
                    <input type="hidden" data-id="${comment.isbn13}" class="isbn13">
      </div>
      <div class="modal-select">
        <button class="modal-select-btn">선택</button>
      </div>

    </div>

        `;
        });
        document.querySelector('.search_book').innerHTML = tags;
    }


    let $searchbookbox =document.querySelector('.search_book')
    $searchbookbox.addEventListener('click', function (e){
        let clsList=e.target.classList;
        if(clsList.contains('modal-select-btn')){
           let isbn13 = e.target.closest('.modal-text-content-in-box').querySelector('.isbn13').dataset.id;
           location.href=`/search/detail?isbn13=${isbn13}`;
        }



    })
}