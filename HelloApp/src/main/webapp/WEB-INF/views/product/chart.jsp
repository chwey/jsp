<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 구글차트 이용함 -->
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
	  
      
      
      async function drawChart() {
		//[{'Admin:1'},{'Accounting':2}.......]
		console.log("1");
		
    	let outAry = [];
    	outAry.push(['dept', 'cnt per dept']);
		let promise1 = await fetch('chartAjax.do') //promise 객체
      	let promise2 = promise1.json();//배열 결과값 [{},{},{},...]
      	console.log("1-1");
		promise2.forEach(dept => {
			let ary = [];
			for(let prop in dept){
				ary[0] = prop;
				ary[1] = dept[prop];				
			}
			outAry.push(ary);
		})
			console.log("1-2");
    	 var data = google.visualization.arrayToDataTable(outAry);		
    	 
    	 var options = {
    	      title: 'Person by Department'
    	    };
    	  console.log(outAry);
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options); //차트를 그려줌
		
		console.log("2");


      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
