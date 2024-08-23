// 소개글 수정
let originalText = '';
let editMode = (isEditing) => {
    let descriptionDiv = document.querySelector('.settings_profile_description');
    let textarea = document.querySelector('.edit_textarea');
    let editButton = document.querySelector('.profile_letter_button');
    let saveButton = document.querySelector('.button_save');
    let cancelButton = document.querySelector('.button_cancel');

    if (isEditing) {
        originalText = descriptionDiv.textContent;
        textarea.value = originalText;

        descriptionDiv.classList.add('hidden');
        textarea.classList.remove('hidden');
    } else {
        descriptionDiv.textContent = isEditing === false ? originalText : textarea.value;
        descriptionDiv.classList.remove('hidden');
        textarea.classList.add('hidden');
    }

    editButton.classList.toggle('hidden', isEditing);
    saveButton.classList.toggle('hidden', !isEditing);
    cancelButton.classList.toggle('hidden', !isEditing);
};

let showEditArea = () => editMode(true);
let saveDescription = () => editMode(null);
let cancelEdit = () => editMode(false);


{   // 자기소개 수정 처리
    let $saveBtn = document.querySelector('.button_save');
    let $editTextarea = document.querySelector('.edit_textarea');

    $saveBtn.addEventListener('click', function () {
        // console.log('click')
        let value = $editTextarea.value;
        console.log(value)
        let object = {introduce : value}

        fetch('/member-introduce', {
            method : 'PATCH',
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify(object)
        }).then(resp => resp)
            .then(resp => console.log(resp))

    });
}
{   // 닉네임 수정 처리
    let $nickNameBtn = document.querySelector('.nickname_confirmBtn')
    let $editNickname = document.querySelector('.nickname-input')

    $nickNameBtn.addEventListener('click' , function (){
        // console.log('클릭')
        let value = $editNickname.value;
        console.log(value)

        let object = {nickname : value}

        fetch('/members-nickname' , {
            method : 'PATCH',
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify(object)
        }).then(resp => resp)
            .then(resp => console.log(resp))
    });
}

{   // 이메일 수정 처리
    let $emailBtn = document.querySelector('.email_confirmBtn')
    let $editEmail = document.querySelector('.email-input')

    $emailBtn.addEventListener('click', function (){
        // console.log('click')
        let value = $editEmail.value;
        console.log(value)

        let object = {email : value}

        fetch('/members-email', {
            method : 'PATCH',
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify(object)
        }).then(resp => resp)
            .then(resp => console.log(resp))
    });
}


{   // 회원 탈퇴 처리
    // DOM 요소 선택
    const modal = document.getElementById("modal-delete");
    const deleteBtn = document.getElementById("deleteBtn");
    const cancelBtn = document.getElementById("cancelBtn");
    const closeBtn = document.querySelector(".delete_close");
    const agreeCheckBox = document.getElementById("agreeCheckBox");
    const errorMessage = document.getElementById("error-message");

// 모달 닫기 기능
    closeBtn.onclick = function() {
        modal.style.display = "none";
    };
    cancelBtn.onclick = function() {
        modal.style.display = "none";
    };

// 탈퇴 버튼 클릭 시
    deleteBtn.onclick = function(e ){
        // 필수 체크박스 확인
        if (!agreeCheckBox.checked) {
            errorMessage.style.display = "block";
            return;
        } else {
            errorMessage.style.display = "none";
        }



        removeMember(memberId, function() {
            alert("회원 탈퇴가 완료되었습니다.");
            window.location.href = "/member/login";
        });
    };

// 탈퇴 API 호출 함수
    function removeMember(memberId, callback) {
        fetch(`/members-delete/${memberId}`, {
            method: 'DELETE',
        }).then(resp => {
            if (!resp.ok) {
                throw new Error('응답 오류');
            }
            return resp.text(); // 응답이 JSON이 아닌 텍스트라면 사용
        }).then(() => {
            callback();
        }).catch(error => {
            console.error("문제 발생:", error);
            alert("탈퇴 처리 중 문제가 발생했습니다. 다시 시도해 주세요.");
        });
    }

// 모달 외부 클릭 시 닫기
    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
}


