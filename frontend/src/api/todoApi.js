const BASE_URL = "http://localhost:8080";

export const todo = async(token) => {
	const response = await fetch(`${BASE_URL}/todo`,{
		headers: {
			"Authorization":`Bearer ${token}`,
		},
	});

	if(!response.ok) {
		return new Error("failed");
	}

	return response.json();
}