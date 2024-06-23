import React from 'react';
import LoginForm from '../../Components/LoginForm/LoginForm';
import SignUpForm from '../../Components/SignUpForm/SignUpForm';
import { useState } from 'react';

export default function AuthPage({ setUser }) {

	const [formSwitch, setFormSwitch] = useState(false);
	const [displayFormName, setDisplayFormName] = useState([`Don't have an account?`, 'SignUp']);

	const swapForm = () => {
		formSwitch ?
			setDisplayFormName([`Don't have an account?`, 'SignUp'])
			:
			setDisplayFormName([`Have an account already?`, 'Login'])
		setFormSwitch(!formSwitch);
	}

	return (
		<div>
			{formSwitch
				?
				<SignUpForm setUser={setUser} />
				:
				<LoginForm setUser={setUser} />
			}
			<div>{displayFormName[0]}</div>
			<button onClick={swapForm}>{displayFormName[1]}</button>
		</div>
	);
}