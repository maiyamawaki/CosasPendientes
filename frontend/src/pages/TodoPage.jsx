import Header from "../components/Header";
import Todo from "../components/Todo";

function TodoPage({token}) {

	return (
		<div>
			<Header />
			<Todo token={token} />
		</div>
	)
}

export default TodoPage;