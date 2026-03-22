import { useState } from "react";
import { useAuthentication } from "../hooks/useAuthentication";
import { useNavigate } from "react-router-dom";

function LoginForm() {
	const navigate = useNavigate();

	const {loginUser} = useAuthentication();

	const [userName, setUserName] = useState("");
	const [password, setPassword] = useState("");

	const handleLogin = async() => {
		try{
			await loginUser(userName, password); 
			navigate("/todo");
		} catch {
			alert("login failed");
		}
	};

	return (
		<div>
			<input onChange={(e)=>setUserName(e.target.value)} />
			<input type="password" onChange={(e)=>setPassword(e.target.value)} />
			<a onClick={handleLogin}>Login</a>
		</div>
	)
}

export default LoginForm;