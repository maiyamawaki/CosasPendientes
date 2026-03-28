const BASE_URL = "http://localhost:8080";

export const getAllTodo = async(token) => {
	const response = await fetch(`${BASE_URL}/todo`,{
		headers: {
			"Authorization":`Bearer ${token}`,
		},
	});

	if(!response.ok) {
		throw new Error("failed");
	}

	return response.json();
}

export const registerTodo = async(contents, token) => {
	const response = await fetch(`${BASE_URL}/todo`, {
		method : "POST",
		headers : {
			"Content-Type" : "application/json",
			"Authorization":`Bearer ${token}`,},
		body : JSON.stringify({contents}),
	})

	if(!response.ok) {
		throw new Error("todo register failed");
	}

	return response.json();
}