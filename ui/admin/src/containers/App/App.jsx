import React from 'react';
import appRoutes from "../../routes/app.jsx";
import {Redirect, Route, Switch} from "react-router-dom";
import {withStyles} from "material-ui";
import appStyle from "../../variables/styles/appStyle.jsx";
import logo from "../../assets/img/reactlogo.png";
import image from "../../assets/img/sidebar-2.jpg";
import Sidebar from "../../components/Sidebar/Sidebar";

const switchRoutes = (
    <Switch>
        {appRoutes.map((prop, key) => {
            if (prop.redirect) {
                return <Redirect from={prop.path} to={prop.to} key={key}/>;
            }

            return <Route path={prop.path} component={prop.component} key={key} />;
        })}
    </Switch>
);

class App extends React.Component {
    state = {
        mobileOpen: false
    };

    handleDrawerToggle = () => {
        this.setState({ mobileOpen: !this.state.mobileOpen });
    };

    render() {
        const { classes, ...rest } = this.props;
        return (
            <div className={classes.wrapper}>
                <Sidebar
                    routes={appRoutes}
                    logoText={"Creative Tim"}
                    logo={logo}
                    image={image}
                    handleDrawerToggle={this.handleDrawerToggle}
                    open={this.state.mobileOpen}
                    color="blue"
                    {...rest}
                />
                <div className={classes.mainPanel} ref="mainPanel">

                    <div className={classes.content}>
                        <div className={classes.container}>{switchRoutes}</div>
                    </div>



                </div>
            </div>
        );
    }
}

export default withStyles(appStyle)(App);