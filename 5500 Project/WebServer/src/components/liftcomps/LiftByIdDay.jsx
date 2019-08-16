import React, { Component } from 'react'
import '../List.css';
import { Link } from 'react-router-dom'
import Background from '../sky.jpg';

var style = {
    width: "100%",
    height: "965px",
    backgroundImage: "url(" + Background + ")"
  };

class LiftByIdDay extends Component {
    
    state = {
        isLoading: true,
        lifts: []
    };

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            try {
              const response = await (await fetch(`/${this.props.match.params.day}/lift/${this.props.match.params.id}`, {credentials: 'include'})).json();
              this.setState({lift: response, isLoading: false });
            } catch (error) {
              this.props.history.push('/');
            }
          }
      }

    checkNullList(rides) {
        if (rides == null) {
            return 0;
        } else {
            return rides.length;
        }
    }

      render() {
        const {lift, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
          }
    
        return (
        <div className="container" style={ style }>
        <h3 style={{color:'white'}}>Lift By ID</h3>
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
                        
                        <tr key={this.state.lift.id}>
                            <td style={{color:'white'}}>{this.state.lift.id}</td>
                            <td style={{color:'white'}}>{this.checkNullList(lift.rides)}</td>
                        </tr>
                        
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


export default LiftByIdDay