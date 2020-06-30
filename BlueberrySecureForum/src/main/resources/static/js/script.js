function verify()
{var password1 = document.forms['form']['password'].value;var password2 = document.forms['form']['verifyPassword'].value;if (password1 == null || password1 == "" || password1 != password2) 
{document.getElementById("error").innerHTML= "Please check your passwords";return false;} 
}}

<script src="../static/js/script.js" th:src="@{/js/script.js}">
</script><link rel="stylesheet" type="text/css" media="all"  href="../static/css/mycss.css" th:href="@{/css/mycss.css}" />
	
	