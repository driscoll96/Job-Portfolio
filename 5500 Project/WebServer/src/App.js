import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import SkiResortApp from './components/SkiResortApp';
import ListAllLifts from './components/liftcomps/ListAllLifts';
import LiftById from './components/liftcomps/LiftById';
import ListMostLifts from './components/liftcomps/ListMostLifts';
import ListLeastLifts from './components/liftcomps/ListLeastLifts';
import MostBaseLift from './components/liftcomps/MostBaseLift';
import LeastBaseLift from './components/liftcomps/LeastBaseLift';
import ListAllRides from './components/ridecomps/ListAllRides';
import ListAllSkiers from './components/skiercomps/ListAllSkiers';
import RideById from './components/ridecomps/RideById';
import SkierById from './components/skiercomps/SkierById';
import ListMostLiftsDay from './components/liftcomps/ListMostLiftsDay';
import ListLeastLiftsDay from './components/liftcomps/ListLeastLiftsDay';
import MostBaseLiftDay from './components/liftcomps/MostBaseLiftDay';
import LeastBaseLiftDay from './components/liftcomps/LeastBaseLiftDay';
import ListAllRidesDay from './components/ridecomps/ListAllRidesDay';
import ListAllSkiersDay from './components/skiercomps/ListAllSkiersDay';
import LiftByIdDay from './components/liftcomps/LiftByIdDay';

class App extends Component {
  render() {
    return (
      <div className="container">
        <Router>
        <Switch>
          <Route path='/' exact={true} component={SkiResortApp}/>
          <Route path='/lifts' exact={true} component={ListAllLifts}/>
          <Route path='/lifts/most' exact={true} component={ListMostLifts}/>
          <Route path='/:day/lifts/most' exact={true} component={ListMostLiftsDay}/>
          <Route path='/lifts/least' exact={true} component={ListLeastLifts}/>
          <Route path='/:day/lifts/least' component={ListLeastLiftsDay}/>
          <Route path='/lifts/base/most' exact={true} component={MostBaseLift}/>
          <Route path='/:day/lifts/base/most' component={MostBaseLiftDay}/>
          <Route path='/lifts/base/least' exact={true} component={LeastBaseLift}/>
          <Route path='/:day/lifts/base/least' component={LeastBaseLiftDay}/>
          <Route path='/rides' exact={true} component={ListAllRides}/>
          <Route path='/:day/rides' component={ListAllRidesDay}/>
          <Route path='/skiers' exact={true} component={ListAllSkiers}/>
          <Route path='/:day/skiers' component={ListAllSkiersDay}/>
          <Route path='/:day/lift/:id' component={LiftByIdDay}/>
          <Route path='/lift/:id' component={LiftById}/>
          <Route path='/:day/rides/:id' component={RideById}/>
          <Route path='/:day/skier/:id' component={SkierById}/>
        </Switch>
      </Router>
      </div>
    );
  }
}

export default App;
