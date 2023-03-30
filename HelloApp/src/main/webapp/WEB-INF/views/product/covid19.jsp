<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--시도: <input type="text" id="sido">-->
	시도선택: <select id="sidoList"></select>
			  
	<button id="sidoBtn">찾기</button>
	<table border = "1">
		<thead>
			<tr><th>아이디</th><th>센터명</th><th>주소</th><th>연락처</th><th>시도</th></tr>
			

		</thead>
		<tbody id="centerList"></tbody>
	</table>
	
	<script>
	let showFields = ['id','centerName','address','phoneNumber','sido']
	
	//row 생성
	function makeTr(center={}){
		//tr생성>td* 여러개
		let tr = document.createElement('tr');

		//위도,경도 값
		tr.setAttribute('data-lng', center.lng);
		tr.setAttribute('data-lat', center.lat);
		tr.setAttribute('data-name', center.centerName);

		tr.addEventListener('click',openMapFnc);
		//td생성
		showFields.forEach(function (prop){
			let td = document.createElement('td');
			td.innerText = center[prop];
			tr.append(td);

		})
		return tr;
	}

	function openMapFnc(){
		let tr = this; //이벤트를 받는 대상
		console.log(tr)
		let lng = tr.dataset.lng;//tr.getAttribute('data-lng');
		let lat = tr.dataset.lat;//tr.getAttribute('data-lat');
		let centerName = tr.dataset.name;
		console.log(centerName);
		location.href = 'map.do?lat='+lat+'&lng='+lng+'&centerName='+centerName;
	}

	//전체목록
	let totalList; //다른함수에서도 활용
	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=l7U%2Fu1Rbid4iRhb3HGmW%2FCIYKDdE%2B7G7kH1bUt9CHesBeYw0n9mA0ZViyQjcnGo4y%2BU26KNWb8O30CNQ76aoLw%3D%3D`
	fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		let aryData = result.data;
		totalList = aryData; //처리결과를 갖고와서 totalList에 대입
		aryData.forEach(function (center){
			let tr = makeTr(center);
			document.querySelector('#centerList').append(tr);
		});

		//시도배열
		// totalList;//{id,centerName,address, sido}
		let sidoAry = [];
		totalList.forEach(function(list){
			let sido = list.sido;
			if(sidoAry.indexOf(sido) == -1){
				sidoAry.push(sido);
			}
		})
		//push,pop,unshift,shift
		

		sidoAry.forEach(function(sido){
			let opt = document.createElement('option');
			opt.value = sido;
			opt.innerText = sido;
			document.querySelector('#sidoList').append(opt);
		});
	})
	.catch(reject => console.error(reject));


	//찾기 버튼
	document.querySelector('#sidoBtn').addEventListener('click',findSidoFnc);
	function findSidoFnc(){
		//전체목록에서 사용자가 입력한 검색조건을 filter한 결과를 tbody의 하위목록으로 출력
		document.querySelector('#centerList').innerHTML = "";

		let searchWord = document.getElementById('sidoList').value;
		let filterAry = totalList.filter(function(center){
			console.log(center);
			return center.sido == searchWord;
		});

		console.log(filterAry);

		filterAry.forEach(center => {
			document.querySelector('#centerList').append(makeTr(center));
		})
	}
	
	</script>
</body>
</html>