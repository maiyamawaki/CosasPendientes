import { useState } from "react";
import { login } from "../api/authApi";

export const useAuthentication = () => {
	const [user, setUser] = useState(null);

	const loginUser = async (userId, password) => {
		const data = await login(userId,password);

		localStorage.setItem("token", data.token);
		setUser(data);
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
		logout,
		getToken,
		isAuthenticated
	}
}