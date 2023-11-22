$("#agree").css("background-color", "#F0FFFF");
$("#disagree").css("background-color", "#FFDAB9");

$(function () {
    $("#agree").hide();
    $("#disagree").hide();
    $("input").keyup(function () {
        var pwBox1 = $("#pwBox1").val();
        var pwBox2 = $("#pwBox2").val();

        if(pwBox1 != "" && pwBox2 != "") {
            if(pwBox1 == pwBox2) {
                $("#agree").show();
                $("#disagree").hide();
                $("#submitBox").removeAttr("disabled");
            }
            else {
                $("#agree").hide();
                $("#disagree").show();
                $("#submitBox").attr('disabled', 'disabled');
            }
        }
    });
});

let userObject = {
    init: function () {
        let _this = this;

        $("#submitBox").on("click", () => {
            _this.insertUser();
        });
    },

    insertUser: function () {
        alert("회원가입 요청 완료");

        let user = {
            username : $("#idBox").val(),
            password: $("#pwBox1").val(),
            nickname: $("#nameBox").val()
        }

        //done() 요청 처리에 성공했을때 실행
        //fail() 요청 처리에 실패했을때 실행

        $.ajax({
            type : "POST", //요청 방식
            url: "/join/create", //요청 경로
            data: JSON.stringify(user), //user 객체를 JSON 형식으로 변환
            //HTTP의 BODY에 설정되는 데이터 마임타입
            contentType: "application/json; charset=utf-8"
            //응답으로 들어온 JSON 데이터를 response로 받는다
        }).done(function(response) {
            //응답 메세지를 콘솔에 출력하고 메인 페이지로 이동
            debugger
            console.log(response);
            location="/";
            //에러 발생 시 error로 에러 정보를 받는다
        }).fail(function (error) {
            debugger
            //에러 메세지를 알림창에 출력
            alert("에러 발생: " +error);
        });
    },
}

userObject.init();