{
    // 이미지 삽입
    let $fileInput = document.querySelector('#fileInput')

    $fileInput.addEventListener('change', function () {
        // // console.log('change')
        // console.dir(this)

        let files = this.files
        let file = files[0]

        let src = URL.createObjectURL(file)

        let $imgTags = document.querySelectorAll('.user-img > img')

        $imgTags.forEach(imgTag => {
            imgTag.setAttribute('src', src);
        })

    //     서버 통신
        let formData = new FormData();
        formData.append("file", file)

        fetch('/members-pfp-file', {
            method : "PATCH",
            body : formData
        }).then(resp => console.log(resp))
    });
}

{
// 닉네임 모달 관련 요소 가져오기
    let n_modal = document.querySelector(".modal-nickname");
    let btn = document.querySelector(".profile_nickname_button");
    let span = document.getElementsByClassName("nickname_close")[0];
    let confirmBtn = document.getElementById("nickname_confirmBtn");
    let nicknameInput = document.querySelector(".nickname-input");
    let changeNickname = document.querySelectorAll(".profile_nickname");

// 닉네임 변경 버튼을 클릭하면 모달을 엶
    btn.onclick = function () {
        n_modal.style.display = "block";
        nicknameInput.value = changeNickname[1].textContent;
    };

// 닫기 버튼(X)을 클릭하면 모달을 닫음
    span.onclick = function () {
        n_modal.style.display = "none";
    };

// 확인 버튼을 클릭하면 모달을 닫음
    confirmBtn.onclick = function () {
        changeNickname.forEach(ch => ch.textContent = nicknameInput.value);
        n_modal.style.display = "none";
    };

// 모달 외부를 클릭하면 모달을 닫음
    document.body.onclick = function (event) {
        // console.log('click@@@')
        if (event.target == n_modal) {
            n_modal.style.display = "none";
        }
    };
}

{
// 이메일 모달 관련 요소 가져오기
    let e_modal = document.querySelector(".modal-email");
    let e_btn = document.querySelector(".profile_email_button");
    let e_span = document.getElementsByClassName("email_close")[0];
    let e_confirmBtn = document.getElementById("email_confirmBtn");
    let emailInput = document.querySelector(".email-input");
    let changeEmail = document.querySelectorAll(".profile_email");

// 이메일 변경 버튼을 클릭하면 모달을 엶
    e_btn.onclick = function () {
        e_modal.style.display = "block";
        emailInput.value = changeEmail[0].textContent;
    };

// 닫기 버튼(X)을 클릭하면 모달을 닫음
    e_span.onclick = function () {
        e_modal.style.display = "none";
    };

// 확인 버튼을 클릭하면 모달을 닫음
    e_confirmBtn.onclick = function () {
        changeEmail.forEach(ch => ch.textContent = emailInput.value);
        e_modal.style.display = "none";
    };

// 모달 외부를 클릭하면 모달을 닫음
    document.onclick = function (event) {
        if (event.target == e_modal) {
            e_modal.style.display = "none";
        }
    };
}

{

// 탈퇴 모달 관련 요소 가져오기
    let d_btn = document.querySelector(".delete_button");
    let d_span = document.getElementsByClassName("delete_close")[0];
    let d_modal = document.querySelector(".modal-delete");

// 탈퇴 버튼을 클릭하면 모달을 엶
    d_btn.onclick = function () {
        d_modal.style.display = "block";
    };

// 닫기 버튼(X)을 클릭하면 모달을 닫음
    d_span.onclick = function () {
        d_modal.style.display = "none";
    };

// 모달 외부를 클릭하면 모달을 닫음
    window.onclick = function (event) {
        if (event.target == d_modal) {
            d_modal.style.display = "none";
        }
    };

// 탈퇴 체크박스 및 버튼 관련 로직
    document.getElementById('deleteBtn').addEventListener('click', function () {
        let agreeCheckbox = document.getElementById('agreeCheckBox');
        let erorrMeg = document.querySelector('.error-message')
        let deleteBtn = document.getElementById('deleteBtn')

        if (!agreeCheckbox.checked) {
            deleteBtn.addEventListener("click", function (){
                erorrMeg.style.display = "block"
            })
        } else {
            agreeCheckbox.addEventListener("click", function (){
                erorrMeg.style.display = "none"
            })
            alert('탈퇴가 완료되었습니다.');
            d_modal.style.display = "none"
        }
    });

    //  취소 버튼 누르면 모달창 닫음
    document.getElementById('cancelBtn').addEventListener('click', function () {
        d_modal.style.display = "none"
    });
}

