import { useTodo } from "../hooks/useTodo";

function Todo({token}) {
	const {todos, error} = useTodo(token);


	if(error) {
		return <p>Error : {error}</p>
	}

	return (
		<div>
			{todos.length===0? (
				<p>none</p>
			) : (
				todos.map((todo)=> (
					<div key={todo.todoId}>
						<p>{todo.contents}</p>
					</div>
				))
			)}
		</div>
	)
}

export default Todo;