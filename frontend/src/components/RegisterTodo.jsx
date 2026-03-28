const RegisterTodo = ({
	onSubmit,
	contents,
	setContents
}) => {
	return(
		<form onSubmit={onSubmit}>
			<div>
				<label>Todo</label>
				<textarea value={contents} onChange={(e)=>setContents(e.target.value)}></textarea>
				<button type="submit">Submit</button>
			</div>
		</form>
	)
}

export default RegisterTodo;