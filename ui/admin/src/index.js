import React from "react";
import App from "./containers/App/App.jsx";
import { createBrowserHistory } from "history";
import {Router} from "react-router-dom";
import * as ReactDOM from "react-dom";
import { withRouter } from 'react-router-dom';

const hist = createBrowserHistory();
const AppRouter = withRouter(App);

ReactDOM.render(
    <Router history={hist}>
        <AppRouter/>
    </Router>,
    document.getElementById("root")
);