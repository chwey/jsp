<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>member.html</title>
    <script src="jQuery/jquery-3.6.4.min.js"></script>
    <script>
        //document 로딩 후 처리]
        $(document).ready(function () {
            //fetch('url',{option})
            $.ajax({
                url: "memberListJquery.do", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
                data: {
                    name: "홍길동", //서버에서 request.getParameter('name');
                    id: 'user01' // request.getParameter('id')
                }, // HTTP 요청과 함께 서버로 보낼 데이터
                method: "GET", // HTTP 요청 방식(GET, POST)
                dataType: "json", // 서버에서 보내줄 데이터의 타입:JSON.parse()실행
                success: function (result) { //서버요청의 성공시 실행
                    //Json.parse(result);
                    $(result).each(function (idx, member) {
                        console.log(idx, member);
                        $('#list').append(
                            //tr>td*4 생성
                            $('<tr id = '+member.memberId +' />').append($('<td />').text(member.memberId),
                                $('<td />').append(member.memberName),
                                $('<td />').text(member.memberAddr),
                                $('<td />').text(member.memberTel),
                                $('<td />').text(member.memberPw),
                                $('<td />').append($('<button />').text('삭제').on(
                                    'click', rowDeleteFnc)),
                                $('<td/>').append($('<input type="checkbox"/>'))
                            )
                        );
                    })
                },
                error: function (err) { //서버요청의 실패시 실행
                    console.log(err);
                }

            }) //$.ajax()
            //추가버튼 이벤트& 이벤트 핸들러
            $('#addBtn').on('click', function (e) {
                e.preventDefault(); //전송기능 차단
                console.log($("#passwd").val())
             	let ok = true;
 
                ok= ok && $('#id').val();
                ok= ok && $('#name').val();
                ok= ok && $('#addr').val();
                ok= ok && $('#tel').val();
                ok= ok && $('#passwd').val();
                //사용자가 필수입력값을 입력했는지 validation하고
                if(!ok){
                	alert('확인해주세요');
                	return;
                }
                //ajax 호풀
                $.ajax({
			    url: "memberAddJquery.do", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소			
			    data: { id: $("#id").val(), 
			    	name: $("#name").val(), 
			    	addr: $("#addr").val(), 
			    	tel:$("#tel").val(), 
			    	pw:$("#passwd").val()
			    	},                          // HTTP 요청과 함께 서버로 보낼 데이터					    	
			    method: "POST",                                     // HTTP 요청 방식(GET, POST)			
			    dataType: "json",                                   // 서버에서 보내줄 데이터의 타입
			    success: function (result){
			    	if(result.retCode == 'Success'){
			    		//성공
			    		alert('성공');
		                $('#list').append(
		                    //tr>td*4 생성
		                    $('<tr />').append($('<td />').text($('#id').val()),
		                        $('<td />').text($('#name').val()),
		                        $('<td />').text($('#addr').val()),
		                        $('<td />').text($('#tel').val()),
		                        $('<td />').text($('#passwd').val()),
		                        $('<td />').append($('<button />').text('삭제').on('click', rowDeleteFnc)),
		                        $('<td/>').append($('<input type="checkbox"/>'))
		                    ) //여기 괄호 하나 빠졌어요! from 준호
		                )
			    		
			    	}else if(result.retCode == 'Fail'){
			    		//처리중 에러
			    		alert('실패');
			    	}else{
			    		//반환코드 확인
			    		alert("retCode를 확인하세요");
			    	}
			    },
			    error: function (reject){
			    	
			    }
			    
			})

            })
            //여기에 선택삭제 클릭이벤트 넣기&이벤트핸들러
            $('#delSelected').on('click', function (e) {
                e.preventDefault();
                let memberIdAry = '';//memberId=user01&memberId=user02&memberId=user03
                console.log($('#list input:checked'));
                $('#list input:checked').each(function (idx, item) {
                	console.log($(item).parent().parent().attr('id'))
                	//memberIdAray.push({'memberId': $(item).parent().parent().attr('id'))
                	memberIdAry += '&memberId=' + $(item).parent().parent().attr('id');
                	//$(item).closest('tr').remove();          
                })
                console.log(memberIdAry);
                
                //ajax 호출
                $.ajax({
                	url: 'memberRemoveJquery.do',//호출할 컨트롤
                	method:'POST',
                	data: memberIdAry.substring(1),//&memberId=user0&memberId=user02
                	success: function(result){
                		if(result.retCode == 'Success')              	
                		$('#list input:checked').closest('tr').remove();
                		else
                			alert('error!!');
                	},
                	error: function(reject){
                		console.log(reject)
                	}
                
                })
                

            })
            //$('input:checked') 체크박스 체크된거 불러오기

            //전체선택, 전체해제
            $('th>input[type="checkbox"]').on('change', function () {
                // $('td>input').attr('checked', 'checked');
                console.log(this.checked)
                $('td>input').prop({ //true나 false 값을 줘야할 땐 prop이 편함
                    checked: this.checked
                })
            })
            
            //th>input과 td>input 을 비교해서 전체선택이 되도록
            //ajax 호출의 결과로 만들어지는 부분. 이벤트 위임
             $('#list').on('change', 'td>input[type="checkbox"]',function (){
           // $('td>input[type="checkbox"]').on('change',function (){
            	 console.log(this);
            	 let checkCnt = $('td>input[type="checkbox"]:checked').length;
            	 let allCnt = $('td>input[type="checkbox"]').length;
            	 if(checkCnt == allCnt){
            		 $('th>input[type="checkbox"]').prop({checked:true})
            	 }else{
            		 $('th>input[type="checkbox"]').prop({checked:false})
            	 }
             })


            //삭제버튼 이벤트 핸들러
            function rowDeleteFnc() {
                $(this).parentsUntil('tbody').remove(); //tbody가 되기 전까지 (tr까지)
            }
           
           
        });
    </script>
</head>

<body>
    <div>
        <table class="table" boarder="1">
            <form>
                <tr>
                    <td>id:</td>
                    <td><input type="text" id="id"></td><br>
                </tr>
                <tr>
                    <td>name:</td>
                    <td><input type="text" id="name"></td><br>
                </tr>
                <tr>
                    <td>passwd:</td>
                    <td><input type="text" id="passwd"></td><br>
                </tr>
                <tr>
                    <td>addr:</td>
                    <td><input type="text" id="addr"></td><br>
                </tr>
                <tr>
                    <td>tel:</td>
                    <td><input type="text" id="tel"></td><br>
                </tr>
                <tr>
                    <td><button id="addBtn">등록</button></td>
                    <td><button id="delSelected">선택삭제</button></td>
                </tr>
            </form>
        </table>
    </div>
    <div>
        <table class="table" border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Pass</th>
                    <th>주소</th>
                    <th>전화번호</th>
                    <th>삭제</th>
                    <th><input type="checkbox"></th>

            <tbody id="list">
            </tbody>
        </table>
    </div>
</body>

</html>