<%-- compile: ${compile}
input: ${input}
expOutput: ${expOutput}
output: ${output}
pasedTestcases: ${pasedTestcases} --%>
<br><br>

<div><span class="alert alert-warning">Compile Details:</span></div><br>
<textarea class="alert alert alert-danger" rows="4" cols="163" readonly>${compile} </textarea>
<table class="table table-bordered">


    <thead>
    	
	      <tr>
	      
	        <th>Input</th>
	        <th>Your Output</th>
	        <th>Expected Output</th>
	        <th>Result of 1st Test Case</th>
	        
	      </tr>
    </thead>
   
    <tbody>
	      <tr>
	       
	        <td>${input} </td>
	        <td>${output} </td>
	        <td>${expOutput} </td>
	        <td>${pasedTestcases} </td>
	      </tr>
	   
    </tbody>
