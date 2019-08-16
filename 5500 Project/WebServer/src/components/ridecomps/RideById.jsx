import React, { Component } from 'react'
import '../List.css';
import { Link } from 'react-router-dom'
import Background from '../sky.jpg';

var style = {
    width: "100%",
    height: "965px",
    backgroundImage: "url(" + Background + ")"
  };

class RideById extends Component {

    state = {
        isLoading: true,
        rides: [] 
    };

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            try {
              const response = await (await fetch(`/${this.props.match.params.day}/rides/${this.props.match.params.id}`, {credentials: 'include'})).json();
              this.setState({rides: response, isLoading: false });
            } catch (error) {
              this.props.history.push('/');
            }
          }
      }

      render() {
        const {rides, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        return (
        <div className="container" style={ style }>
        <h3 style={{color:'white'}}>Rides By Skier ID</h3>
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th style={{color:'white'}}>ID</th>
                        <th style={{color:'white'}}>Skier ID</th>
                        <th style={{color:'white'}}>Lift ID</th>
                        <th style={{color:'white'}}>Ride Time</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.rides.map(
                            ride =>
                                <tr key={ride.id}>
                                    <td style={{color:'white'}}>{ride.id}</td>
                                    <td style={{color:'white'}}>
                                        <Link to={`/skier/${ride.skier.id}`}>
                                            {ride.skier.id}
                                        </Link>
                                    </td>
                                    <td style={{color:'white'}}>
                                        <Link to={`/lift/${ride.lift.id}`}>
                                            {ride.lift.id}
                                        </Link>
                                    </td>
                                    <td style={{color:'white'}}>{ride.time}</td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
            <Link to="/">
                <button type="button">
                    Main Menu
                </button>
            </Link>
        </div>
    </div>
            )
                }
      }


export default RideById