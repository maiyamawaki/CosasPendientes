const RegisterForm = ({
	userName,
	password,
	setUserName,
	setPassword,
	onSubmit,
	loading
}) => {
	return (
		<form onSubmit={onSubmit}>
			<div>
				<label>userName</label>
				<input type="text" value={userName} onChange={(e)=>setUserName(e.target.value)} />
				<label>Password</label>
				<input type="password" value={password} onChange={(e)=>setPassword(e.target.value)} />
				<button type="submit" disabled={loading}>
					{loading? "registering" : "registered"}
				</button>
			</div>
		</form>
	);
}

export default RegisterForm;