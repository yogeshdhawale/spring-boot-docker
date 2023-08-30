import React, { Component } from 'react';
import AddContact from './AddContact';

export default class AddContactView extends Component {
    constructor(props) {
        super(props);
        this.state = {
            contacts: [],
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/contacts', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        })
            .then(res => res.json())
            .then(data => this.setState({ contacts : data }))
    }

    render() {
        return (
            <div className="row">
                <AddContact />
            </div>

        )
    }
}