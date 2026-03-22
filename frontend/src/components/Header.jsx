import { useNavigate } from "react-router-dom";
import { useAuthentication } from "../hooks/useAuthentication";

function Header() {
	const {logout, isAuthenticated} = useAuthentication();
	const navigate = useNavigate();

	return (
		<header>
			<h2>CosasPendientes</h2>
			{isAuthenticated() ? (
				<button onClick={()=>{
					logout();
					navigate("/login");
				}}>Logout</button>
			) : (
				<div>
					<button onClick={()=>navigate("/login")}>Login</button>
					<button onClick={()=>navigate("/register")}>Register</button>
				</div>
			)}
			{}


		</header>
	)

}

export default Header;