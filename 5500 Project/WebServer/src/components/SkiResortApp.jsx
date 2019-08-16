import React, { Component } from 'react';
import QueryList from './QueryList';
import Background from '../backgski.png'

var style = {
    width: "100%",
    height: "965px",
    backgroundImage: "url(" + Background + ")"
  };

class SkiResortApp extends Component {
    render() {
        return (
            <div className="container" style={ style }>
                <h1 style={{color:'white'}}>Ski Resort Application</h1>
                <QueryList />
            </div>
        )
    }
}

export default SkiResortApp