import React, { Component } from 'react'
import '../List.css';
import { Link } from 'react-router-dom'
import Background from '../sky.jpg';

var style = {
    width: "100%",
    height: "965px",
    backgroundImage: "url(" + Background + ")"
  };

class MostBaseLift extends Component {

    state = {
        isLoading: true,
        lifts: []
    };

    async componentDidMount() {
        const response = await fetch(`/${this.props.match.params.day}/lifts/base/most`);
        const body = await response.json();
        this.setState({ lifts: body, isLoading: false });
      }
    
    checkNullList(rides) {
        if (rides == null) {
            return 0;
        } else {
            return rides.length;
        }
    }

      render() {
        const {lifts, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        return (
        <div className="container" style={ style }>
        <h3 style={{color:'white'}}>All Lifts</h3>
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th style={{color:'white'}}>Id</th>
                        <th style={{color:'white'}}>Total Rides</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.lifts.map(
                            lift =>
                                <tr key={lift.id}>
                                    <td style={{color:'white'}}>{lift.id}</td>
                                    <td style={{color:'white'}}>{this.checkNullList(lift.rides)}</td>
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


export default MostBaseLift