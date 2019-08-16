import React, { Component } from 'react'
import '../List.css';
import { Link } from 'react-router-dom'
import Background from '../sky.jpg';

var style = {
    width: "100%",
    backgroundImage: "url(" + Background + ")"
  };

class ListAllSkiers extends Component {
    state = {
        isLoading: true,
        skiers: []
    };

    async componentDidMount() {
        const response = await fetch('/skiers');
        const body = await response.json();
        this.setState({ skiers: body, isLoading: false });
      }

    checkNullList(rides) {
        if (rides == null) {
            return 0;
        } else {
            return rides.length;
        }
    }

      render() {
        const {skiers, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        return (
        <div className="container" style={ style }>
        <h3 style={{color:'white'}}>All Skiers</h3>
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th style={{color:'white'}}>Skier ID</th>
                        <th style={{color:'white'}}>Total Lifts Ridden</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.skiers.map(
                            skier =>
                                <tr key={skier.id}>
                                    <td style={{color:'white'}}>{skier.id}</td>
                                    <td style={{color:'white'}}>{this.checkNullList(skier.rides)}</td>
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


export default ListAllSkiers