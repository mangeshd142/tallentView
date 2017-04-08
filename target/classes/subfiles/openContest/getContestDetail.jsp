<!-- <div class="list-group"> -->

        <%
       	int size2 = (Integer) request.getAttribute("contestSize");
       	
       	for (int i =0; i < size2; i++) {
			request.setAttribute("counter", i);       
     %>
        
			 <%-- <div class="col-sm-4" style="background-color:lavender;">
				  <a href="proceedContest?progid=${contestInfo[counter].prog_id}&contestid=${contestInfo[counter].contest_id}" class="list-group-item" style="width:500px">
				   	<h4><span style="text-decoration: none; border-bottom: 1px solid; margin-right: 300px">
				   	Contest Name: ${contestInfo[counter].name}
				   	</span></h4>
				    <span>Language: ${contestInfo[counter].language}</span>
				    <span style="float:right;margin-right:70px">Group Size: ${contestInfo[counter].participant} members</span><br>
				    <span>Prise: &#x20b9; ${contestInfo[counter].prise}</span>
				    <span style="float:right;margin-right:70px">Entry Peas: &#x20b9; ${contestInfo[counter].entry_fee}</span><br><br>
				    <span>Start Date: </span>
				    <span style="float:right;margin-right:70px">End Date </span><br>	
				    <span>${contestInfo[counter].start_date} </span>
				    <span style="float:right;margin-right:70px">${contestInfo[counter].end_date}</span>
				  </a>
			 </div> --%>
			 
			 	
		
		 <div class="col-md-18">
			 <a href="proceedContest?progid=${contestInfo[counter].prog_id}&contestid=${contestInfo[counter].contest_id}" style="color: black;">
            <div class="panel panel-default">
                <div class="panel-heading">
                     <h4>Contest Name: ${contestInfo[counter].name}</h4>
                </div>
                <ul class="list-group list-group-flush ">
                	 <li class="list-group-item">
                      <span> <b>Language: </b> ${contestInfo[counter].language} </span>
                    </li>
                    
                </ul>
                
            </div>
            </a>
        </div>
		
        <%} 
        request.removeAttribute("contestSize");
        request.removeAttribute("counter");
        %> 

        
<!-- 
		    <div class="col-sm-4" style="background-color:lavender;">.col-sm-4</div>
		    <div class="col-sm-4" style="background-color:lavenderblush;">.col-sm-8</div>
		    <div class="col-sm-4" style="background-color:lavender;">.col-sm-4</div>
		    <div class="col-sm-4" style="background-color:lavenderblush;">.col-sm-8</div>
		    <div class="col-sm-4" style="background-color:lavender;">.col-sm-4</div>
		    <div class="col-sm-4" style="background-color:lavenderblush;">.col-sm-8</div>
		
		  </div> -->
<!-- </div> -->