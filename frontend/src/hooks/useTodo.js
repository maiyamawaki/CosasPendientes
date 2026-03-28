import { useEffect,useState } from "react";
import { getAllTodo, registerTodo } from "../api/todoApi";

export const useTodo = (token) => {
	const [todos, setTodos] = useState([]);
	const [loading, setLoading] = useState(true);
	const [error, setError] = useState(null);

	const register = async(contents) => {
		try {
			const res = await registerTodo(contents, token);

			setTodos(prev => [...prev, res]);
		
			return res;
		} catch (err) { 
			setError(err.message || "failed todo register");
			throw err;
		} 
	}

	useEffect(()=>{
		const loadTodos = async () => {
			try{
				const data = await getAllTodo(token);
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

	return {todos, loading, error, register};
}