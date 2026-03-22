import { useState } from "react";
import { login, register} from "../api/authApi";

export const useAuthentication = () => {
	const [user, setUser] = useState(null);
	const [error, setError] = useState(null);
	const [loading, setLoading] = useState(false);

	const loginUser = async (userName, password) => {
		const data = await login(userName,password);

		localStorage.setItem("token", data.token);
		setUser(data);
	}

	const registerUser = async (userName, password) => {
		try {
			const res = await register(userName, password);

			localStorage.setItem("token", res.token);
			setUser(res.user);
			
			return res;
		} catch (err) {
			setError(err.message || "failed register");
			throw err;
		} finally {
			setLoading(false);
		}
	}

	const logout = () => {
		localStorage.removeItem("token");
		setUser(null);
	}

	const getToken = () => {
		return localStorage.getItem("token");
	}

	const isAuthenticated = () => {
		return !!localStorage.getItem("token");
	}

	return {
		user,
		loginUser,
		registerUser,
		error,
		loading,
		logout,
		getToken,
		isAuthenticated
	}
}