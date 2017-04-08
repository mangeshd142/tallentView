<%-- <div class="list-group">
	
        <%
       	int size = (Integer) request.getAttribute("contestSize");
       	
       	for (int i =0; i < size; i++) {
			request.setAttribute("counter", i);       
     %>
        <br> <a href="SampleContest?progid=<%out.print(cont.getProg_id());%>&contestid=<%out.print(cont.getContest_id());%>"><%out.print("Name: "+cont.getName()+" Info: "+cont.getContest_info()+" ID: "+cont.getContest_id()); %></a>
        <a href="SampleContest?progid=${contestInfo[counter].prog_id}&contestid=${contestInfo[counter].contest_id}" class="list-group-item" style="width:600px">
		    <h4 class="list-group-item-heading">ID: ${contestInfo[counter].contest_id} Name: ${contestInfo[counter].name}</h4>
		    <p class="list-group-item-text">Contest ID: ${contestInfo[counter].contest_id}Description: ${contestInfo[counter].contest_info}</p>
		</a>
        <%} 
        request.removeAttribute("contestSize");
        request.removeAttribute("counter");
        %> 
</div> --%>

        <%
       	int size2 = (Integer) request.getAttribute("contestSize");
       	
       	for (int i =0; i < size2; i++) {
			request.setAttribute("counter", i);       
     %>
        
			  <div class="col-md-6">
							 <a href="SampleContest?progid=${contestInfo[counter].prog_id}&contestid=${contestInfo[counter].contest_id}" style="color: black;">
				            <div class="panel panel-default">
				                <div class="panel-heading">
				                     <h4> ${contestInfo[counter].name}</h4>
				                </div>
				                <ul class="list-group list-group-flush ">
				                	 <li class="list-group-item">
				                      <span> <b>Language: </b> ${contestInfo[counter].language} </span>
				                     
				                    </li>
				                    <li class="list-group-item">
				                       <span> <b>Description: ${contestInfo[counter].contest_info} </span>
				                     
				                    </li>
				                </ul>
				                
				            </div>
				            </a>
				        </div>
			 
		
        <%} 
        request.removeAttribute("contestSize");
        request.removeAttribute("counter");
        %> 
       

