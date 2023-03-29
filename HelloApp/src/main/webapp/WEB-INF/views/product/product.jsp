<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: BST-498</div>
                        <h1 class="display-5 fw-bolder">Shop item template</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">$45.00</span>
                            <span>$40.00</span>
                        </div>
                        <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <input type="text" id="writer" value="user02">
        <input type="text" id="content">
        <button id="addContent">댓글등록</button>
        <br>
        
        <table class ="table">
        	<thead>
        		<tr>
        			<th>댓글번호</th>
        			<th>작성자</th>
        			<th>댓글내용</th>
        			<th>삭제</th>
        		</tr>
        	</thead>
        	<tbody id="list">
        		<!-- <tr>
        			<td>1</td>
        			<td>user01</td>
        			<td>reply test</td>
        			<td><button>삭제</button></td>
        		</tr> -->
        	</tbody>
        </table>
        
        <div style = "display: none">
        <table>
         <tr id="template">
         	<td class="replyNo"></td>
         	<td class="replyWriter"></td>
         	<td><input class="replyContent" type="text"></td>
         	<td><button onclick='updateReply(this)'>저장</button></td>
         </tr>
        </table>
        </div>
        
        <script>
        
        	//목록 데이터
        	//let promiseResult = fetch('')
        	//promiseResult.then(function(){});
        	fetch('replyListAjax.do?code=${code.productCode}')
        	.then(resolve => resolve.json())
        	.then(result => {
        		result.forEach(function (reply){
                    let tr = makeRow(reply);
                    document.querySelector('#list').append(tr);
                });
        		
        	})
        	.catch(reject => console.log(reject));
        	
            let showProps =['replyNo', 'replyWriter', 'replyContent']
        	function makeRow(reply={}){
        		let tr = document.createElement('tr');
        		tr.addEventListener('dblclick', modifyTr); //더블클릭
        		tr.id = reply.replyNo;//tr id의 attribute에 댓글 번호
        		//td생성
                showProps.forEach(function (prop){
                    let td = document.createElement('td');
                    let txt = document.createTextNode(reply[prop]);
                    td.append(txt); 
                    tr.append(td); 
                    tr.setAttribute('id',reply.replyNo);
                });
				//항목외에 추가하는 기능
                let td = document.createElement('td');
                let btn = document.createElement('button');
                btn.addEventListener('click', removeReply); //삭제처리
                btn.innerText = '삭제';
                td.append(btn);
                tr.append(td);
                //document.querySelector('#list').append(tr);
                //makeRow를 호출하는 영역에서 처리하도록 tr을 반환
                return tr; 
        	}
            
            //화면수정
            function modifyTr(){
            	console.log(this);
            	let id = this.id;
            	let oldTr = this;
            	
            	//댓글한건 조회
            	fetch("replySearchAjax.do?replyNo="+id)
            	.then(resolve => resolve.json())
            	.then(result => {
            		console.log(result);
            		let data = result;
            		
            		document.getElementById('list').replaceChild(makeEditRow(data),oldTr);
            		//oldTR.innerHTML = makeEditRow2(data); //<tr></tr>
            		//let tr = makeEditRow3(data);
            		document.getElementById('list').replaceChild(makeEditRow3(data),oldTr);
            	})
            	.catch(reject => console.error(reject));
         	
            }
            
            function makeEditRow3(data){
            	let cloneTr = document.getElementById('template').cloneNode(true);
            	cloneTr.id = data.replyNo;
            	cloneTr.querySelector('.replyNo').innerText = data.replyNo;
            	cloneTr.querySelector('.replyWriter').innerText = data.replyWriter;
            	cloneTr.querySelector('.replyContent').value = data.replyContent;
            	console.log(cloneTr);
            	return cloneTr;
            }
            
            
            function makeEditRow2(data){
            	console.log(data);
            	let str = "";
            	str += "<td>"+data.replyNo+"</td>";
            	str += "<td>"+data.replyWriter+"</td>";
            	str += "<td><input value="+data.replyContent+"'></td>";
            	str += "<td><button onclick='updateReply(this)'>저장</button></td>";
            	 //<td>10</td><td>user03</td><td><input value=""></td><td><button>저장</button></td>
            	
            	return str;
            }
            
            function makeEditRow(){
            	let newTr = document.createElement('tr');
            	let td = document.createElement('td');
            	td.innerText = data.replyNo;
            	newTr.append(td);
            	
            	td = document.createElement('td');
            	td.innerText = data.replyWriter;
            	newTr.append(td);
            	
            	td = document.createElement('td');
            	let input = document.createElement('input');
            	input.value = data.replyContent;
            	td.append(input);
            	newTr.append(td);
            	
            	td = document.createElement('td');
                let btn = document.createElement('button');
                btn.innerText = '저장';
                btn.addEventListener('click', updateReply1);
                td.append(btn);
                newTr.append(td);
            	
            	console.log(newTr);
            	document.getElementById('list').replaceChild(newTr, oldTr);
            }
            
            function updateReply1(){  
            	console.log(this);         
            	// let cloneTr = document.getElementById('template').cloneNode(true);
            	let id = this.parentElement.parentElement.children[0].innerText;//template<< 얘로는 3번째 방식을 처리해주지 못해
            	//console.log(window);
            	let content = this.parentElement.parentElement.children[2].children[0].value;//firstchild = children[0] //input 태그는 value를 써야함
            	//param.parentElement.parentElement.querySelector('input').value;
            	console.log(id, content);
            	let oldTr = this.parentElement.parentElement;
            	
            	//cloneTr.querySelector('.replyNo').innerText = data.replyNo;
            	//cloneTr.querySelector('.replyWriter').innerText = data.replyWriter;
            	//cloneTr.querySelector('.replyContent').value = data.replyContent;
            	//console.log(cloneTr);
            	
            	fetch('replyUpdateAjax.do?replyId='+ id+'&content='+content)
			 	.then(resolve => resolve.json())
            	.then(result => {
            		console.log(result);
            		//if(result.retCode =='Success'){
            		//	alert('성공');
            			let tr = makeRow(result);
            			//document.getElementById(id).append(tr);
            						
            			document.getElementById('list').replaceChild(tr, oldTr);
            			
            		//}else if(result.retCode =='Fail'){
            		//	alert('실패');
            		//}else{
            		//	alart('retCode값을 확인하세요');
            		//}
            	})
            	.catch(reject => console.error(reject))

            	//document.getElementById('list').replaceChild(newTr, oldTr);
            }
            
            function updateReply(param){  
            	console.log(param);         
            	// let cloneTr = document.getElementById('template').cloneNode(true);
            	let id = param.parentElement.parentElement.children[0].innerText;//template<< 얘로는 3번째 방식을 처리해주지 못해
            	//console.log(window);
            	let content = param.parentElement.parentElement.children[2].children[0].value;//firstchild = children[0] //input 태그는 value를 써야함
            	//param.parentElement.parentElement.querySelector('input').value;
            	console.log(id, content);
            	let oldTr = param.parentElement.parentElement;
            	
            	//cloneTr.querySelector('.replyNo').innerText = data.replyNo;
            	//cloneTr.querySelector('.replyWriter').innerText = data.replyWriter;
            	//cloneTr.querySelector('.replyContent').value = data.replyContent;
            	//console.log(cloneTr);
            	
            	fetch('replyUpdateAjax.do?replyId='+ id+'&content='+content)
			 	.then(resolve => resolve.json())
            	.then(result => {
            		console.log(result);
            		//if(result.retCode =='Success'){
            		//	alert('성공');
            			let tr = makeRow(result);
            			//document.getElementById(id).append(tr);
            						
            			document.getElementById('list').replaceChild(tr, oldTr);
            			
            		//}else if(result.retCode =='Fail'){
            		//	alert('실패');
            		//}else{
            		//	alart('retCode값을 확인하세요');
            		//}
            	})
            	.catch(reject => console.error(reject))

            	//document.getElementById('list').replaceChild(newTr, oldTr);
            }
            
            //댓글번호 데이터를 삭제기능(컨트롤) + 화면에서 삭제(elem.remove())
            function removeReply(){
                console.log(this.parentElement.parentElement.id); //this 키워드: 이벤트를 받는 대상
                let id = this.parentElement.parentElement.id;
                
                fetch('replyRemoveAjax.do?replyId='+id)
                .then(resolve => resolve.json())
                .then(result => {
                	console.log(result);
                	if(result.retCode == 'Success'){
                		alert('성공');
                		document.getElementById(id).remove();
                		
                	}else if(result.retCode =='Fail'){
                		alert('실패');
                	}else {
                		alart('retCode값을 확인하세요');
                	}
                })
                .catch(reject => console.error(reject));
                	             
            }
            
            //댓글등록
            document.querySelector('#addContent').addEventListener('click', addReply);
            
            function addReply(){
            	//writer, content의 value.
            	let writer = document.querySelector('#writer').value;
            	let content = document.querySelector('#content').value;
            	
            	fetch('replyAddAjax.do',{
            		method: 'post',
            		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            		body: 'writer='+writer+'&content='+content+'&pcode=${code.productCode}'
            	})
            	.then(resolve => resolve.json())
            	.then(result => {
            		console.log(result);
            		if(result.retCode == 'Success'){
            			alert('성공');
            			let tr = makeRow(result.reply);
            			document.querySelector('#list').append(tr);
            			
            			//댓글입력부분 초기화
            			document.querySelector('#content').value = '';
            			
            		}else if(result.retCode == 'Fail'){
            			alert('실패');
            		}else{
            			alert("retCode를 확인하세요");
            		}
            	})
            	.catch(reject => console.error(reject))
            }
            
            
            
        </script>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Related products</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Fancy Product</h5>
                                    <!-- Product price-->
                                    $40.00 - $80.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Special Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$20.00</span>
                                    $18.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Sale Item</h5>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$50.00</span>
                                    $25.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Popular Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>