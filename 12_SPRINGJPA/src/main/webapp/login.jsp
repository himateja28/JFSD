<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
    html, body {
        width: 100%;
        height: 100%;
        margin: 0;

    }
    .loginContainer {
        width: 300px;
        height: 450px;
        background: white;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        position: absolute;
        box-shadow: 0px 0px 15px;
    }
    h1 {
        color: darkgreen;
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    input[type="text"], input[type="password"] {
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid darkgreen;
        border-radius: 5px;
    }
    #login {
        width: 80%;
        padding: 10px;
        background-color: darkgreen;
        color: white;
        border: none;
        text-align:center;
        border-radius: 5px;
        cursor: pointer;
    }
    #login:hover {
        background-color: #004d00;
    }
    .signup {
        color: darkgreen;
        left:100px;
        position:relative;
        cursor: pointer;
    }
</style>
</head>
<body>
    <div class="loginContainer">
        <h1>Login</h1>
        <div>
            <form action="">
                <input type="text" placeholder="Enter username" id="T1" required>
                <input type="password" placeholder="Enter password " id="T2" required>
                <buttton id="login" onclick="signin()">Sign In</buttton>
            </form>
        </div>
        <div style="width: 100%; height: 70px;line-height: 70px">
        	<label id="ack"></label>
        </div>
        <div style="width: 100%; height: 20px; text-align: center;">Don't have an account?</div>
        <label class="signup">SIGNUP NOW</label>    
    </div>
</body>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
	function signin() {
		var data = JSON.stringify({
			username:T1.value,
			password:T2.value
		});
		var url = "http://localhost:8080/user/login";
		callApi("GET",url,data,signinHandler);
		console.log(data)
	}
	function signinHandler(res) {
		ack.innerHTML = res;
	}
</script>
</html>
