
import React, { Component } from "react";

export default class AddContact extends Component {


    submitContact(event) {
        event.preventDefault();

        let contact = {
            firstName: this.refs.firstName.value,
            lastName: this.refs.lastName.value,
            email: this.refs.email.value
        }

        fetch("http://localhost:8080/api/contacts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(contact)
        })
            .then(resp => resp.json());
        window.location.reload();
    }

    render() {

        return (
            <div className="row" onSubmit={this.submitContact.bind(this)}>
                <form className="col s6">
                    <div className="row">
                        <div className="input-field col s6">
                            <i className="material-icons prefix">account_circle</i>
                            <input ref="firstName" type="text" className="validate" />
                            <label htmlFor="firstName">First Name</label>
                        </div>
                        <div className="input-field col s6">
                            <input ref="lastName" type="text" className="validate" />
                            <label htmlFor="lastName">Last Name</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s6">
                            <i className="material-icons prefix">email</i>
                            <input ref="email" type="email" className="validate" />
                            <label htmlFor="email">Email</label>
                            <span className="helper-text" data-error="Invalid" data-success="Valid">abc@xyz.com</span>

                        </div>
                    </div>

                    <div className="row">
                        <button className="waves-light btn btn-primary" type="submit" name="action">Submit</button>
                    </div>
                </form>
            </div>
        )
    }
}
