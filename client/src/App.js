
import React, { useState } from 'react';
import './App.css';
import ContactsView from './components/ContactsView';
import AddContactView from './components/AddContactView';
import { Tab, Tabs, Typography, Box } from "@material-ui/core";


const Panel = (props) => (
  <div hidden={props.value !== props.index}>
    <Typography component={"div"}>{props.children}</Typography>
  </div>
);

const TabList = ['View All Contacts', 'Add Contact', 'View Contact', 'Delete Contact'];

function App() {

  const [index, setIndex] = useState(0);
  const onTabClicked = (event, index) => {
    setIndex(index);
  };

  return (
    <Box>
      <Tabs textColor="primary" indicatorColor="primary" value={index} onChange={onTabClicked}>
        <Tab label={TabList[0]} />
        <Tab label={TabList[1]} />
        <Tab label={TabList[2]} />
        <Tab label={TabList[3]} />
      </Tabs>

      <Panel value={index} index={0}>
        <nav>
          <div className="nav-wrapper center-align">
            <a href="#!" className="brand-logo">Contacts</a>
          </div>
          <div className="row">
            <ContactsView />
          </div>
        </nav>
      </Panel>
      <Panel value={index} index={1}>
        <div>
          <div className="row">
            <AddContactView />
          </div>
        </div>
      </Panel>
      <Panel value={index} index={2}>
        TODO 2
      </Panel>
      <Panel value={index} index={3}>
        TODO 3
      </Panel>

    </Box>
  );
}

export default App;
