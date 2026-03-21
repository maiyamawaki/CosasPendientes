const BASE_URL = "http://localhost:8080";

export const login = async(userId, password) => {
	const response = await fetch(`${BASE_URL}/auth/login`, {
		method : "POST",
		headers : {
			"Content-Type" : "application/json"
		},
		body : JSON.stringify({
			userId,
			password
		})
	});
	if(!response.ok) {
		return new Error("failed");
	}

	return response.json();
}