import React, { Component } from 'react'
import '../List.css';
import { Link } from 'react-router-dom'
import Background from '../sky.jpg';

var style = {
    width: "100%",
    backgroundImage: "url(" + Background + ")"
  };

class ListAllRides extends Component {

    state = {
        isLoading: true,
        rides: []
    };

    async componentDidMount() {
        const response = await fetch(`/${this.props.match.params.day}/rides`);
        const body = await response.json();
        this.setState({ rides: body, isLoading: false });
      }

      render() {
        const {rides, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        return (
        <div className="container" style={ style }>
        <h3 style={{color:'white'}}>All Rides</h3>
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th style={{color:'white'}}>ID</th>
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


export default ListAllRides