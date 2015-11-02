
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Usuario</title>
<script src="http:////code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
 
		$('#formulario').submit(function(e) {
			var frm = $('#formulario');
			e.preventDefault();
 
		    var data = {}
		    var Form = this;
 
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
        $.ajax({
            contentType: 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: frm.attr('action'),
            dataType: 'json',
            data: JSON.stringify(data),
            success: function(callback){
            	alert("Response: Name: "+callback.nome+"  Sexo: "+callback.sexo+"  Profissao: "+callback.profissao+"  Fumante: "+callback.fumante);
                $(this).html("Success!");
            },
            error: function(){
                $(this).html("Error!");
            }
        });
		});
	});
</script>
</head>
<body>
<form:form commandName="usuario" action="formulario.web" method="post" id="formulario">     
 
	    <fieldset style="width: 300px;">
	        <legend>User details</legend>
	        <ol>
	            <li>
	                <p><label for=nome>Nome</label>
	                <form:input path="nome"  type="text" placeholder="Primeiro e último nome" /></p>
	            </li>
	             <li>
                    <label for=sexo>Sexo:</label>
					<form:radiobuttons path="sexo" items="${usuario.sexos}"/>
                </li>
	            <li>
	                <p><label for=profissao>Profissão</label>
	                <form:select path="profissao">
	                	<form:option value="none"> --Selecione-- </form:option>
	                	<form:option value="analista"></form:option>
	                	<form:option value="programador"></form:option>
	                	<form:option value="tester"></form:option>
	                </form:select>
	            </li>
	            <li>
	                <p><label for=fumante>Fumante</label>
	                <form:radiobutton path="fumante" id="fumante" /></p>
	            </li>
	         </ol>
	    </fieldset>
 
		<fieldset style="width: 300px;">
			<input id="submitId" type="submit" value="Submit Formulario">
		</fieldset>
	</form:form> 		
        
</body>
</html>