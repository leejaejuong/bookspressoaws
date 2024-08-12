let $idForm = document.querySelector('#idForm');
let $pwForm =document.querySelector('#pwForm');
let loginBtn = document.querySelector('#loginBtn');
let $loginForm = document.querySelector('#login-form');
{

    loginBtn.addEventListener('click', function () {
        let loginId = $idForm.value;
        let password = $pwForm.value;
        // 단순 값이 들어오면 - 값이 널이 아니라면 submit 실행
        console.log("id : " + $idForm.value);
        console.log("pw : " + $pwForm.value);
        // if ($idForm.value&&$pwForm.value){
        //     console.log("ture");
        //     $loginForm.submit();
        // }else {
        //     console.log("false");
        //     // failedLoginModal();
        //     // 로그인 실패 모달 출력
        //     // continue; 반복문에서만 사용가능
        //
        // }

        fetch(`/login/findMemberId/${loginId}/${password}`, {method: 'POST'})
            .then(resp => resp.text())
            .then(text => {
                if (text == "true") {
                    console.log("로그인 성공!!!");
                    $loginForm.submit();
                } else {
                    console.log("로그인 실패!!!");
                    failedLoginModal();
                }
            })


    })


// 로그인 실패 모달 창 실행 함수
    {
        function failedLoginModal() {
            let $closeBtn = document.querySelector('#close-modal_btn');
            let $failModal = document.querySelector('.modal-layered');

            $failModal.style.display = 'block';

            $closeBtn.addEventListener('click', () => {
                // $failModal.classList.add("off");
                $failModal.style.display = 'none';

            })
        }

    }
}