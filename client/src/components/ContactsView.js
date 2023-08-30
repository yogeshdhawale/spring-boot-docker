import React, { Component } from 'react';
import SingleContact from './SingleContact';

export default class ContactsView extends Component {
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
            }
        })
            .then(res => res.json())
            .then(data => this.setState({ contacts: data }))
    }

    render() {
        return (
            <div className="row">
                {this.state.contacts.map((item) => (
                    <SingleContact key={item.id} item={item} />
                ))}
            </div>
        )
    }
}