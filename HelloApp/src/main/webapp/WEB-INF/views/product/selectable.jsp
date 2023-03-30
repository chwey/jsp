<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='full/dist/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', async function () {
      //fetch api사용 
      let events = [];

      let promise1 = await fetch('calendarAjax.do')
      let promise2 = await promise1.json();

      events = promise2;


      var calendarEl = document.getElementById('calendar');

      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialDate: '2023-01-12',
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true,
        select: function (arg) {
          var title = prompt('Event Title:');
          console.log(arg)
          if (title) {
            fetch('calendarAddAjax.do', {
                method: 'post',
                headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr
              })
              .then(resolve => resolve.json())
              .then(result => {
                if (result.retCode == 'Success') {
                  alert('성공');
                  calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay
                  })
                } else if (result.retCode == 'Fail') {
                  alert('실패');
                } else {
                  alert("retCode를 확인하세요");
                }
              })
              .catch(reject => console.error(reject))
          }
          calendar.unselect()
        },
        eventClick: function (arg) {
          if (confirm('Are you sure you want to delete this event?')) {
            arg.event.remove()
          }
        },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
        events: events
      });

      calendar.render();
    });
  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

  <div id='calendar'></div>

</body>

</html>