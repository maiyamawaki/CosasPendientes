const BASE_URL = "http://localhost:8080";

export const login = async(userName, password) => {
	const response = await fetch(`${BASE_URL}/auth/login`, {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify({
			userName,
			password
		})
	});
	if(!response.ok) {
		return new Error("login failed");
	}

	return response.json();
}

export const register = async(userName, password) => {
	const response = await fetch(`${BASE_URL}/auth/register`, {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify({userName, password}),
	});

	if(!response.ok) {
		return new Error("register failed");
	} 

	return response.json();
}