{
    let modal = document.querySelector('.book-modal');
    let modalbtn = document.querySelector('.gather-create-book');
    let modalbtnclose = document.querySelector('.book-modal-body-close');



    modalbtn.addEventListener("click",()=>{
        modal.style.display="flex";
    })
    modalbtnclose.addEventListener("click",()=>{
        modal.style.display="none";
    })
    console.log(sessionStorage.getItem('debateType'));
    console.log(sessionStorage.getItem('meetingType'));

}
{ //버튼처리
    let $typeRemove = document.querySelector('.type-remove')
    $typeRemove.addEventListener("click",function (){
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
    let $slider = document.querySelector('.gather-group');
    let $output = document.querySelector('.gather-value');
    let $Datenow=document.querySelector('.gather-value-in')
    let $Datenew=document.querySelector('.gather-value-out')

    let nowDate=new Date();
    let startdate ;
    //range 에다른 일수 계산
    $output.innerHTML = $slider.value;
    $slider.oninput = function () {
        //range 바에 따른 일수를 계산하여 반영한다
        $output.innerHTML = this.value;
        //현재 날자와 range의 값을 addDate에 넘겨 +계산을 한다
        $Datenew.innerHTML=addDate(nowDate,parseInt(this.value));
        startdate=this.value;
    }
    $Datenow.innerHTML=nowDate.toLocaleDateString();

    let $sliderD = document.querySelector('.gather-group-d');
    let $outputD = document.querySelector('.gather-value-d');
    let $DatenowD=document.querySelector('.gather-value-ind')
    let $DatenewD=document.querySelector('.gather-value-outd')
    $outputD.innerHTML = $sliderD.value;



    $sliderD.oninput = function () {
        $outputD.innerHTML = this.value;
        let i =addDate(nowDate,startdate);
       $DatenowD.innerHTML=i;
        $DatenewD.innerHTML=addDate(i,this.value);
    }

    function addDate(date,days){
        let today=new Date(date);//
        let dates=today.setDate(today.getDate()+parseInt(days));
        return today.toLocaleDateString();
    }
}
{

}