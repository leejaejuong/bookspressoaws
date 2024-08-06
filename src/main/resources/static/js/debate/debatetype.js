{
    // let $debateType = document.querySelector('.nexttype')
    let $typeRemove = document.querySelector('.type-remove')
    // let number = document.querySelector('input[name="debateType"]:checked').value;
    // $debateType.addEventListener("click", function () {
    //     // name 을통하여 값을 가져온다
    //
    //
    //     sessionStorage.setItem('debateType', number);
    //     location.href = `/member/debateoutline`;
    //
    // });
    $typeRemove.addEventListener("click",function (){
        location.href = `/debate/make`;

    });


}
