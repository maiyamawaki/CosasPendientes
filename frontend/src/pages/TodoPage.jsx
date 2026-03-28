import Header from "../components/Header";
import Todo from "../components/Todo";
import RegisterTodo from "../components/RegisterTodo";
import { useState } from "react";
import { useTodo } from "../hooks/useTodo";

function TodoPage() {

	const token = localStorage.getItem("token");

	const [contents, setContents] = useState("");

	const {register, todos} = useTodo(token);

	const handleSubmit = async(e) => {
		e.preventDefault();
		console.log("token in TodoPage:", token);
		try {
			await register(contents);
			setContents("");
		}catch(err) {
			console.log(err);
		}
	}

	return (
		<div>
			<Header />
			<RegisterTodo 
				contents={contents} 
				setContents={setContents}
				onSubmit={handleSubmit}
			/>
			<Todo token={token} todos={todos} />
		</div>
	)
}

export default TodoPage;