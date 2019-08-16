import React, { Component } from 'react'
import Dropdown from 'react-bootstrap/Dropdown';
import { Link } from 'react-router-dom'
import DropdownButton from 'react-bootstrap/DropdownButton'
import './List.css';

class QueryList extends Component {

    constructor(props) {
        super(props)
        this.state = {
           ID: 0, day: 'Friday'
        }
        this.handleIDChange = this.handleIDChange.bind(this)
        this.handleDayChange = this.handleDayChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleIDChange(e) {
        this.setState({[e.target.name] : e.target.value});
    }

    handleDayChange(e) {
        this.setState({[e.target.name] : e.target.value});
    }

    handleSubmit(event) {
        alert('Day Chosen: ' + this.state.day);
        event.preventDefault();
      }

    render() {
        return (
            <div className="container">
                <h3 style={{color:'white'}}>Specify Day and Select Query Type from the Dropdown Menus</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th style={{color:'white'}}>Data Types</th>
                                <th style={{color:'white'}}>Day of the Week</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <Dropdown>
                                        <DropdownButton drop='right' variant="primary" title={` Ski Lifts `} id={`dropdown-button-ski-lifts`} key='ski-lifts'>
                                        <thead>
                                            <tr>
                                                <th>All Days</th>
                                                <th>Single Day</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <Link to="/lifts">
                                                        <button type="button">
                                                            All Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <Link to="/lifts/most">
                                                        <button type="button">
                                                            Most Used Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                                <td>
                                                    <Link to={`/${this.state.day}/lifts/most`}>
                                                        <button type="button">
                                                            Most Used Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <Link to="/lifts/least">
                                                        <button type="button">
                                                            Least Used Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                                <td>
                                                    <Link to={`/${this.state.day}/lifts/least`}>
                                                        <button type="button">
                                                            Least Used Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <Link to="/lifts/base/most">
                                                        <button type="button">
                                                            Most Used Base Lift
                                                        </button>
                                                    </Link>
                                                </td>
                                                <td>
                                                    <Link to={`/${this.state.day}/lifts/base/most`}>
                                                        <button type="button">
                                                            Most Used Base Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <Link to="/lifts/base/least">
                                                        <button type="button">
                                                            Least Used Base Lift
                                                        </button>
                                                    </Link>
                                                </td>
                                                <td>
                                                    <Link to={`/${this.state.day}/lifts/base/least`}>
                                                        <button type="button">
                                                            Least Used Base Lifts
                                                        </button>
                                                    </Link>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <form>
                                                            <label>
                                                                Lift By ID:
                                                                <input type="text" name="ID" placeholder="ID" value={this.state.ID} onChange={this.handleIDChange} />
                                                            </label>
                                                            <Link to={`/lift/${this.state.ID}`}>
                                                                <button type="button">
                                                                    Search
                                                                </button>
                                                            </Link> 
                                                    </form>
                                                </td>
                                                <td>
                                                    <form>
                                                            <label>
                                                                Lift By ID:
                                                                <input type="text" name="ID" placeholder="ID" value={this.state.ID} onChange={this.handleIDChange} />
                                                            </label>
                                                            <Link to={`/${this.state.day}/lift/${this.state.ID}`}>
                                                                <button type="button">
                                                                    Search
                                                                </button>
                                                            </Link> 
                                                    </form>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </DropdownButton>
                                    </Dropdown>
                                </td>
                                <td>
                                    <form onSubmit={this.handleSubmit}>
                                        <select value={this.state.value} name="day" placeholder="Day" onChange={this.handleDayChange}>
                                            <option value="Friday">Friday</option>
                                            <option value="Saturday">Saturday</option>
                                            <option value="Sunday">Sunday</option>
                                        </select>
                                        <input type="submit" value="Submit" />
                                    </form>
                                    <h8 style={{color:'white'}}>(Click Submit to Change)</h8>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <Dropdown>
                                        <DropdownButton drop='right' variant="primary" title={` Lift Rides `} id={`dropdown-button-lift-rides`} key='lift-rides'>
                                            <thead>
                                                <tr>
                                                    <th>All Days</th>
                                                    <th>Single Day</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <Link to="/rides">
                                                            <button type="button">
                                                                All Rides
                                                            </button>
                                                        </Link>
                                                    </td>
                                                    <td>
                                                        <Link to={`/${this.state.day}/rides`}>
                                                            <button type="button">
                                                                All Rides
                                                            </button>
                                                        </Link>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                    </td>
                                                    <td>
                                                        <form>
                                                                <label>
                                                                    Ride By Skier ID:
                                                                    <input type="text" name="ID" placeholder="ID" value={this.state.ID} onChange={this.handleIDChange} />
                                                                </label>
                                                                <Link to={`/${this.state.day}/rides/${this.state.ID}`}>
                                                                    <button type="button">
                                                                        Search
                                                                    </button>
                                                                </Link> 
                                                        </form>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </DropdownButton>
                                    </Dropdown>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <Dropdown>
                                        <DropdownButton drop='right' variant="primary" title={` Skiers `} id={`dropdown-button-skiers`} key='skiers'>
                                            <thead>
                                                <tr>
                                                    <th>All Days</th>
                                                    <th>Single Day</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <Link to="/skiers">
                                                            <button type="button">
                                                                All Skiers
                                                            </button>
                                                        </Link>
                                                    </td>
                                                    <td>
                                                        <Link to={`/${this.state.day}/skiers`}>
                                                            <button type="button">
                                                                All Skiers
                                                            </button>
                                                        </Link>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td>
                                                        <form>
                                                                <label>
                                                                    Skier By ID:
                                                                    <input type="text" name="ID" placeholder="ID" value={this.state.ID} onChange={this.handleIDChange} />
                                                                </label>
                                                                <Link to={`/${this.state.day}/skier/${this.state.ID}`}>
                                                                    <button type="button">
                                                                        Search
                                                                    </button>
                                                                </Link> 
                                                        </form>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </DropdownButton>
                                    </Dropdown>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default QueryList