import { useState } from "react";
import RegisterForm from "../components/RegisterForm";
import{ useAuthentication } from "../hooks/useAuthentication";
import { useNavigate } from "react-router-dom";

const RegisterPage = () => {
	const navigate = useNavigate();

	const [userName, setUserName] = useState("");
	const [password, setPassword] = useState("");

	const {registerUser, error, loading} = useAuthentication();

	const handleSubmit = async (e) => {
		e.preventDefault();

		try {
			await registerUser(userName, password);
			alert("registered");
			navigate("/todo");
		} catch (err) {
			console.log(err);
		}
	}

	return (
		<div>
			<h2>Register</h2>
			{error && <p style={{color : "red"}}>{error}</p>}
			<RegisterForm 
				username={userName}
				password={password}
				setUserName={setUserName}
				setPassword={setPassword}
				onSubmit={handleSubmit}
				loading={loading}
			/>
		</div>

	)
}

export default RegisterPage;