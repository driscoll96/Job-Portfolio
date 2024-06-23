import './App.css';
import React, { useState, createContext } from 'react';
import * as UserService from './Services/Api/user-api';
import AuthPage from './Pages/AuthPage/AuthPage'
import NavBar from './Components/NavBar/NavBar'
import DashboardPage from './Pages/DashboardPage/DashboardPage';
import OtherProfilePage from './Pages/OtherProfilePage/OtherProfilePage';
import PurchasePage from './Pages/PurchasePage/PurchasePage';
import AddPaymentMethodPage from './Pages/AddPaymentMethodPage/AddPaymentMethodPage';
import AddAddressPage from './Pages/AddAddressPage/AddAddressPage';
import LandingPage from './Pages/LandingPage/LandingPage';
import { Route, Switch, Redirect } from 'react-router-dom';

export let userContext = createContext();

export default function App() {
	const [user, setUser] = useState(false);
	const [otherUser, setOtherUser] = useState(false);

	const getUserById = async (id, callback) => {
		const userById = await UserService.getUserById(id);
		userContext.value = userById
		callback(userById);
	}

	const handleLogin = async (id) => {
		getUserById(id, setUser)
	}

	const handleGetOtherUserProfile = async (evt, matchedUser) => {
		evt.preventDefault();
		setOtherUser(matchedUser);
	}

	return (
		<div className="App">
			{user ? (
				<userContext.Provider value={user}>
					<NavBar handleGetOtherUserProfile={handleGetOtherUserProfile} setUser={setUser} />
					<Switch>
						<Route path="/dashboard">
							<DashboardPage user={user} handleGetOtherUserProfile={handleGetOtherUserProfile} />
						</Route>
						<Route path="/user">
							<OtherProfilePage user={user} otherUser={otherUser} />
						</Route>
						<Route exact path={`/user/${user.username}`}>
							<h1>SelfProfilePage</h1>
						</Route>
						<Route path={`/profile/${user.username}`}>
							<h1>SelfProfilePage</h1>?
						</Route>
						<Route path={`/account/${user.username}`}>
							<h1>accountPage</h1>
						</Route>
						<Route path={`/purchase/`}>
							<PurchasePage />
						</Route>
						<Route path={`/paymentmethod/`}>
							<AddPaymentMethodPage />
						</Route>
						<Route path={`/updateaddress/`}>
							<AddAddressPage />
						</Route>
						<Redirect to="/dashboard" />
					</Switch>
				</userContext.Provider>
			) : (
				<userContext.Provider value={user}>
					<Switch>
						<Route path="/getinhere">
							<AuthPage setUser={setUser} />
						</Route>
						<Route path="/welcome">
							<LandingPage setUser={setUser} />
						</Route>
						<Redirect to="/getinhere" />
					</Switch>
					<button onClick={() => getUserById(7, setUser)}>Fake Login MickeyRourkesFace</button>
					<button onClick={() => getUserById(8, setUser)}>Fake Login wizzy</button>
					<button onClick={() => getUserById(9, setUser)}>ANALFARMER2</button>
				</userContext.Provider>
			)}
		</div>
	)
}