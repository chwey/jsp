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
	  
      
      
      function drawChart() {
		//[{'Admin:1'},{'Accounting':2}.......]
		fetch('chartAjax.do')
      	.then(resolve => resolve.json())
      	.then(result => {
    	  //console.log(result);
    	  let outAry = [];
    	  outAry.push(['dept', 'cnt per dept']);
    	  
    	  result.forEach(dept => {
    		  //console.log(dept)
    		  let ary = []
    		  for(prop in dept){
    			  ary[0] = prop;
    			  ary[1] = dept[prop];
    		  }
    		  //console.log(ary);
    		  outAry.push(ary);//가공
    	  })
    		  var data = google.visualization.arrayToDataTable(outAry);		
    	       /* var data = google.visualization.arrayToDataTable([
    	          ['Task', 'Hours per Day'],
    	          ['Work',     9],
    	          ['Eat',      2],
    	          ['Commute',  2],
    	          ['Watch TV', 2],
    	          ['Sleep',    7],
    	          ['Game',    2]
    	        ]);//배열형식으로 값을 넣어줌//배열 안에 객체임*/

    	        var options = {
    	          title: 'Person by Department'
    	        };
    	  console.log(outAry);
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options); //차트를 그려줌
      })
      .catch(reject => console.error(reject))
		


      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
