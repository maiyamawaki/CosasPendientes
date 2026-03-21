import { useEffect,useState } from "react";
import { todo } from "../api/todoApi";

export const useTodo = (token) => {
	const [todos, setTodos] = useState();
	const [loading, setLoading] = useState(true);
	const [error, setError] = useState(null);

	useEffect(()=>{
		const loadTodos = async () => {
			try{
				const data = await todo(token);
				setTodos(data);
			} catch(err) {
				setError(err);
			} finally {
				setLoading(false);
			}
		}

		if(token) {
			loadTodos();
		}
	}, [token]);

	return {todos, loading, error};
}